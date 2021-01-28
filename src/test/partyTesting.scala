import org.scalatest._
import characterClasses.{Airbender_Class,WaterBender,EarthBender,FireBender}
import highest_order_classes.partyClass
import parties.benderParty

class partyTesting extends FunSuite{
  test("Proper experience is recieved by winning part, levels equal"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")
    val korra:WaterBender = new WaterBender("korra")

    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula,korra))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 20 && toph.currentXp == 20 &&zuko.currentXp == 20&& katara.currentXp==20)
  }
  test("Proper experience is recieved by winning part, levels equal, but member amount unequal"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")

    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 15 && toph.currentXp == 15 &&zuko.currentXp == 15&& katara.currentXp==15)

  }
  test("Proper experience is recieved by winning part, levels equal, but member amount unequal repeated"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")

    val wrongParty:benderParty = new benderParty(List(laghima,boomy))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 10 && toph.currentXp == 10 &&zuko.currentXp == 10&& katara.currentXp==10)
  }
  test("Proper experience is recieved by winning party, levels unequal, player amount equal"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")
    val korra:WaterBender = new WaterBender("korra")
    laghima.level+=2
    azula.level+=5
    korra.level +=4
    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula,korra))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 75 && toph.currentXp == 75 &&zuko.currentXp == 75&& katara.currentXp==75)
  }
  test("Proper experience is recieved by winning part, and party members level up"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")
    val korra:WaterBender = new WaterBender("korra")
    laghima.level+=8
    azula.level+=7
    korra.level +=6
    println(azula.level+korra.level+laghima.level+boomy.level)
    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula,korra))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 25 && toph.currentXp == 25 &&zuko.currentXp == 25&& katara.currentXp==25&&
            aang.level == 2 && toph.level == 2&& zuko.level == 2&& katara.level == 2)
  }

  test("Proper experience is recieved by winning party, levels unequal, player amount unequal"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val theOgParty:benderParty = new benderParty(List(aang,toph))
    aang.level+=2
    toph.level+=1

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val azula:FireBender = new FireBender("azula")
    val korra:WaterBender = new WaterBender("korra")
    laghima.level+=2
    azula.level+=6
    korra.level +=4
    println(azula.level+korra.level+laghima.level)
    val wrongParty:benderParty = new benderParty(List(laghima,azula,korra))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 50 && toph.currentXp == 75 )
  }
  test("Proper experience is recieved by winning party, levels unequal, player amount unequal, random numbers") {
    val aang: Airbender_Class = new Airbender_Class("Aang")
    val toph: EarthBender = new EarthBender("Toph")
    val theOgParty: benderParty = new benderParty(List(aang, toph))
    aang.level += 6
    toph.level += 40

    val laghima: Airbender_Class = new Airbender_Class("laghima")
    val azula: FireBender = new FireBender("azula")
    val korra: WaterBender = new WaterBender("korra")
    laghima.level += 15
    azula.level += 8
    korra.level += 5
    println(azula.level + korra.level + laghima.level)
    val wrongParty: benderParty = new benderParty(List(laghima, azula, korra))
    theOgParty.fightWon(wrongParty)
    println(aang.level, aang.currentXp, toph.level, toph.currentXp)
    assert(aang.currentXp == 44 && toph.currentXp == 8&&aang.level == 7&&toph.level == 41 )
  }
}
