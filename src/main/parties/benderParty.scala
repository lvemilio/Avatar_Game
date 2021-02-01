package parties
import highest_order_classes.partyClass
import second_ord_classses.BenderClass



class benderParty(currentMembers:List[BenderClass]) extends partyClass {
  var members: List[BenderClass] = currentMembers
  var totalEnemyLvl:Double = 0
  def fightWon(enemyParty:partyClass):Unit={
    for(enemy <- enemyParty.members){
      totalEnemyLvl+=enemy.level
    }

  var aliveMembers:Double = 0

  for(member<-this.members){
    if (member.isAlive){
      aliveMembers+=1
    }
  }

  val LvlIncrementer:Double = totalEnemyLvl/aliveMembers
  for (member <- this.members){
    if(member.isAlive) {
      member.gainXP(LvlIncrementer)
      }
    }
  }
}
