package reverseGeo
import core.Street

trait StreetResolver {
	def resolve(knownStreets:Array[Street])(lonlat:(Double,Double))
}