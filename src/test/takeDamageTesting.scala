import model.CharClasses.Airbender_Class
import org.scalatest._

class takeDamageTesting extends FunSuite {
  test("Damage was reduced by the proper amount"){
    val testAang:Airbender_Class = new Airbender_Class("Aang")
    testAang.currentHealth = testAang.maxHealth
    testAang.takeDamage(15)
    println(testAang.agility)
    assert(testAang.currentHealth == 79 || testAang.currentHealth == testAang.maxHealth)
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
    testAang.agility -= 10
    testAang.takeDamage(100)
    assert(testAang.isAlive === false)
  }
}
