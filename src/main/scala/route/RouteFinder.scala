package route

import scala.io.Source

class RouteFinder {

  def readRouteTree(fileName: String) = {
    val lines = Source.fromFile(fileName).getLines().toList
    val strList = lines.map(_.split(" ").toList)
    strList.map((line: List[String]) => line.foreach(println(_)))
    strList.map((line: List[String]) => line.map(_.toInt))
  }

  def findFavouriteRoute(routeTree: List[List[Int]]) = ""
}