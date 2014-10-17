package core

class RouteLoader { 
  
  def load(gpxFile:String):Route = {
	val trackElem = scala.xml.XML.loadFile(gpxFile)
    val trackPoints = for (pt <- (trackElem \\ "trkpt")) 
    	yield new RoutePoint((pt \ "@lon").text.toDouble,(pt \ "@lat").text.toDouble)
	new Route(trackPoints)
  }
}