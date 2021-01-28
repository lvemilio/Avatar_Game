package second_ord_classses
import highest_order_classes.AnyPlayFightChar
abstract class Basic_Monster extends AnyPlayFightChar {
  var maxHealth:Int
  var currentHealth:Int
  var resolve:Int
  var physicalAttack:Int
  var isAlive:Boolean
  var agility:Int
  var agilityCounter:Int
  var level: Int

  def takeDamage(damage:Int): Unit
}
