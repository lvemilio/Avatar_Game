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
  var LvlIncrementer:Double = totalEnemyLvl/members.length
  for (member <- this.members){
    member.gainXP(LvlIncrementer)
    }
  }
}
