package workout

case class RoutePoint(lon:Double, lat: Double) {
	override def toString() = f"($lon%2.4f,$lat%2.4f)"
}