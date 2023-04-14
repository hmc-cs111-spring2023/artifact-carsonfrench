class Food(val name: String, val calories: Int) // need to add a method that logs the food as well as tags
class Meal(val name: String, val foods: List[Food]) // need to add a method that logs the meal
// would tags be helpful for meals?

def food(name: String, calories: Int) = Food(name, calories)
def meal(name: String, foods: List[Food]) = Meal(name, foods)

def calories(food: Food) = food.calories
def calories(meal: Meal) = {
    var total = 0
    for (food <- meal.foods) {
        total += food.calories
    }
    total
}

val pasta = food("pasta", 100)
val breakfast = meal("breakfast", List(pasta, food("pizza", 200)))

calories(pasta)
calories(breakfast)
