package reverseGeo
import core.Street

trait StreetResolver {
	def resolve(lonlat:(Double,Double), testConditions:Seq[(String,String)]):String
}