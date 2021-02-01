package parties
import highest_order_classes.partyClass
import second_ord_classses.BenderClass



class benderParty(currentMembers:List[BenderClass]) extends partyClass {
  var members: List[BenderClass] = currentMembers
  var totalEnemyLvl:Double = 0 // Total enemy levels are later used to proprtionally divide xp
  def fightWon(enemyParty:partyClass):Unit={
    for(enemy <- enemyParty.members){
      totalEnemyLvl+=enemy.level
    }
  var LvlIncrementer:Double = totalEnemyLvl/members.length //The theoretical "level" every member recieves is passed to gainXp
                                                          //GainxP later records this theoretical "level" and gives experience according to that members level
  for (member <- this.members){
    member.gainXP(LvlIncrementer  )
    }
  }
}
