import com.github.nscala_time.time.Imports._
import com.datawizards.splot.api.implicits._

case class Display (val name: String, val tag: String = "") 
 
val weights = Display("weights")
val foods = Display("foods")

def tag (tag: String) =
    Display(tag)

def display (entry: Display) =
    if (entry.name == "weights") {
        println(weightsTracked)
    }
    if (entry.name == "foods") {
        println(foodsEaten)
        println("")
        println(loggedFoods)
    }