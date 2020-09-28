/** Class: CMSC203 CRN 25800
 Program: Assignment #2
 Instructor: Grigoriy A. Grinberg 
 Summary of Description: A Random Number Guesser that will generate a random number that the user will have to guess and will continue asking until the guess is correct. 
 Due Date:09/20/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
*/



import java.util.Scanner;





public class RandomNumberGuesserDriver {
	public static void main(String[] args) {
		Scanner myScanner= new Scanner(System.in);
		//variables
		int randNum;
		int nextGuess;
		int highGuess;
		int lowGuess;
		String answer; 
		
		// do while loop to restart the program if the user wants to play again. 
		do {
			
			highGuess = 100; 
			lowGuess = 0;
			randNum = RNG.rand();
			RNG.resetCount();
			 
			
		
		System.out.println("Enter your first guess "); 
		
			//do while loop	that keeps looping until they guessed correctly
		do {
			
			nextGuess = myScanner.nextInt();
			// Validates the user inputs number and a if statement to determine if it's too high, low or that the user guessed it correctly. 
			if(!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
				nextGuess = myScanner.nextInt();
			}
			//Display the number of guess
			System.out.println("Number of guesses is  " + (int)RNG.getCount());
			
			if(nextGuess < randNum) {
				lowGuess = nextGuess;
				System.out.println("Your guess is too low ");
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			}else if (nextGuess > randNum) {
				highGuess = nextGuess;
				System.out.println("Your guess is too high");
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			}else if (nextGuess == randNum) {
				System.out.println("Congratulations, you guessed correctly");
			}
			

			
		}while (nextGuess != randNum);
			
		
	
		System.out.println("Try again? (yes or no)");
		myScanner.nextLine();
		answer = myScanner.nextLine();
		
}while (answer.equals("yes")); 
		
		System.out.println("Thanks for playing...");
		System.exit(0);
	}
	
}