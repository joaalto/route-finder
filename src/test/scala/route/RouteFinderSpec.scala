package route

import org.scalatest.FunSuite

class RouteFinderSpec extends FunSuite {

  val routeFinder = new RouteFinder()

  test("Tree 0 result should be 243") {
    assert(routeFinder.seedAndSum("src/test/scala/route/tree0.txt")
      === (000, 243))
  }

  test("Tree 1 result should be 606") {
    assert(routeFinder.seedAndSum("src/test/scala/route/tree1.txt")
      === (111, 606))
  }

  test("Tree 2 result should be 634") {
    assert(routeFinder.seedAndSum("src/test/scala/route/tree2.txt")
      === (222, 634))
  }
}