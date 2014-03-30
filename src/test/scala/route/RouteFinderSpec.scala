package route

import org.scalatest.FunSuite

class RouteFinderSpec extends FunSuite {

  val routeFinder = new RouteFinder()

  test("Tree 1 result should be 606") {
    val routeTree = routeFinder.readRouteTree("src/test/scala/route/tree1.txt")

    assert(routeFinder.findFavouriteRoute(routeTree) === 606)
  }
}