//Yifan Dai
//02/11/2020
//TA: Kendra Specht
// Assignment #5
//
/*This program will ask user to play a guessing game using
Random, Scanner, if/else, and while loop methods. If user no
longer want to play the game, the system will report their
overall results.*/
import java.util.*;

public class GuessingGame{
   public static final int MAX = 100;
   public static void main(String[] args){
      intro();
      int game = 0;//set total number of game to 0 from start
      int tries = 0;
      int bestGame = 1;
      int total_tries = 0;
      Scanner input = new Scanner(System.in);
      Random r = new Random();
      Game(input, r, game, tries, total_tries, bestGame);
   }
   
   //Introduce the game to user by a haiku poem
   public static void intro(){
      System.out.println("Are you ready now?");//5
      System.out.println("You will need to guess numbers");//7
      System.out.println("Let's start to play!");//5
      System.out.println();
   }
   
   //Continue to prompt the user for numbers until the user type in
   //the right number using while loop.Returns total tries that user played.
   //parameters needed:
   //    input    = to prompt for numbers
   //    r        = randomly picked number
   //    game     = total games played
   //    tries    = guesses user tried each game
   // total_tries = total guesses user tried for all games
   // bestGame    = the fewst number of guesses user tried in any game
   public static int Game(Scanner input, Random r, int game,
   int tries, int total_tries, int bestGame){
      System.out.println("I'm thinking of a number between 1 and "+ MAX + "...");
      game++;
      int previous = tries;//the last tries user played
      int number = r.nextInt(MAX) + 1;//want a number in the range of 1- 100
      int guess = 0;
      tries = 0;//reset to 0 for a new game
      
      while(guess != number){
         System.out.print("Your guess? ");
         guess = input.nextInt();//read in user type in
         tries ++;
         if(guess > number){
            System.out.println("It's lower");
         }else{// guess < number
            System.out.println("It's higher");
         }
      }
      System.out.println("You got it right in " + tries + " guesses!");
      total_tries += tries;
      int current = tries;//tries user palyed in the latest game
      if(current < previous){
         bestGame = game;
      }
      playAgain(input, r, game, tries, total_tries, bestGame);
      return total_tries;
   }
   
   //Asks the user if he/she want to play again
   //Backs to Game method if user type in first character with y or Y
   //Goes to overall method once user type in other character
   //parameters needed:
   // input       = to read in user's reply
   // r           = randomly picked number
   // game        = total games user played
   // tries       = total guess user tried per game
   // total_tries = sum of all tris in all games user played
   // bestGame    = the fewst number of guesses user tried in any game
   public static void playAgain(Scanner input, Random r, int game,
   int tries, int total_tries, int bestGame){
      System.out.print("Do you want to play again? ");
      String reply = input.next().toLowerCase();/* read in user's type in
                                                 convert to lower case */
      if(reply.startsWith("y")){
         System.out.println();
         Game(input, r, game, tries, total_tries, bestGame);
      }else{ //if user type in other characters
         System.out.println();
         overall(game, total_tries, bestGame);
      }
   }
   
   //Prints out stastics of games user played
   //Calcultes average number of guesses per game rounded to the nearest tenth
   //paramters needed:
   // game        = total games user played
   // total_tries = total guesses user tried for all games
   // bestGame    = the fewst number of guesses user tried in any game
   public static void overall(int game, int total_tries, int bestGame){
      double average = (double)total_tries / game;
      System.out.println("Overall results:");
      System.out.println("Total games   = " + game);
      System.out.println("Total guesses = " + total_tries);
      System.out.printf("Guesses/game  = " + "%.1f\n", average);
      System.out.println("Best game     = " + bestGame);
   }
}