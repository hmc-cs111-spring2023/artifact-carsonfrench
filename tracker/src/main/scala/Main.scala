import com.github.nscala_time.time.Imports._
import scala.io.StdIn.readLine

@main def foodDemo: Unit =
  food("burger", 100)
  food("pizza", 200)
  meal("lunch","pizza", "burger")

  food("burger")
  meal("lunch")

  food("banana", 50, "fruit")
  food("apple")
  food("broccoli")


  display (foods)