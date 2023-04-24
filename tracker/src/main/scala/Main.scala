import com.github.nscala_time.time.Imports._
import scala.io.StdIn.readLine

@main def hello: Unit =
  weight(150)
  weight(230, now)
  weight(235, now - 3.weeks)

  food("hamburger", 100, "sanwich")
  food("hotdog", 112)
  meal("BBQ", "hamburger", "hotdog")
  calories("hamburger")
  calories("hotdog")
  calories("BBQ")