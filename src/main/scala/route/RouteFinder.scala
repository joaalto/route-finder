package route

import scala.io.Source

class RouteFinder {

  type RouteTree = List[List[Int]]

  def seedAndSum(fileName: String): (Int, Int) = {
    val tree = readRouteFile(fileName)
    (tree._1, sumFavouriteRoute(tree._2))
  }

  def readRouteFile(fileName: String): (Int, RouteTree) = {
    val lines = Source.fromFile(fileName).getLines.toList
    val seed = lines.head.split(" ")(2).toInt
    val tree = lines.tail.map(_.split(" ").map(_.toInt).toList)
    (seed, tree)
  }

  def sumFavouriteRoute(routeTree: RouteTree) = {
    sumLikes(routeTree.tail, 0, routeTree.head(0))
  }

  def sumLikes(routeTree: RouteTree, column: Int, sum: Int): Int = {
    if (routeTree.size == 0) sum
    else {
      val head = routeTree.head
      val max = head(column).max(head(column + 1))
      sumLikes(routeTree.tail, head.indexOf(max, column), sum + max)
    }
  }
}