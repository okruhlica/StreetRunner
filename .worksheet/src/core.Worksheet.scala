package core

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(608); 

// val x = new StreetFileCsvImporter("/Users/adamokruhlica/Desktop/scala/coursera/RunTheCity/src/ulice-psc.csv")
// val dataset = x.load("Bratislava")

// def cmpStreets(s1:String, s2:String) = (s1 compareToIgnoreCase s2) < 0
// dataset.filter(_.name.charAt(0) == 'C').map(_.name).sortWith(cmpStreets).length
 // dataset.length
 
 // def readURL(url:String):String = io.Source.fromURL(url).mkString
// readURL("https://maps.googleapis.com/maps/api/geocode/json?latlng=48.15097,17.083633&key=")

val gpxFile = "/Users/adamokruhlica/Desktop/RunBAFiles/gpx/20141010_161804.gpx";System.out.println("""gpxFile  : String = """ + $show(gpxFile ));$skip(29); 
val loader = new RouteLoader;System.out.println("""loader  : core.RouteLoader = """ + $show(loader ));$skip(33); 
val route = loader.load(gpxFile);System.out.println("""route  : core.Route = """ + $show(route ));$skip(38); 

for (pt <- route.points) println(pt);$skip(20); val res$0 = 
route.points.length;System.out.println("""res0: Int = """ + $show(res$0))}
 
// (trk \ "trkseq").foreach { trkseq  =>
//  (trkseq \ "trkpt").foreach {  pt =>
//			val s = "(" + (pt \ "@lat").text + ","+(pt \ "@lon").text +")"
//			yield s
//			}
//		}
//	}
}
