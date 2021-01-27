import characterClasses.Airbender_Class
import characterClasses.AngryWolfbat
import org.scalatest._


class charExperienceTesting extends FunSuite {
  test("Character gains the proper experience points"){
    var aang:Airbender_Class = new Airbender_Class("Aang")
    var wolfbat:AngryWolfbat = new AngryWolfbat
    aang.gainXP(wolfbat)
    assert(aang.currentXp == 20)
  }

  test("Character gains a level and stats increase") {
    var laghima: Airbender_Class = new Airbender_Class("Laghima")
    var wolfbat: AngryWolfbat = new AngryWolfbat()
    laghima.takeDamage(15)
    laghima.dealBenDamage(wolfbat)
    wolfbat.level += 4 // Wolfbat level is increased so test can gain proper xp
    laghima.gainXP(wolfbat)
    assert(laghima.level == 2 &&
      laghima.currentXp == 0 &&
      laghima.maxHealth == 95 &&
      laghima.currentHealth == laghima.maxHealth &&
      laghima.currentChi == laghima.maxChi &&
      laghima.physicalAttack == 7 &&
      laghima.bendingAttackPower == 23 &&
      laghima.resolve == 5
    )
  }
  test("Character gains multiple levels and stats increase accordingly"){
    var laghima:Airbender_Class = new Airbender_Class("Laghima")
    var wolfbat:AngryWolfbat = new AngryWolfbat()
    laghima.takeDamage(15)
    laghima.dealBenDamage(wolfbat)
    wolfbat.level +=10
    laghima.gainXP(wolfbat)
    assert(laghima.level == 3 &&
      laghima.currentXp == 20 &&
      laghima.maxHealth == 100 &&
      laghima.currentHealth == laghima.maxHealth &&
      laghima.currentChi == laghima.maxChi &&
      laghima.physicalAttack == 9 &&
      laghima.bendingAttackPower == 26 &&
      laghima.resolve == 6)
    }
  test("Character gains the proper experience points if enemy is lower level"){
    var aang:Airbender_Class = new Airbender_Class("Aang")
    var wolfbat:AngryWolfbat = new AngryWolfbat
    aang.level += 4
    aang.gainXP(wolfbat)
    assert(aang.currentXp == 4)
  }
  test("Character gains the proper experience points if enemy is lower level but with stranger numbers"){
    var aang:Airbender_Class = new Airbender_Class("Aang")
    var wolfbat:AngryWolfbat = new AngryWolfbat
    aang.level += 6
    aang.gainXP(wolfbat)
    assert(aang.currentXp == (20*wolfbat.level.toFloat/aang.level.toFloat).toInt)
  }


}
