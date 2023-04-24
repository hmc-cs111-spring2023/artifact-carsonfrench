import com.github.nscala_time.time.Imports._
import scala.io.StdIn._

var loggedFoods : Map[String, Food] = Map.empty[String, Food]
var foodsEaten : List[Tuple2[Food,DateTime]] = List()
var meals : Map[String,List[Food]] = Map.empty[String,List[Food]]

class Food(val name: String, val calories: Int) {
    
    var tags : List[String] = List()
    def addTag(tag: String) = {
        tags:+tag
        log
    }
    
    def log = loggedFoods = loggedFoods + (name -> this)

    def eat = foodsEaten :+ (this, now)

    log

}

class Meal(val name: String, val foods: List[String])  // maybe add tags?


def food(name: String, calories: Int, tags: String*) : Food = {
    val newFood = Food(name, calories)
    tags.foreach(newFood.addTag)
    newFood.eat
    newFood
}
def food(name: String) : Food = {
    val result = loggedFoods.get(name)
    if (result == None) {
        println(s"Food not recognized. Please enter amount of calories for $name:")
        val cals = readInt()
        val newFood = food(name, cals)
        println("How many tags would you like to enter?")
        val tagAmount = readInt()
        var newTag = ""
        for (i <- 0 to tagAmount) {
            println("Enter tag: ")
            newTag = readLine()
            newFood.addTag(newTag)
        }
        newFood.eat
        newFood
    } else {
        result.get.eat
        result.get
    }
}

def meal(name: String, foods: String*) = 
    var foodList : List[Food] = List()
    foods.foreach(foodList)
// def meal(name: String)

def calories(food: Food) = food.calories
def calories(meal: Meal) = {
    var total = 0
    for (food <- meal.foods) {
        total += food.calories
    }
    total
}