package route

import scala.io.Source

class RouteFinder {

  type RouteTree = List[List[Int]]

  def readRouteTree(fileName: String): RouteTree = {
    val lines = Source.fromFile(fileName).getLines.toList
    lines.tail.map(_.split(" ").map(_.toInt).toList)
  }

  def findFavouriteRoute(routeTree: RouteTree) = {
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