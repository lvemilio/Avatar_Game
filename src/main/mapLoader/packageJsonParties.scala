package mapLoader
import play.api.libs.json.{JsValue, Json}

object packageJsonParties {

  var playerPartyX: Double = 50
  var playerPartyY: Double = 50

  val jsonThisPartyCoordMap: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(playerPartyX),
      "y" -> Json.toJson(playerPartyY))),
    "level" -> Json.toJson(3),
    "inBattle" -> Json.toJson(false)

  )
  val jsonEnemy1Coords: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(500),
      "y" -> Json.toJson(100))),
    "level" -> Json.toJson(8),
    "inBattle" -> Json.toJson(false)
  )
  val jsonEnemy2Coords: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(700),
      "y" -> Json.toJson(100))),
    "level" -> Json.toJson(1),
    "inBattle" -> Json.toJson(true)
  )
  val jsonEnemy3Coords: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(900),
      "y" -> Json.toJson(900))),
    "level" -> Json.toJson(3),
    "inBattle" -> Json.toJson(true)
  )
  val jsonEnemy4Coords: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(100),
      "y" -> Json.toJson(500))),
    "level" -> Json.toJson(10),
    "inBattle" -> Json.toJson(true)
  )
  val jsonEnemy5Coords: Map[String, JsValue] = Map(
    "location" -> Json.toJson(Map(
      "x" -> Json.toJson(500),
      "y" -> Json.toJson(900))),
    "level" -> Json.toJson(3),
    "inBattle" -> Json.toJson(false)
  )

  val thisPartyCoords: String = Json.stringify(Json.toJson(jsonThisPartyCoordMap))
  val enemy1Coords: String = Json.stringify(Json.toJson(jsonEnemy1Coords))
  val enemy2Coords: String = Json.stringify(Json.toJson(jsonEnemy2Coords))
  val enemy3Coords: String = Json.stringify(Json.toJson(jsonEnemy3Coords))
  val enemy4Coords: String = Json.stringify(Json.toJson(jsonEnemy4Coords))
  val enemy5Coords: String = Json.stringify(Json.toJson(jsonEnemy5Coords))


  val allEnParties:Array[String] = Array(enemy1Coords,enemy2Coords,enemy3Coords,enemy4Coords,enemy5Coords)
  val allEnPartiesJs: JsValue = Json.toJson(allEnParties)

  val allPartiesJs: Map[String, JsValue] = Map(
    "playerParty" -> Json.toJson(thisPartyCoords),
    "otherParties" -> allEnPartiesJs
  )

  val allPartiesJson: String = Json.stringify(Json.toJson(allPartiesJs))

  def main(args: Array[String]): Unit = {
    println(allPartiesJson)
  }
}
