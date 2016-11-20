import scala.collection.mutable.ListBuffer

/**
  * Created by User on 19/11/2016.
  */
object DecoratedTree {

  def decoratedTree(h:Int,d:Int)= {
    def makeMyRows(h: Int) = {
      var r = new ListBuffer[(Int, Int)]
      var counter = h - 1
      var branches = 1;
      var spaces = h
      while (counter >= 0) {
        //counter is the number of leading spaces and
        //branches is the number of branches
        //ie
        r += ((counter, branches))
        branches = branches + 2
        counter = counter - 1
      }
      r.toList

    }
  def turnTuplestoATree(treeComposition: List[(Int, Int)]): List[String] = {
      for (x <- treeComposition) yield {
        //refactor with escape chars to force a new line as per spec???? TODO
        //is this required speak with BA or PM???
        " " * x._1 + placeDecsArbitarily("~" * x._2)
      }
    }
    def placeDecsArbitarily(branch:String)={
      if(branch.length<=d){
        branch
      } else {

        val startOfReplacement= (new scala.util.Random).nextInt(branch.length-d)
        branch.substring(0,startOfReplacement) + "0" * d + branch.substring(startOfReplacement+d)
        //println(branch.substring(0,startOfReplacement))
        //   branch
      }
      // Spec looks like decs to be grouped 00 and not split like ~0~~0~ so not implemeted
      //but stub left in just in case!
      // def generateDistinctNumbersToCorrespondinTHeStringWhereDecsGO(howManyDecs:Int)={
      //
      //      }
    }
    //    def stickAFairyOnTop(tree:List[String])={
    //      //val treeTop=tree.head
    //      tree.head.reverse.tail + "@" :: tree
    //    }

    def placeTrunnkAtBottomAndFairyOnTop(tree:List[String])={
      tree.head.reverse.tail + "@" ::  tree ::: List[String]((" " * (tree.reverse.head.length/2)) + "#")
    }
    placeTrunnkAtBottomAndFairyOnTop(turnTuplestoATree(makeMyRows(h)))
  }
}
