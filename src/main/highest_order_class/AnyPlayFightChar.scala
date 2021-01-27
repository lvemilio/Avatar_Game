package highest_order_class

abstract class AnyPlayFightChar {
  var maxHealth:Int
  var currentHealth:Int
  var resolve:Int
  var physicalAttack:Int
  var isAlive:Boolean
  var level:Int
  def takeDamage(damage:Int): Unit
}
