import org.scalatest._
import characterClasses.Airbender_Class

class takeDamageTesting extends FunSuite {
  test("Damage was reduced by the proper amount"){
    val testAang:Airbender_Class = new Airbender_Class("Aang")
    testAang.currentHealth = testAang.maxHealth
    testAang.takeDamage(15)
    println(testAang.agility)
    assert(testAang.currentHealth == 75)
  }
  test("Damage was not lethal"){
    val testAang:Airbender_Class = new Airbender_Class("Aang")
    testAang.currentHealth = testAang.maxHealth
    testAang.takeDamage(65)
    assert(testAang.isAlive === true)
  }
  test("Damage was lethal"){
    val testAang:Airbender_Class = new Airbender_Class("Aang")
    testAang.currentHealth = testAang.maxHealth
    testAang.takeDamage(100)
    assert(testAang.isAlive === false)
  }
}
