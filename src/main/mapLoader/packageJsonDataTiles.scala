package mapLoader
import play.api.libs.json.{JsValue, Json}

object packageJsonDataTiles {

  val terrainMap: Array[Array[String]] = Array.ofDim[String](10,10)



  terrainMap(0)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(0) = toJsonTerrain("water",passable = false)
  terrainMap(2)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(0) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(0) = toJsonTerrain("wall",passable = false)
  terrainMap(8)(0) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(0) = toJsonTerrain("wall",passable = false)

  terrainMap(0)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(1) = toJsonTerrain("water",passable = false)
  terrainMap(2)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(1) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(1) = toJsonTerrain("wall",passable = false)
  terrainMap(8)(1) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(1) = toJsonTerrain("wall",passable = false)

  terrainMap(0)(2) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(2) = toJsonTerrain("water",passable = false)
  terrainMap(2)(2) = toJsonTerrain("wall",passable = false)
  terrainMap(3)(2) = toJsonTerrain("wall",passable = false)
  terrainMap(4)(2) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(2) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(2) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(2) = toJsonTerrain("grass",passable=true)
  terrainMap(8)(2) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(2) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(3) = toJsonTerrain("bridge",passable=true)
  terrainMap(2)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(3) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(8)(3) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(3) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(4) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(4) = toJsonTerrain("water",passable = false)
  terrainMap(2)(4) = toJsonTerrain("wall",passable = false)
  terrainMap(3)(4) = toJsonTerrain("wall",passable = false)
  terrainMap(4)(4) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(4) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(4) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(4) = toJsonTerrain("grass",passable=true)
  terrainMap(8)(4) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(4) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(5) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(5) = toJsonTerrain("water",passable = false)
  terrainMap(2)(5) = toJsonTerrain("wall",passable = false)
  terrainMap(3)(5) = toJsonTerrain("wall",passable = false)
  terrainMap(4)(5) = toJsonTerrain("water" ,passable = false)
  terrainMap(5)(5) = toJsonTerrain("water",passable = false)
  terrainMap(6)(5) = toJsonTerrain("water",passable = false)
  terrainMap(7)(5) = toJsonTerrain("water",passable = false)
  terrainMap(8)(5) = toJsonTerrain("bridge",passable=true)
  terrainMap(9)(5) = toJsonTerrain("water",passable = false)

  terrainMap(0)(6) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(6) = toJsonTerrain("water",passable = false)
  terrainMap(2)(6) = toJsonTerrain("wall",passable = false)
  terrainMap(3)(6) = toJsonTerrain("wall",passable = false)
  terrainMap(4)(6) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(6) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(6) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(6) = toJsonTerrain("grass",passable=true)
  terrainMap(8)(6) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(6) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(7) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(7) = toJsonTerrain("water",passable = false)
  terrainMap(2)(7) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(7) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(7) = toJsonTerrain("grass" ,passable=true)
  terrainMap(5)(7) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(7) = toJsonTerrain("wall",passable = false)
  terrainMap(7)(7) = toJsonTerrain("wall",passable = false)
  terrainMap(8)(7) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(7) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(8) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(8) = toJsonTerrain("water",passable = false)
  terrainMap(2)(8) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(8) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(8) = toJsonTerrain("wall" ,passable = false)
  terrainMap(5)(8) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(8) = toJsonTerrain("wall",passable = false)
  terrainMap(7)(8) = toJsonTerrain("wall",passable = false)
  terrainMap(8)(8) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(8) = toJsonTerrain("grass",passable=true)

  terrainMap(0)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(1)(9) = toJsonTerrain("water",passable = false)
  terrainMap(2)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(3)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(4)(9) = toJsonTerrain("wall" ,passable = false)
  terrainMap(5)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(6)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(7)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(8)(9) = toJsonTerrain("grass",passable=true)
  terrainMap(9)(9) = toJsonTerrain("grass",passable=true)


  def toJsonTerrain(terrainType:String, passable:Boolean): String ={
    val jsonTerrain:JsValue = Json.toJson(terrainType)
    val jsonPassable:JsValue = Json.toJson(passable)
    val jsonMap:Map[String, JsValue] = Map(
      "type" ->jsonTerrain,
      "passable" -> jsonPassable
    )
    Json.stringify(Json.toJson(jsonMap))
}
/////////////////////////////
  val mapWidth:JsValue = Json.toJson(10)
  val mapHeight:JsValue = Json.toJson(10)

  val jsonMapSize:Map[String, JsValue] = Map(
    "width" ->mapWidth,
    "height" -> mapHeight
  )
  val mapSize:String = Json.stringify(Json.toJson(jsonMapSize))
///////////////////////////////////

  val jsonMapSizeFinal:JsValue = Json.toJson(mapSize)
  val JsonTiles:JsValue = Json.toJson(terrainMap)

  val jsonMapInfo:Map[String, JsValue] = Map(
    "mapSize" ->jsonMapSizeFinal,
    "tiles" -> JsonTiles
  )

  val gameMap:String = Json.stringify(Json.toJson(jsonMapInfo))

  val jsonTerrain:String = """{"mapSize":"{\"width\":10,\"height\":10}","tiles":[["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"bridge\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"water\",\"passable\":false}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"bridge\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"],["{\"type\":\"wall\",\"passable\":false}","{\"type\":\"wall\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"water\",\"passable\":false}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}","{\"type\":\"grass\",\"passable\":true}"]]}
                             """




}