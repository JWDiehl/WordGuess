package com.github.zipcodewilmington.sample;

import java.util.Random;
import java.util.Scanner;

public class Wordguess {
    //Jonathan Diehl

    public static void main(String[] args) {
        boolean isGameOn = true;
        while (isGameOn) {
            //System Out Print "Let's Play Wordguess version 1.0"
            System.out.println("Let's Play Wordguess version 1.0");
            //Create an array of words
            String[] words = {"birds", "phils", "sixers", "flyers", "union"};

            //Generate random index for user to select from an array
            Random random = new Random();
            int randomWords = random.nextInt(words.length);
            String solution = words[randomWords];

            //Initialize new variables from above
            Scanner scanner = new Scanner(System.in);
            //Give player n tries based on array.length
            int maxTries = words.length;
            int triesLeft = maxTries;
            boolean guessedCorrectly = false;
            StringBuilder currentGuesses = new StringBuilder("_".repeat(solution.length()));

            //Let's Loop these words!!
            while (triesLeft > 0) {
                //current state of guessed characters
                System.out.print("What is the letter you wish to guess?");
                System.out.println(currentGuesses.toString());

                //prompt user to guess the word
                System.out.println("You have " + triesLeft + " tries left.");
                System.out.println("Enter a single character or guess the entire word: ");
                String guess = scanner.nextLine().toLowerCase();

                if (guess.length() == 1) {
                    //check if their guess was in the solution
                    boolean found = false;
                    for (int i = 0; i < solution.length(); i++) {
                        if (solution.charAt(i) == guess.charAt(0)) {
                            currentGuesses.setCharAt(i, guess.charAt(0));
                            found = true;
                        }
                    }
                    if (!found) {
                        triesLeft--;
                    }
                } else if (guess.equals(solution)) {
                    //check if they got the word correct (all letters)!
                    guessedCorrectly = true;
                    break;
                } else {
                    System.out.println("Wrong guess! Please guess again.");
                    continue;
                }

                //Check if they got it right
                if (currentGuesses.toString().equals(solution)) {
                    guessedCorrectly = true;
                    break;
                }
            }

            //Final Countdown
            if (guessedCorrectly) {
                System.out.println("**** ****");
                System.out.println(solution);
                System.out.println("Congratulations, You Won!");
            } else {
                System.out.println(":-( :-( :-(");
                System.out.println(solution);
                System.out.println("You lost! And you ran out of guesses.");
            }

            //Ask them if they want to play again
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (playAgain.equals("yes")) {
//                main(args); // Having trouble figuring out how to get the method to restart if user decides "yes" -> While True ()
            } else {
                System.out.println("Game Over.");
                scanner.close();
                break;
            }
        }
    }
}

//            //Let's see if it matches the correct answer
//            if (guess.equalsIgnoreCase(solution)) {
//                System.out.println("Congratulations! You guessed the word correctly: " + solution);
//                guessedCorrectly = true;
//                break;
//            } else {
//                System.out.println("Incorrect guess. Try again.");
//            }
//            tries++;
//        }
//
//        //If user is out of tries --> HAH! Ya lost
//        if (!guessedCorrectly) {
//            System.out.println("Ya lost! You ran out of guesses.");
//        }
//        scanner.close();
//    }
//}
//

//One array will be the solution, the others will be false
//WHILE number of tries < tries allowed && the player has not guess the word -->
    //System.print.ln(Current Guesses)
    //ask players for a character
    //if players types "-" --> return quit game
    //else run char through system
    //if letter is in correct_word -->
        //Congratulations, You Won!
        //Would you like to play again? (yes/no)
//after the while loop
//if the word is not guessed, player loses