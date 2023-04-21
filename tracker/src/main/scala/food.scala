
class Food(val name: String, val calories: Int) {
    
    var tags : List[String] = List()
    def addTag(tag: String) = tags:+tag

}

class Meal(val name: String, val foods: List[Food]) // maybe add tags?

var loggedFoods

def food(name: String, calories: Int, tags: String*) = {
    val newFood = Food(name, calories)
    tags.foreach(newFood.addTag)
    newFood
}
//def food(name: String)

def meal(name: String, foods: List[Food]) = Meal(name, foods)
// def meal(name: String)

def calories(food: Food) = food.calories
def calories(meal: Meal) = {
    var total = 0
    for (food <- meal.foods) {
        total += food.calories
    }
    total
}