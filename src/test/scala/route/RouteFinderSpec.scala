package route

import org.scalatest.FunSuite

class RouteFinderSpec extends FunSuite {

  val routeFinder = new RouteFinder()

  test("Tree 0 result should be 243") {
    val routeTree = routeFinder.readRouteTree("src/test/scala/route/tree0.txt")
    assert(routeFinder.findFavouriteRoute(routeTree) === 243)
  }

  test("Tree 1 result should be 606") {
    val routeTree = routeFinder.readRouteTree("src/test/scala/route/tree1.txt")
    assert(routeFinder.findFavouriteRoute(routeTree) === 606)
  }

  test("Tree 2 result should be 634") {
    val routeTree = routeFinder.readRouteTree("src/test/scala/route/tree2.txt")
    assert(routeFinder.findFavouriteRoute(routeTree) === 634)
  }
}