class Food(val calories: Int)
class Meal(val foods: List[Food])

val cheetos = Food(100)
val apple = Food(10)
val orange = Food(20)

val lunch = Meal(List(cheetos, apple, orange))

cheetos.calories

var foods = List("apple", "banana", "orange")

foods.getClass