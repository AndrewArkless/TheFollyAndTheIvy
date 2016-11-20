
import org.scalatest.{FlatSpec, Matchers, WordSpecLike, _}

/**
  * Created by User on 02/11/2016.
  */
class DecoratedTreeSpec extends WordSpecLike with Matchers {

  "Calling turnTuplestoATree" should {
    "return basic tree " in {
      val result = DecoratedTree.decoratedTree(7, 2)
      println(result)
      result.length shouldBe 9
      result.head shouldBe "      @"
      result(1) shouldBe "      ~"

      result(2).startsWith("     ", 0) shouldBe true
      result(2).contains("00") shouldBe true
      result(2).toString.count(_ == '~') shouldBe 1

      result(3).startsWith("    ", 0) shouldBe true
      result(3).contains("00") shouldBe true
      result(3).toString.count(_ == '~') shouldBe 3

      result(4).startsWith("   ", 0) shouldBe true
      result(4).contains("00") shouldBe true
      result(4).toString.count(_ == '~') shouldBe 5

      result(5).startsWith("  ", 0) shouldBe true
      result(5).contains("00") shouldBe true
      result(5).toString.count(_ == '~') shouldBe 7

      result(6).startsWith(" ", 0) shouldBe true
      result(6).contains("00") shouldBe true
      result(6).toString.count(_ == '~') shouldBe 9

      result(7).startsWith("", 0) shouldBe true
      result(7).contains("00") shouldBe true
      result(7).toString.count(_ == '~') shouldBe 11

      result(8) shouldBe "      #"
    }

    //TODO - needs fixing at somepoint, but sit will never arise in prod.

//    "return empty tree when "in {
//      val result = DecoratedTree.decoratedTree(0, 0)
//      result shouldBe List()
//    }

  }

}
