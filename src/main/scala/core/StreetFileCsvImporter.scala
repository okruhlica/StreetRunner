package core

import scala.io.Source

class StreetFileCsvImporter(fileURI:String) extends StreetFile{
  
  def path = fileURI
  
  val COL_STREET = 0  
  val COL_DISTRICT = 3
  val COL_CITY = 6
  
  val SKIP_ROWS = 0
  val DELIM_COLS = ","
    
	def load(targetCity:String) : Array[Street] = {
			def parseCsv(rows:Array[String]) = rows.drop(SKIP_ROWS)
										 .map(_.split(DELIM_COLS))
										 .filter(x => x(COL_CITY) == targetCity)
										 .map(x => new Street(x(COL_STREET), x(COL_DISTRICT)))

    parseCsv(Source.fromFile(path).getLines.toArray)
	}
}