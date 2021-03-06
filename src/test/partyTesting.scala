import model.CharClasses.{Airbender_Class, EarthBender, FireBender, WaterBender}
import model.CharClasses.FireBender
import org.scalatest._
import model.CharClasses.Airbender_Class
import model.highest_order_classes.benderPartyClass
import model.parties.benderParty

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

  test("Proper experience is recieved by winning part, levels equal, one member dies"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))
    zuko.isAlive = false

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")

    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 20 && toph.currentXp == 20 &&zuko.currentXp == 0&& katara.currentXp==20)

  }
  test("Proper experience is recieved by winning part, levels equal, but member amount unequal, different members die"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")

    katara.isAlive = false
    aang.isAlive = false

    val wrongParty:benderParty = new benderParty(List(laghima,boomy))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 0 && toph.currentXp == 20 &&zuko.currentXp == 20&& katara.currentXp==0)
  }

  test("Proper experience is recieved by winning party, levels unequal, player amount equal, 3 members die"){
    val aang:Airbender_Class = new Airbender_Class("Aang")
    val toph:EarthBender = new EarthBender("Toph")
    val zuko:FireBender = new FireBender("Zuko")
    val katara:WaterBender = new WaterBender("Katara")
    val theOgParty:benderParty = new benderParty(List(aang,toph,zuko,katara))

    katara.isAlive = false
    zuko.isAlive = false
    toph.isAlive = false


    val laghima:Airbender_Class = new Airbender_Class("laghima")
    val boomy:EarthBender = new EarthBender("boomy")
    val azula:FireBender = new FireBender("azula")
    val korra:WaterBender = new WaterBender("korra")
    laghima.level+=2
    azula.level+=5
    korra.level +=4
    val wrongParty:benderParty = new benderParty(List(laghima,boomy,azula,korra))
    theOgParty.fightWon(wrongParty)
    assert(aang.currentXp == 0 && toph.currentXp == 0 &&zuko.currentXp == 0&& katara.currentXp==0 && aang.level==4&&
            toph.level == 1 && zuko.level == 1 && katara.level == 1)
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
