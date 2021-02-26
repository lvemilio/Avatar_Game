import model.CharClasses.Airbender_Class
import model.monsters_fightables.AngryWolfbat
import org.scalatest._

class dealDamageTesting extends FunSuite{
  test("Physical damage was reduced by the right amount"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val wolfbat:AngryWolfbat = new AngryWolfbat()
    aang.dealPhysDamage(wolfbat)
    println(wolfbat.agility - wolfbat.agilityCounter)
    assert(wolfbat.currentHealth == 27 || wolfbat.currentHealth == 30) // Or added in case agility worked
  }
  test("Bending damage was reduced by the right amount"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val wolfbat:AngryWolfbat = new AngryWolfbat()
    aang.dealBenDamage(wolfbat)
    println(wolfbat.agility - wolfbat.agilityCounter)
    assert(wolfbat.currentHealth == 12 || wolfbat.currentHealth == 30)
  }
  test("Chi was reduced by the right amount"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val wolfbat:AngryWolfbat = new AngryWolfbat()
    aang.dealBenDamage(wolfbat)
    assert(aang.currentChi == 105)
  }
  test("Attack deals no damage if attacker has no Chi"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val wolfbat:AngryWolfbat = new AngryWolfbat()
    aang.currentChi = 0
    aang.dealBenDamage(wolfbat)
    println(wolfbat.agility - wolfbat.agilityCounter)
    assert(wolfbat.currentHealth == 30)
  }
  test("Dodging works"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val wolfbat:AngryWolfbat = new AngryWolfbat()
    wolfbat.agility = 100
    aang.dealBenDamage(wolfbat)
    assert(wolfbat.currentHealth == 30)
  }


}
