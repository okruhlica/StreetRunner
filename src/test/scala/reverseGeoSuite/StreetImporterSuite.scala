package reverseGeoSuite

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import core.RouteLoader
import core.Route


@RunWith(classOf[JUnitRunner])
class StreetImporterSuite extends FunSuite {
  
   def loadRouteFor(gpxName:String):Route = {
       val mockGpx = getClass.getResource(gpxName)	   
	   assert(mockGpx!=null)	   
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
   
}

