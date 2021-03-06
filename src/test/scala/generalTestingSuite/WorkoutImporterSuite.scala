package generalTestingSuite

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import workout.RouteLoader
import workout.Route
import com.typesafe.config.ConfigFactory
import java.io.File
import reverseGeo.StreetResolverGoogle

@RunWith(classOf[JUnitRunner])
class WorkoutImporterSuite extends FunSuite {

  def loadRouteFor(gpxName: String): Route = {
    val mockGpx = getClass.getResource(gpxName)
    assert(mockGpx != null)
    val loader = new RouteLoader()
    return loader.load(mockGpx.getPath())
  }

  test("RouteLoader loads a gpx file correctly (1)") {
    val route = loadRouteFor("../resources/gpx01.gpx")

    // test that two random points are loaded correctly
    assert(route.points(1).lon == 17.0864399)
    assert(route.points(1).lat == 48.1528543)
    assert(route.points(2).lon == 17.0865053)
    assert(route.points(2).lat == 48.1528749)
  }

  test("RouteLoader loads a gpx file correctly (2)") {
    val route = loadRouteFor("../resources/gpx02.gpx")

    // test that two random points are loaded correctly
    assert(route.points(0).lon == -121.7295456)
    assert(route.points(0).lat == 45.4431641)
    assert(route.points(5).lon == -121.7252347)
    assert(route.points(5).lat == 45.4416576)
  }

  test("RouteLoader loads a gpx file with no points correctly (3)") {
    val route = loadRouteFor("../resources/gpx03-nopoints.gpx")
    assert(route.points.length == 0)
  }

  test("Google reverse geocoding API URL is assembled correctly") {
    assert(StreetResolverGoogle.assembleAPIUrl((1.0,4.7)).startsWith("https://maps.googleapis.com/maps/api/geocode/json?latlng=4.700000000000000,1.000000000000000&location_type=ROOFTOP&key="))
  }
  
  test("Google reverse geocoding API URL resolves 'Haydnova' street") {
    val testTypes = Array(("locality","Bratislava"))
    val lonlat = (17.090789079666138, 48.15197214038225)
    println(StreetResolverGoogle.assembleAPIUrl(lonlat))
    
    val result = StreetResolverGoogle.resolve(lonlat,testTypes)
    assert(result == "Haydnova")
  }
  
}
