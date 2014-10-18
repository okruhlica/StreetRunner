package generalTestingSuite

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import workout.RouteLoader
import workout.Route
import io._
import reverseGeo.StreetResolverGoogle

@RunWith(classOf[JUnitRunner])
class StreetImporterSuite extends FunSuite {
  
   def loadMockResponseFor(mockName:String):String = {
       val mockFile = getClass.getResource(mockName).getPath()	   
	   assert(mockName!=null)
	   return io.Source.fromFile(mockFile).mkString
   }
  
   test("[Mock] Correctly resolved when both city and street are expected.") {	   
	   val json = loadMockResponseFor("../resources/googleResponseMock01.json")
	   assert(json.length() > 100)
	   
	   // test city is right, street is right
	   val filterParams = Array(("locality","Bratislava"))
	   val street = StreetResolverGoogle.parseStreetNameFromJson(json, filterParams)
	   assert(street == "Mozartova")	    
   }
}
