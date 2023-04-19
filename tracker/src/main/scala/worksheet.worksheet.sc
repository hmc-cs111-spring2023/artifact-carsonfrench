//handles reading and writing the csv files
import java.io.File
import kantan.csv._         // All kantan.csv types.
import kantan.csv.ops._     // Enriches types with useful methods.
import kantan.csv.generic._ // Automatic derivation of codecs.

//handles the date and time
import com.github.nscala_time.time.Imports._

//
class Food(val name: String, val calories: Int, val tags: String*) { // need to maybe switch the type to List[String]
    
    var tagList : List[String] = List()
    
    for (i <- tags) tagList :+ i
    new File("food").asCsvWriter[String, Int, List[String]](rfc).write(name, calories, tagList).close() //still need to account for overwriting existing foods
    def addTag(tag: String) = tagList:+tag
    new File("foods_tracked.csv").asCsvWriter[String, DateTime](rfc).write(name,DateTime.now()).close()

} 
class Meal(val name: String, val foods: String*, val newFoods: Food*) // need to add a method that logs the meal
// would tags be helpful for meals?

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

val pasta = food("pasta", 100)
val breakfast = meal("breakfast", List(pasta, food("pizza", 200)))

calories(pasta)
calories(breakfast)


food("steak", 500, "protein")