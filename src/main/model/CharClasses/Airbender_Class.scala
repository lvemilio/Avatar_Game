package model.CharClasses

import model.highest_order_classes.AnyPlayFightChar
import model.second_ord_classses.BenderClass


class Airbender_Class(name:String) extends BenderClass {
  /////////////////////////////////////////////
  var maxHealth:Int = 90
  var maxChi:Int = 115
  var currentHealth:Int = maxHealth
  var currentChi:Int = maxChi
  var physicalAttack:Int = 5
  var bendingAttackPower:Int = 20
  var resolve:Int = 4 //Resolve is like armor, it represents the amount attacks can get reduced by
  var agility:Int = scala.util.Random.nextInt(12)//Agility represents the chance a bender can dodge an attack
                                                  // This stat will later be used in a method, airbenders are more agile
  var isAlive:Boolean = true

  override var maxXp: Int = 100
  override var currentXp: Int = 0
  override var level: Int = 1
  /////////////////////////////////////////////
  override def takeDamage(damage:Int): Unit = {
    if (this.agility - 7 > 0){
      return
    }
    currentHealth = currentHealth - damage + resolve
    if (currentHealth <= 0){
      isAlive = false
    }
  }
  /////////////////////////////////////////////
  override def dealPhysDamage(anyChar: AnyPlayFightChar): Unit ={
    anyChar.takeDamage(this.physicalAttack - anyChar.resolve)
    if (anyChar.currentHealth<=0){
      gainXP(anyChar.level) //If any character dies from damage, the winner gains xp
    }
  }
  /////////////////////////////////////////////
  override def dealBenDamage(anyChar: AnyPlayFightChar): Unit ={
    if (currentChi<=0){
      return
    }
    anyChar.takeDamage(this.bendingAttackPower-anyChar.resolve)
    this.currentChi -=  10
  }
/////////////////////////////////////////////
  override def gainXP(anyCharLevel: Double): Unit = {
    var xpLevelFactor:Double = anyCharLevel.toFloat/this.level.toFloat // The amount of xp is determined by the level factor, if the enemy is a higher level, the winner gets more.
    this.currentXp += (20*xpLevelFactor).round.toInt

    if (this.currentXp>=this.maxXp){ //If the player has more or equal xp to that of the winner, they level up
      levelUp()
    }
  }
/////////////////////////////////////////////
  override def levelUp(): Unit = {
    var levelFactor:Int = currentXp/maxXp //Set up a level factor

    this.level += levelFactor
    currentXp = currentXp - (maxXp*levelFactor) // Increase level and increment xP

    this.maxHealth += 5*levelFactor  // Increase stats
    this.maxChi += 7*levelFactor
    currentHealth = maxHealth
    currentChi = maxChi
    physicalAttack += 2*levelFactor
    bendingAttackPower += 3*levelFactor
    resolve += 1*levelFactor
  }

  ///////////////////////////////////////////// Special Abilities
  override def battleOptions(): List[String] = {
    ???
  }

  override def takeAction(option: String, bender: AnyPlayFightChar): Unit = {

  }
}

