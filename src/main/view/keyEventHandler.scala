package view

import javafx.scene.input.KeyCode
import scalafx.scene.input.MouseEvent
import scalafx.scene.shape.Circle
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import mapLoader.packageJsonParties.{playerPartyX, playerPartyY}
import model.partiesView.playerParty
import mapLoader.packageJsonParties

class keyEventHandler(player:playerParty) extends EventHandler[KeyEvent]{
  val playerSpeed: Int = 10
  override def handle(event: KeyEvent): Unit = {
    keyPressed(event.getCode)
  }
  def keyPressed(keyCode: KeyCode): Unit = {
    keyCode.getName match {
      case "W" => player.wPressed()
                  avatar_gui.update()
                  println(player.playerAbsX,player.playerAbsY)
      case "A" => player.aPressed()
                  avatar_gui.update()
                  println(player.playerAbsX,player.playerAbsY)
      case "S" => player.sPressed()
                  avatar_gui.update()
                  println(player.playerAbsX,player.playerAbsY)
      case "D" => player.dPressed()
                  avatar_gui.update()
                  println(player.playerAbsX,player.playerAbsY)
      case _ => println(keyCode.getName + " pressed with no action")
    }
  }
}
