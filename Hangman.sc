import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.io.StdIn

package Mistake:
    def print0Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |       ")
      println("  |")
      println("  |")
      println("  |")
      println(" /|\\")
      println("/ | \\")
     
    def print1Mistake() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |")
      println("  |")
      println("  |")
      println(" /|\\")
      println("/ | \\")
     
    def print2Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |      |")
      println("  |      |")
      println("  |")
      println(" /|\\")
      println("/ | \\")
     
    def print3Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |     /|")
      println("  |      |")
      println("  |")
      println(" /|\\")
      println("/ | \\")
     
    def print4Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |     /|\\")
      println("  |      |")
      println("  |")
      println(" /|\\")
      println("/ | \\")
     
    def print5Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |     /|\\")
      println("  |      |")
      println("  |     /")
      println(" /|\\")
      println("/ | \\")
     
    def print6Mistakes() =
      println("  |------|-")
      println("  |      |")
      println("  |      O")
      println("  |     /|\\")
      println("  |      |")
      println("  |     / \\")
      println(" /|\\")
      println("/ | \\")

object Main {
    val words = List("elbow", "writer", "circle", "polish", "bridge", "store", "fang", "scarecrow", "show", "jeans", "wilderness", "attempt", "waxing", "aftermath", "banana", "wrist", "wheel", "spring", "cherries", "nerve")
    var word =""
    var guesses = ArrayBuffer[Char]()
    var remainingGusses = 6
    var mistakes = 0
    
    
    def main(args: Array[String]) = {
        val wordIndex = Random.nextInt(words.size)
        word = words(wordIndex).toUpperCase
        println(word)
        
        for(i <- word.indices)
            guesses.addOne('-')
            
        var gameover = false
        
        while(!gameover)
            printGameStatus(mistakes)
            print("Please Enter A Letter: ")
            val input = StdIn.readLine()
            
            if(input.isEmpty) println("Thats not a valid Input")
            else
                val letter = input.charAt(0).toUpper
                if(word.contains(letter))
                    for(i <- word.indices)
                        if(word.charAt(i) == letter) 
                            guesses(i) = letter
                        if(!guesses.contains('-'))
                            gameover = true
                else
                    println("Thats a wrong guess!!!")
                    mistakes +=1
                    remainingGusses -=1
                    if(mistakes == 6) gameover = true
                    
        if(mistakes == 6)
            printGameStatus(mistakes)
            println(s"Sorry, You lost!! The word was: $word")
        else
            println(s"Congarts You guessed the word. The word was: $word")
            println(s"You guessed the word with $remainingGusses guesses remaining")
    }
    
    
    
    def printGameStatus(mistake : Int) = {
        mistake match
            case 0 => Mistake.print0Mistakes()
            case 1 => Mistake.print1Mistake()
            case 2 => Mistake.print2Mistakes()
            case 3 => Mistake.print3Mistakes()
            case 4 => Mistake.print4Mistakes()
            case 5 => Mistake.print5Mistakes()
            case 6 => Mistake.print6Mistakes()
            
        print("Word: ")
        for(element <- guesses)
            print(s"$element")
        println()
        
        println(s"Remaining Guesses: $remainingGusses")
    }
    
}
