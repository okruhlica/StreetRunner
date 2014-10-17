package reverseGeo
import core.RoutePoint

object BSearchWorksheet {

val A = (for (i <- 0 to 10) yield i).map(i => (new RoutePoint(i,i/6)))
                                                  //> A  : scala.collection.immutable.IndexedSeq[core.RoutePoint] = Vector((0.0000
                                                  //| ,0.0000), (1.0000,0.0000), (2.0000,0.0000), (3.0000,0.0000), (4.0000,0.0000)
                                                  //| , (5.0000,0.0000), (6.0000,1.0000), (7.0000,1.0000), (8.0000,1.0000), (9.000
                                                  //| 0,1.0000), (10.0000,1.0000))

def smartEval(eval:RoutePoint=>Int)(A:Seq[RoutePoint]) =  {
	var result:Array[(RoutePoint, Int)] = Array()
	
	def scan(start: Int, end: Int, startFn: Int, endFn: Int):Array[(RoutePoint,Int)] = {
		if (start+1 >= end) return Array()
		
		val mid = start + (end-start)/2
		lazy val midFn = eval(A(mid))
		
		if (startFn == endFn)  return Array((A(mid),midFn))
		else {
			return scan(start, mid, startFn, midFn) ++
					   scan(mid, end, midFn, endFn)
		}
	}
	 
 scan(0,A.length-1, eval(A(0)), eval(A(A.length-1)))
}                                                 //> smartEval: (eval: core.RoutePoint => Int)(A: Seq[core.RoutePoint])Array[(cor
                                                  //| e.RoutePoint, Int)]

def evalFn(r:RoutePoint):Int = {
	print("/"+r)
	return r.lat.toInt
}                                                 //> evalFn: (r: core.RoutePoint)Int

smartEval(evalFn)(A).length                       //> /(0.0000,0.0000)/(10.0000,1.0000)/(5.0000,0.0000)/(2.0000,0.0000)/(7.0000,1.
                                                  //| 0000)/(6.0000,1.0000)/(8.0000,1.0000)res0: Int = 2

}