import characterClasses.{EarthBender, WaterBender}
import monsters_fightables.AngryWolfbat
import org.scalatest._

class waterBenderTests extends FunSuite{
  test("Initial stats are correct"){
    val katara:WaterBender = new WaterBender("Katara")
    assert(katara.maxHealth == 105 &&
      katara.maxChi == 105 &&
      katara.currentHealth == katara.maxHealth &&
      katara.currentChi == katara.maxChi &&
      katara.physicalAttack == 6 &&
      katara.bendingAttackPower == 23&&
      katara.resolve == 4 &&
      katara.maxXp == 100 &&
      katara.currentXp == 0&&
      katara.level == 1)
  }
  test("Initial battle options are correct"){
    val katara:WaterBender = new WaterBender("Katara")
    assert(katara.battleOptions() == List("Physical attack", "Bending attack", "Healing Water"))
  }
  test("Stats are increased after leveling up"){
    val katara:WaterBender = new WaterBender("Katara")
    katara.currentXp = 100
    katara.levelUp()
    assert(katara.maxHealth == 110 &&
      katara.maxChi == 112 &&
      katara.currentHealth == katara.maxHealth &&
      katara.currentChi == katara.maxChi &&
      katara.physicalAttack == 8 &&
      katara.bendingAttackPower == 26&&
      katara.resolve == 5 &&
      katara.maxXp == 100 &&
      katara.currentXp == 0&&
      katara.level == 2)
  }
  test("New battle options appear after level 6"){
    val katara:WaterBender = new WaterBender("Katara")
    katara.currentXp = 600
    katara.levelUp()
    assert(katara.battleOptions() == List("Physical attack", "Bending attack", "Healing Water", "Zenith"))
  }
  test("Basic battle options work"){
    val katara:WaterBender = new WaterBender("Katara")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat

    katara.takeAction(katara.battleOptions().head,wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 26)

    wolfbatDummie.currentHealth+=4
    katara.takeAction(katara.battleOptions()(1),wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 9 && katara.currentChi == 94)
  }

  test("Healing water restores health and cannot overheal"){
    val katara:WaterBender = new WaterBender("Katara")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat
    katara.currentHealth-=45
    katara.takeAction(katara.battleOptions()(2),katara)
    assert(katara.currentHealth == 83)
    katara.takeAction(katara.battleOptions()(2),katara)
    katara.takeAction(katara.battleOptions()(2),katara)
    assert(katara.currentHealth == 105)
    katara.currentHealth -=15
    katara.currentChi-=80
    katara.takeAction(katara.battleOptions()(2),katara)
    assert(katara.currentHealth == 90)
  }
  test("Energy flows steals health and gives the user Chi and health"){
    val katara:WaterBender = new WaterBender("Katara")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat
    katara.currentXp = 600
    katara.levelUp()
    katara.currentHealth -=65
    wolfbatDummie.currentHealth = 60
    katara.takeAction(katara.battleOptions()(3),wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 19 && katara.currentHealth == 111 && katara.currentChi == 80)
  }
}
