package reverseGeo
import core.Street
import scala.util.parsing.json._
import core.AppConfiguration

object StreetResolverGoogle extends StreetResolver{
  
  def KEY_GOOGLE_API = "geocoding.api.google.key"
  def KEY_GOOGLE_URL_SCHEME = "geocoding.api.google.url"
  
  def LOCATION_TYPE = "ROOFTOP"
  def RESULT_TYPE = "route"
      
  def assembleAPIUrl(lonlat:(Double,Double)):String = {
    val urlScheme = AppConfiguration.configuration.getString(KEY_GOOGLE_URL_SCHEME)
    val apiKey = AppConfiguration.configuration.getString(KEY_GOOGLE_API)
    
    return urlScheme format (lonlat._2,lonlat._1,LOCATION_TYPE, apiKey) 
  }
    
  // @Unimplemented
  def resolve(lonlat:(Double,Double), testConditions:Seq[(String,String)]):String = {
    val apiURL = assembleAPIUrl(lonlat)
    val jsonString = io.Source.fromURL(apiURL).mkString
    return parseStreetNameFromJson(jsonString, testConditions)
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