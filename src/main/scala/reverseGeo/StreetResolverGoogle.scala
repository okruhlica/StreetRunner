package reverseGeo
import core.Street 
import scala.util.parsing.json._

object StreetResolverGoogle extends StreetResolver{
 
  // @Unimplemented
  def resolve(knownStreets:Array[Street])(lonlat:(Double,Double)) = {}
  
  def getStreetName(jsonURI:String, testTypes:Seq[(String,String)]):String = {
	val jsonString = io.Source.fromFile(jsonURI).mkString
	return parseStreetNameFromJson(jsonString, testTypes)
  }
  
  def parseStreetNameFromJson(jsonString:String, testTypes:Seq[(String,String)]):String = {
	val json = JSON.parseFull(jsonString)
	val jsonMap = json.get.asInstanceOf[Map[String, Any]]
    
	if(jsonMap.getOrElse("status","failed") != "OK") {
      return "?"
    }
	
    def getTypeAttribute(typeName:String):String = { 
			jsonMap.getOrElse("results",List()).asInstanceOf[List[Any]].foreach { result =>
				result.asInstanceOf[Map[String,Any]].getOrElse("address_components", List()).asInstanceOf[List[Any]].foreach { cmp =>
					cmp.asInstanceOf[Map[String,Any]].getOrElse("types",List()).asInstanceOf[List[Any]].foreach { _type =>
						if (_type == typeName) {
								return cmp.asInstanceOf[Map[String,Any]].getOrElse("long_name","?").toString
						}
					}
				}
			}
			return "?"
    }
    
    if(testTypes.forall(par=>(getTypeAttribute(par._1)==par._2))) {
      return getTypeAttribute("route")
    }
    return "?"
 }                      
  
}