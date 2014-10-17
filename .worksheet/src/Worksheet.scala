import scala.io._
package core

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(423); 
	val csv = """DULICA,ULICA,PSC,DPOSTA,POSTA,POZNAMKA,OBCE
Železničiarska,Železničiarska,969 01,Banská Štiavnica 1,Banská Štiavnica 1,,Banská Štiavnica
Rekreačná,Rekreačná,919 34,Biely Kostol,Biely Kostol,,Trnava
Alžbetínska,Alžbetínska,811 09,Bratislava 1,Bratislava 1,,Bratislava
Americké námestie,Americké námestie,811 07,Bratislava 1,Bratislava 1,číslo 1,Bratislava
""";System.out.println("""csv  : String = """ + $show(csv ));$skip(111); 

 val x = new StreetFileCsvImporter("/Users/adamokruhlica/Desktop/scala/coursera/RunTheCity/src/ulicePSC.csv");System.out.println("""x  : <error> = """ + $show(x ));$skip(36); 
 val dataset = x.load("Bratislava");System.out.println("""dataset  : <error> = """ + $show(dataset ));$skip(20); val res$0 = 
     dataset.length;System.out.println("""res0: <error> = """ + $show(res$0));$skip(48); val res$1 = 
 dataset.filter(_.name.charAt(0) == 'A').length;System.out.println("""res1: <error> = """ + $show(res$1));$skip(114); 
 val output:Output = Resource.fromFile("/Users/adamokruhlica/Desktop/scala/coursera/RunTheCity/src/filtered.csv");System.out.println("""output  : <error> = """ + $show(output ))}
}
