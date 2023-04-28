import com.github.nscala_time.time.Imports._
import com.datawizards.splot.api.implicits._

case class FoodPlot(name: String, calories: Int, date: DateTime)

def graph = {
    loggedFoods.plotline()
}

// def graph (data: String, start: DateTime)

// def graph (data: String, start: DateTime, end: DateTime = now)