import model.CharClasses.EarthBender
import model.monsters_fightables.AngryWolfbat
import org.scalatest._

class earthBenderTests extends FunSuite{
  test("Initial stats are correct"){
    val toph:EarthBender = new EarthBender("Toph")
    assert(toph.maxHealth == 110 &&
      toph.maxChi == 95 &&
      toph.currentHealth == toph.maxHealth &&
      toph.currentChi == toph.maxChi &&
      toph.physicalAttack == 7 &&
      toph.bendingAttackPower == 22&&
      toph.resolve == 6 &&
      toph.maxXp == 100 &&
      toph.currentXp == 0&&
      toph.level == 1)
  }
  test("Initial battle options are correct"){
    val toph:EarthBender = new EarthBender("Toph")
    assert(toph.battleOptions() == List("Physical attack", "Bending attack", "Metal Bender",""))
  }
  test("Stats are increased after leveling up"){
    val toph:EarthBender = new EarthBender("Toph")
    toph.currentXp = 100
    toph.levelUp()
    assert(toph.maxHealth == 115 &&
      toph.maxChi == 102 &&
      toph.currentHealth == toph.maxHealth &&
      toph.currentChi == toph.maxChi &&
      toph.physicalAttack == 9 &&
      toph.bendingAttackPower == 25&&
      toph.resolve == 7 &&
      toph.maxXp == 100 &&
      toph.currentXp == 0&&
      toph.level == 2
    )
  }
  test("New battle options appear"){
    val toph:EarthBender = new EarthBender("Toph")
    toph.currentXp = 600
    toph.levelUp()
    assert(toph.battleOptions() == List("Physical attack", "Bending attack", "Metal hands", "Unbreakable"))
  }
  test("First 2 battle options work"){
    val toph:EarthBender = new EarthBender("Toph")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat

    toph.takeAction(toph.battleOptions().head,wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 25)

    wolfbatDummie.currentHealth+=5
    toph.takeAction(toph.battleOptions()(1),wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 10 && toph.currentChi == 84)

  }
  test("MetalBender increases attack power") {
    val toph:EarthBender = new EarthBender("Toph")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat

    toph.takeAction(toph.battleOptions()(2), wolfbatDummie)
    toph.dealPhysDamage(wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 15 && toph.currentChi == 64)
    wolfbatDummie.currentHealth = wolfbatDummie.maxHealth
    toph.dealBenDamage(wolfbatDummie)
    assert(wolfbatDummie.currentHealth == 5&& toph.currentChi == 53)

  }
  test("Unbreakable increases resolve"){
    val toph:EarthBender = new EarthBender("Toph")
    val wolfbatDummie:AngryWolfbat = new AngryWolfbat

    toph.level = 6
    toph.takeAction(toph.battleOptions()(3),wolfbatDummie)
    assert(toph.resolve == 16 && toph.currentChi == 29)

  }
}
