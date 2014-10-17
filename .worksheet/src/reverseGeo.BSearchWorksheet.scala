package reverseGeo
import workout.RoutePoint

object BSearchWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(143); 

val A = (for (i <- 0 to 10) yield i).map(i => (new RoutePoint(i,i/6)));System.out.println("""A  : scala.collection.immutable.IndexedSeq[workout.RoutePoint] = """ + $show(A ));$skip(518); 

def smartEval(eval:RoutePoint=>Int)(A:Seq[RoutePoint]) =  {
	var result:Array[(RoutePoint, Int)] = Array()
	
	def scan(start: Int, end: Int, startFn: Int, endFn: Int):Array[(RoutePoint,Int)] = {
		if (start+1 >= end) return Array()
		
		val mid = start + (end-start) / 2
		lazy val midFn = eval(A(mid))
		
		if (startFn == endFn)  return Array((A(mid),midFn))
		else {
			return scan(start, mid, startFn, midFn) ++
					   scan(mid, end, midFn, endFn)
		}
	}
	 
 scan(0,A.length-1, eval(A(0)), eval(A(A.length-1)))
};System.out.println("""smartEval: (eval: workout.RoutePoint => Int)(A: Seq[workout.RoutePoint])Array[(workout.RoutePoint, Int)]""");$skip(70); 

def evalFn(r:RoutePoint):Int = {
	print("/"+r)
	return r.lat.toInt
};System.out.println("""evalFn: (r: workout.RoutePoint)Int""");$skip(29); val res$0 = 

smartEval(evalFn)(A).length;System.out.println("""res0: Int = """ + $show(res$0))}

}
