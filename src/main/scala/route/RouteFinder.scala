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
    val tree = lines.tail.map(_.split(" ").map(_.toInt).toList).reverse
    (seed, tree)
  }

  def sumFavouriteRoute(routeTree: RouteTree) = {
    sumLikes(routeTree.tail, routeTree.head)
  }

  def sumLikes(routeTree: RouteTree, rowBelow: List[Int]): Int = {
    if (routeTree.size == 0) rowBelow.max
    else {
      val sumRow = addRows(routeTree.head, rowBelow.sliding(2).toList, Nil)
      sumLikes(routeTree.tail, sumRow)
    }
  }

  def addRows(row: List[Int], below: List[List[Int]], acc: List[Int]): List[Int] = {
    if (row.size == 0) acc
    else {
      addRows(row.tail, below.tail, acc :+ (row.head + below.head.max))
    }
  }
}
