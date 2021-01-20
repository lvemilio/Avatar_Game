package characterClasses



class Airbender_Class(var charName:String) {
  var maxHealth:Int = 90
  var maxChi:Int = 115
  var currentHealth:Int = maxHealth
  var currentChi:Int = maxChi
  var physicalAttackPower:Int = 5
  var bendingAttackPower:Int = 20
  var benderResolve:Int = 4 //Resolve is like armor, it represents the amount attacks can get reduced by
  var agility:Int = scala.util.Random.nextInt(10)//Agility represents the chance a bender can dodge an attack
                                                  // This stat will later be used in a method
  var isAlive:Boolean = true

  def takeDamage(damage:Int): Unit ={
    currentHealth -= damage
    if (currentHealth <= 0){
      isAlive = false
    }
  }


  def dealPhysDamage(wolfbat: AngryWolfbat): Unit ={
    wolfbat.takeDamage(this.physicalAttackPower - wolfbat.resolve)
  }
  def dealMBenDamage(wolfbat: AngryWolfbat): Unit ={
    if (currentChi<=0){
      return
    }
    wolfbat.takeDamage(this.bendingAttackPower-wolfbat.resolve)
    this.currentChi -=  10

  }
}

