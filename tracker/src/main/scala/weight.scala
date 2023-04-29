import com.github.nscala_time.time.Imports._

var weightsTracked : List[Tuple2[Int,DateTime]] = List()

def weight(newWeight:Int, time:DateTime = now) = 
    weightsTracked = weightsTracked :+ (newWeight, time)

