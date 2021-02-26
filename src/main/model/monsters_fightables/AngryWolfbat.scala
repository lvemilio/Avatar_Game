package model.monsters_fightables

import model.second_ord_classses.Basic_Monster

class AngryWolfbat extends Basic_Monster {
  var maxHealth:Int = 30
  var currentHealth:Int = maxHealth
  var resolve:Int = 2
  var physicalAttack:Int = 1
  var isAlive:Boolean = true
  var agility:Int = scala.util.Random.nextInt(10)
  var agilityCounter:Int = 10
  var level: Int = 1

  def takeDamage(damage:Int): Unit ={
    if (agility-agilityCounter>0){
      return
    }
    this.currentHealth -=  damage
    if (currentHealth <= 0){
      isAlive = false
    }
  }

}
