package view

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Group, Scene}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Polygon, Rectangle}
import play.api.libs.json.{JsValue, Json}
import mapLoader._
import scalafx.animation.AnimationTimer
import javafx.scene.input.KeyEvent

import scala.collection.mutable.ListBuffer
import model.partiesView.playerParty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.scene.canvas.Canvas
import view.avatar_gui.{drawMapTiles, drawTile, generateEnemies}



object avatar_gui extends JFXApp {

  var windowWidth: Int = 1000
  var windowHeight: Int = 1000

  val tileSize: Int = 200
  val enemySize: Double = 25
  val player: playerParty = new playerParty(packageJsonParties.allPartiesJson)





  this.stage = new PrimaryStage {
    title = "Avatar The Last Airbender"
    resizable = false
    scene = new Scene(windowWidth, windowHeight)
    {
      content = List( drawMapTiles(packageJsonDataTiles.gameMap, 0, 4, 0, 4), player.player, generateEnemies(packageJsonParties.allPartiesJson,1))
    }
    addEventHandler(KeyEvent.KEY_PRESSED, new keyEventHandler(player))
  }


  ////////////////////////////Setting up map
  ////////////////////////////
  def redrawMap(playerPosX: Double, playerPosY: Double): Unit = {
    boundarieSetter()
    if (player.playerAbsX >= 1000 && player.playerAbsY <= 1000) {
      relativePosition1()
      this.stage.scene = new Scene(windowWidth, windowHeight) {
        content = List(drawMapTiles(packageJsonDataTiles.gameMap, 5, 9, 0, 4), player.player, generateEnemies(packageJsonParties.allPartiesJson,2))
      }
    }
    if (player.playerAbsX < 1000 && player.playerAbsY <= 1000) {
      relativePosition0()
      this.stage.scene = new Scene(windowWidth, windowHeight) {
        content = List(drawMapTiles(packageJsonDataTiles.gameMap, 0, 4, 0, 4), player.player, generateEnemies(packageJsonParties.allPartiesJson,1))
      }
    }
    if (player.playerAbsX < 1000 && player.playerAbsY > 1000) {
      relativePosition2()
      this.stage.scene = new Scene(windowWidth, windowHeight) {
        content = List(drawMapTiles(packageJsonDataTiles.gameMap, 0, 4, 5, 9), player.player, generateEnemies(packageJsonParties.allPartiesJson,4))
      }
    }
    if (player.playerAbsX > 1000 && player.playerAbsY > 1000) {
      relativePosition3()
      this.stage.scene = new Scene(windowWidth, windowHeight) {
        content = List(drawMapTiles(packageJsonDataTiles.gameMap, 5, 9, 5, 9), player.player, generateEnemies(packageJsonParties.allPartiesJson,3))
      }
    }
  }

  def drawMapTiles(jsonString: String, startCols: Int, endCols: Int, startRows: Int, endRows: Int): Group = {
    val mapTiles: Group = new Group()
    val parsedMap = Json.parse(jsonString)
    val mapSize: String = (parsedMap \ "mapSize").as[String]
    val tileArr: Array[Array[String]] = (parsedMap \ "tiles").as[Array[Array[String]]]

    for (i <- startCols to endCols; j <- startRows to endRows) {
      val parsedTile = Json.parse(tileArr(i)(j))
      val tileType: String = (parsedTile \ "type").as[String]
        if (tileType == "grass") {
          mapTiles.children.add(drawTile(i * tileSize, j * tileSize, Color.Green))
        }
        else if (tileType == "water") {
          mapTiles.children.add(drawTile(i * tileSize, j * tileSize, Color.Blue))
        }
        else if (tileType == "wall") {
          mapTiles.children.add(drawTile(i * tileSize, j * tileSize, Color.Grey))
        }
        else if (tileType == "bridge") {
          mapTiles.children.add(drawTile(i * tileSize, j * tileSize, Color.Brown))
        }
      }
    mapTiles
    }



  //////////////////////////
  //////////////////////////
  def update(): Unit = {
    redrawMap(packageJsonParties.playerPartyX,packageJsonParties.playerPartyY)
  }

