import com.github.nscala_time.time.Imports._

@main def hello: Unit =
  weight(150)
  weight(230, now)
  weight(235, now - 3.weeks)