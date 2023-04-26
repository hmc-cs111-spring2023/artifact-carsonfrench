import com.github.nscala_time.time.Imports._
import scala.io.StdIn._

var loggedFoods : Map[String, Food] = Map.empty[String, Food]
var foodsEaten : List[Tuple2[Food,DateTime]] = List()
var meals : Map[String,Meal] = Map.empty[String,Meal]

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

// maybe add tags?
class Meal(val name: String, val foods: List[String]) {

    var foodList : List[Food] = List()
    for (food <- foods) {
        var newFood = loggedFoods.get(food)
        if (newFood.isDefined) foodList = newFood.get :: foodList
    }
    
    def log = meals = meals + (name -> this)

    def eat = for(food <- foodList) food.eat
    
    log
} 

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
        for (i <- 0 to tagAmount-1) {
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

def meal(name: String, foods: String*) = {
    var foodList : List[String] = List()
    for (food <- foods) {
        foodList = food :: foodList
    }
    val newMeal = Meal(name, foodList)
    newMeal.eat
    newMeal
}
def meal (name: String) = {
    val newMeal = meals.get(name)
    if(newMeal.isDefined) newMeal.get.eat
    else println("Meal not found.")
}

def calories(food: Food) = println(food.calories)
def calories(meal: Meal) = {
    var total = 0
    for (food <- meal.foodList) {
        total = total + food.calories
    }
    println(meal.name)
    for (food <- meal.foodList) {
        printf("%s: %d calories", food.name, food.calories)
        println()
    }
    printf("Total: %d", total)
    println()
}
def calories (name: String) : Unit = {
    val food = loggedFoods.get(name)
    if (food.isDefined) {
        println(food.get.calories)
    }
    val meal = meals.get(name)
    if (meal.isDefined) {
        calories(meal.get)
    }
}
