package model.CharClasses

import model.highest_order_classes.AnyPlayFightChar
import model.second_ord_classses.BenderClass
class WaterBender(name:String) extends BenderClass{
  var maxHealth:Int = 105
  var maxChi:Int = 105
  var currentHealth:Int = maxHealth
  var currentChi:Int = maxChi
  var physicalAttack:Int = 6
  var bendingAttackPower:Int = 23
  var resolve:Int = 4 //Resolve is like armor, it represents the amount attacks can get reduced by
  var agility:Int = scala.util.Random.nextInt(10)//Agility represents the chance a bender can dodge an attack   // This stat will later be used in a method
  var isAlive:Boolean = true

  override var maxXp: Int = 100
  override var currentXp: Int = 0
  override var level: Int = 1

  /////////////////////////////////////////////

  override def takeDamage(damage:Int): Unit ={
    if (this.agility - 7 > 0){
      return
    }
    currentHealth = currentHealth - damage + resolve
    if (currentHealth <= 0){
      isAlive = false
    }
  }
  /////////////////////////////////////////////
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
  /////////////////////////////////////////////
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
    this.currentChi -=  10 + this.level
  }
  ///////////////////////////////////////////// Heals an ally for the amount of bending power
  def healingWater(bender:AnyPlayFightChar): Unit ={
    if (this.currentChi<20+this.level){
      return
    }
    bender.currentHealth+=this.bendingAttackPower
    if (bender.currentHealth>bender.maxHealth){
      bender.currentHealth = bender.maxHealth
    }
    this.currentChi -= 20 + this.level
  }
  ///////////////////////////////////////////// Steals health from enemy and converts it to chi and health
  def energyFlow(enemy:AnyPlayFightChar): Unit ={
    if (this.currentChi<60+this.level){
      return
    }
    enemy.currentHealth -= bendingAttackPower
    this.currentHealth += bendingAttackPower
    this.currentChi += bendingAttackPower
    if (this.currentHealth>this.maxHealth){
      this.currentHealth = this.maxHealth
    }else if (this.currentChi>this.maxChi){
      this.currentChi = this.maxChi
    }
    this.currentChi -= 60 + this.level
  }

  /////////////////////////////////////////////
  /////////////////////////////////////////////
  override def battleOptions(): List[String] = {
    if (this.level<6){
      val firstAttacks:List[String] = List("Physical attack", "Bending attack", "Healing Water","")
      firstAttacks
      }
    else{
      val allAttacks:List[String] = List("Physical attack", "Bending attack", "Healing Water", "Zenith")
      allAttacks
    }
  }
  override def takeAction(option: String, anyChar:AnyPlayFightChar): Unit = {
    if (option == "Physical attack"){
      dealPhysDamage(anyChar)
    }else if(option == "Bending attack" ){
      dealBenDamage(anyChar)
    }else if(option == "Healing Water"){
      healingWater(anyChar)
    }else if(option == "Zenith"){
      energyFlow(anyChar)
    }
  }
}
