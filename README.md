# Scalorie Tracker

Scalorie Tracker is an internal DSL in Scala that can be used to track data on calories and foods eaten as well as body weight. 

To log you weight simply just use the weight function and enter your weight. This will log your weight at the time of running the program. You can also optionally add a different time as a second parameter.

weight(100)

weight(235, now - 3.weeks)

The food function logs that you ate a food at the time of running the code. You can also add tags to foods. You only need to enter the calories and tags the first time you log a food. 

food("hot dog", 200, "pork", "protein")

food("hot dog")

A meal allows you to enter multiple foods together at once. The first parameter is the name of the meal and the rest are the foods in the meal. You only have to enter the foods the first time you log the meal.

meal("breakfast", "eggs", "bacon", "toast")
meal("breakfast")

To display weight data use display(weights)

To display food data use display(foods)
