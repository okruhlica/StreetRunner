package core

class Street(streetName:String, streetDistrict:String) {
  def name:String = streetName
  def lon:Double = Double.NaN
  def lat:Double = Double.NaN
  def district:String = streetDistrict
  
  override def toString = "(" + name + "/" + district + ")"
}

  
