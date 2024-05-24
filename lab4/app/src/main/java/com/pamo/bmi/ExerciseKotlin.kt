package com.pamo.bmi

class ExerciseKotlin {

    /**
     * Exercise 1:
     * Complete the code to make the program print "Mary is 20 years old" to standard output.
     */
    fun printMaryAge() {
        val name = "Mary"
        val age = 20
        println("$name is $age years old")
    }

    /**
     * Exercise 2:
     * Explicitly declare the correct type for each variable:
     */
    fun declareVariableTypes() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Exercise 3:
     * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total.
     */
    fun printTotalNumbers() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)  // Output will be 5
    }

    /**
     * Exercise 4:
     * You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol is supported or not.
     */
    fun checkProtocolSupport() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")  // Output will be "Support for smtp: false"
    }

    /**
     * Exercise 5:
     * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number.
     */
    fun spellNumber() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        val spelledOut = number2word[n]
        println("$n is spelt as '$spelledOut'")  // Output will be "2 is spelt as 'two'"
    }

    /**
     * Exercise 6:
     * Refactor the pizza slices counting to use a while loop.
     */
    fun countPizzaSlicesWhile() {
        var pizzaSlices = 0
        while (pizzaSlices < 8) {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        }
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Exercise 7:
     * Refactor the pizza slices counting to use a do-while loop.
     */
    fun countPizzaSlicesDoWhile() {
        var pizzaSlices = 0
        do {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        } while (pizzaSlices < 8)
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Exercise 8:
     * Simulate the Fizz buzz game.
     */
    fun fizzBuzzGame() {
        for (number in 1..100) {
            println(when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number.toString()
            })
        }
    }

    /**
     * Exercise 9:
     * Print words from a list that start with the letter 'l'.
     */
    fun printWordsStartingWithL() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (word in words) {
            if (word.startsWith("l")) {
                println(word)
            }
        }
    }

    /**
     * Exercise 10:
     * Refactor the function to translate time intervals into seconds using default parameters and named arguments for readability.
     */
    fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
        ((hours * 60) + minutes) * 60 + seconds

    fun demonstrateTimeIntervalConversion() {
        println(intervalInSeconds(1, 20, 15))
        println(intervalInSeconds(minutes = 1, seconds = 25))
        println(intervalInSeconds(hours = 2))
        println(intervalInSeconds(minutes = 10))
        println(intervalInSeconds(hours = 1, seconds = 1))
    }

    fun runExercises() {
        printMaryAge()
        declareVariableTypes()
        printTotalNumbers()
        checkProtocolSupport()
        spellNumber()
        countPizzaSlicesWhile()
        countPizzaSlicesDoWhile()
        fizzBuzzGame()
        printWordsStartingWithL()
        demonstrateTimeIntervalConversion()
    }
}

fun main() {
    val exercises = ExerciseKotlin()
    exercises.runExercises()
}
