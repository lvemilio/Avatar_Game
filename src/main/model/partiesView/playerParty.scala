package model.partiesView

import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle
import mapLoader.packageJsonParties
import play.api.libs.json.{JsValue, Json}
import view.avatar_gui
import view.avatar_gui.player


class playerParty(partiesString:String) {
  val velocity:Int = 10
  val parsedParties: JsValue = Json.parse(partiesString)
  val playerPartyjson: String = (parsedParties \ "playerParty").as[String]
  val playerX: Double = (Json.parse(playerPartyjson) \ "location" \ "x").as[Double]
  val playerY: Double = (Json.parse(playerPartyjson) \ "location" \ "y").as[Double]
  var playerLevel:Int = (Json.parse(playerPartyjson) \ "level").as[Int]


  var playerAbsX:Double = playerX
  var playerAbsY:Double = playerY


  val player:Circle = new Circle{
    centerX = playerX
    centerY = playerY
    radius = 15
    fill = Color.Orange
  }
  def wPressed():Unit =  {
    player.centerY.value -= velocity
    playerAbsY-=velocity
  }
  def sPressed():Unit =  {
    player.centerY.value += velocity
    playerAbsY+=velocity
    println(packageJsonParties.playerPartyX,packageJsonParties.playerPartyY)

  }
  def aPressed():Unit =  {
    player.centerX.value -= velocity
    playerAbsX -=velocity

  }
  def dPressed():Unit =  {
    player.centerX.value += velocity
    playerAbsX +=velocity
  }
  //////////////////////////Enemies
  //////////////////////////

  val enemyPartiesjson: Array[String] = (parsedParties \ "otherParties").as[Array[String]]
  for (enemyParty <- enemyPartiesjson){
    val enemyX: Double = (Json.parse(enemyParty) \ "location" \ "x").as[Double]
    val enemyY: Double = (Json.parse(enemyParty) \ "location" \ "y").as[Double]

  }


}