  //////////////////////////////////////Setting enemies
  def generateEnemies(partiesString: String,mapArea:Int): Group = {
    val enemies1: Group = new Group()
    val enemies2:Group = new Group()
    val enemies3:Group = new Group()
    val enemies4:Group = new Group()
    val parsedParties = Json.parse(partiesString)
    val enemyParties = (parsedParties \ "otherParties").as[Array[String]]

    for (party <- enemyParties) {
      val playerPartyjson = (parsedParties \ "playerParty").as[String]
      val enemyPartyX = (Json.parse(party) \ "location" \ "x").as[Double]
      val enemyPartyY = (Json.parse(party) \ "location" \ "y").as[Double]
      val enemyPartyLevel = (Json.parse(party) \ "level").as[Double]
      val enemyBattleStatus = (Json.parse(party) \ "inBattle").as[Boolean]
      val playerLevel = (Json.parse(playerPartyjson) \ "level").as[Double]
      ///////////////////Generating enemies

      if (enemyBattleStatus) {
        val enemyPartyInBattle: Rectangle = new Rectangle() {
          width = enemySize / ((playerLevel / enemyPartyLevel))
          height = enemySize / ((playerLevel / enemyPartyLevel))
          if (width.toInt < 5) {
            width = 5
            height = 5
          }
          translateX = enemyPartyX
          translateY = enemyPartyY
          fill = Color.Red
        }
          if((enemyPartyX == 500 && enemyPartyY==100)||(enemyPartyX == 900&&enemyPartyY==900)) {
            enemies1.children.add(enemyPartyInBattle)
          }
          else if (enemyPartyX == 700 && enemyPartyY == 100){
            enemies2.children.add(enemyPartyInBattle)
          }
          else if (enemyPartyX==500 && enemyPartyY == 900){
            enemies3.children.add(enemyPartyInBattle)
          }
          else if ((enemyPartyX==100 && enemyPartyY == 500)||(enemyPartyX == 500 && enemyPartyY == 900)){
            enemies4.children.add(enemyPartyInBattle)
          }
      }
      else if (!enemyBattleStatus) {
        val enemyPartyNotInBattle: Rectangle = new Rectangle() {
          width = enemySize / ((playerLevel / enemyPartyLevel))
          height = enemySize / ((playerLevel / enemyPartyLevel))
          if (width.toInt < 5) {
            width = 5
            height = 5
          }
          translateX = enemyPartyX
          translateY = enemyPartyY
          fill = Color.Yellow
        }
          if((enemyPartyX == 500 && enemyPartyY==100)||(enemyPartyX == 900&&enemyPartyY==900)) {
            enemies1.children.add(enemyPartyNotInBattle)
          }
          else if (enemyPartyX == 700 && enemyPartyY == 100){
            enemies2.children.add(enemyPartyNotInBattle)
          }
          else if (enemyPartyX==500 && enemyPartyY == 900){
            enemies3.children.add(enemyPartyNotInBattle)
          }
          else if ((enemyPartyX==100 && enemyPartyY == 500)||(enemyPartyX == 500 && enemyPartyY == 900)){
            enemies4.children.add(enemyPartyNotInBattle)
          }
        }
      }
    if (mapArea == 1){
      enemies1
    }
    else if (mapArea == 2){
      enemies2
    }
    else if (mapArea == 3){
      enemies3
    }
    else{
      enemies4
    }
    }



  //////////////////////////
  //////////////////////////Drawing shapes
  def drawTile(posX: Int, posY: Int, shapeFill: Color): Rectangle = {
    var realX:Int = posX
    var realY:Int = posY
    if (realX>800){
      realX-=1000
    }
    if(realY>800){
      realY -=1000
    }
    new Rectangle() {
      width = tileSize
      height = tileSize
      translateX = realX
      translateY = realY
      fill = shapeFill
    }
  }



  def boundarieSetter()={
    if (player.playerAbsY <0){
      player.playerAbsY = 0
    }
    if (player.playerAbsY>2000){
      player.playerAbsY = 2000
    }
    if (player.playerAbsX<0){
      player.playerAbsX = 0
    }
    if (player.playerAbsX>2000){
      player.playerAbsX = 2000
    }
    if (player.player.centerX.value<0){
      player.player.centerX.value = 0
    }
    if (player.player.centerX.value>2000){
      player.player.centerX.value = 2000
    }
    if (player.player.centerY.value<0){
      player.player.centerY.value = 0
    }
    if (player.player.centerY.value>2000){
      player.player.centerY.value = 2000
    }
  }




  def relativePosition0() = {
    player.player.centerX.value = player.playerAbsX
    player.player.centerY.value = player.playerAbsY
  }

  def relativePosition1() = {
    if (player.playerAbsY<1000) {
      player.player.centerX.value = player.playerAbsX - 1000
      player.player.centerY.value = player.playerAbsY
    }
  }
  def relativePosition2() = {
    player.player.centerY.value = player.playerAbsY-1000
    player.player.centerX.value = player.playerAbsX
  }
  def relativePosition3() = {
    if (player.playerAbsX>1000 && player.playerAbsY>1000) {
      player.player.centerX.value = player.playerAbsX - 1000
      player.player.centerY.value = player.playerAbsY - 1000
    }
  }



}




