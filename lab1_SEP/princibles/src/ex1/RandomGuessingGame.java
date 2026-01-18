package ex1;
import java.util.Random;
import java.util.Scanner;

public class RandomGuessingGame {

	public static void main(String[] args) {
		 Random random= new Random();
		 Scanner scanner= new Scanner(System.in);
		 boolean playAgain=true;
		 
		 while (playAgain){
			 int secretNumber = random.nextInt(100) + 1;
			 int maxAttempts=5;
			 int attemptCount=0;
			 int userGuess=-1;
			 boolean isValidInput;
			 
			 long startTime = System.currentTimeMillis();
			 System.out.println("Welcome to the number guessing game");
			 System.out.println("Please guess a number between 1 and 100");
			 System.out.println("You have "+ maxAttempts+" attempts");
			 
			 while (attemptCount < maxAttempts) {

				    System.out.print("Enter your guess: ");

				    if (!scanner.hasNextInt()) {
				        System.out.println("Invalid input. Please enter a number.");
				        scanner.next(); // clear invalid input
				        attemptCount++;
				        continue;
				    }

				    userGuess = scanner.nextInt();
				    attemptCount++;

				    if (userGuess < 1 || userGuess > 100) {
				        System.out.println("Please enter a number between 1 and 100.");
				        continue;
				    }

				    if (userGuess < secretNumber) {
				        System.out.println("Higher!");
				    } else if (userGuess > secretNumber) {
				        System.out.println("Lower!");
				    } else {
				        System.out.println("Correct! You guessed the number.");
				        break;
				    }
				}
				 
				 long endTime = System.currentTimeMillis();
				 long timeTaken=(endTime-startTime)/1000;
				 
				 
				 if(userGuess!= secretNumber) {
					 System.out.println("You ran out of attempts");
					 System.out.println("The correct number was "+ secretNumber);
				 }
				 System.out.println("Attempts used "+ attemptCount);
				 System.out.println("Time taken: "+ timeTaken +"secounds");
				 
				 System.out.println("Do you want to play again?(yes/no)");
				 String answer= scanner.next();
				 playAgain= answer.equalsIgnoreCase("yes");
				 System.out.println();
				 
				 
			 }

		 System.out.println("Thank you for playing the game");
		 
		 scanner.close();
	}
}
