package reverseGeo
import core.Street 
import scala.util.parsing.json._

class StreetResolverGoogle extends StreetResolver{

  val API_KEY = "AIzaSyDDWSZy-CB5G07EW9W8HeYM1lygjStnwfk"
 
  // @Unimplemented
  def resolve(knownStreets:Array[Street])(lonlat:(Double,Double)) = {}
  
  def parseStreetResponse(jsonURI:String):String = {
	val json = JSON.parseFull(io.Source.fromFile(jsonURI).mkString)
	val jsonMap = json.get.asInstanceOf[Map[String, Any]]
    val status = jsonMap.getOrElse("status","failed")
	
	// find a record with types including route and report it
	if (status == "OK") {
			jsonMap.getOrElse("results",List()).asInstanceOf[List[Any]].foreach { result =>
				result.asInstanceOf[Map[String,Any]].getOrElse("address_components", List()).asInstanceOf[List[Any]].foreach {
					cmp =>
					cmp.asInstanceOf[Map[String,Any]].getOrElse("types",List())
					.asInstanceOf[List[Any]].foreach { _type =>
						if (_type == "route") {
								return cmp.asInstanceOf[Map[String,Any]].getOrElse("long_name","?").toString
						}
					}
				}
			}
	}
	return "?"
 }                      
  
}