package model.second_ord_classses

import model.highest_order_classes.AnyPlayFightChar

abstract class BenderClass extends AnyPlayFightChar {
  var maxHealth:Int
  var maxChi:Int
  var currentHealth:Int
  var currentChi:Int
  var physicalAttack:Int
  var bendingAttackPower:Int
  var resolve:Int
  var agility:Int
  var isAlive:Boolean

  var maxXp:Int
  var currentXp:Int
  var level:Int


  def takeDamage(damage:Int): Unit
  def dealPhysDamage(anyPlayFightChar: AnyPlayFightChar): Unit
  def dealBenDamage(anyPlayFightChar: AnyPlayFightChar): Unit
  def gainXP(anyPlayFightCharLvl: Double):Unit
  def levelUp():Unit

  def battleOptions():List[String]
  def takeAction(option:String,bender:AnyPlayFightChar)

}

