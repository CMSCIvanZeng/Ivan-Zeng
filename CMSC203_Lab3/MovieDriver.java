import java.util.Scanner;

public class MovieDriver {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		Movie userMovie = new Movie(); 
		
		
		int soldTickets;
		String title, rating, answer;
		



		do {

			System.out.println("Enter the name of a movie ");
			userMovie.setTitle(myScanner.nextLine());

			System.out.println("Enter the rating of the movie ");
			userMovie.setRating(myScanner.nextLine());

			System.out.println("Enter the number of tickets sold for this movie");
			userMovie.setSoldTickets(myScanner.nextInt());


			System.out.print(userMovie.getTitle());
			System.out.print(" (");
			System.out.print(userMovie.getRating());
			System.out.print("): ");
			System.out.print("Tickets Sold: ");
			System.out.println(userMovie.getSoldTickets());

			System.out.println("Do you want to enter another? (y or n)");
			myScanner.nextLine();
			answer = myScanner.nextLine();

			if(answer.equals("n")) {
				System.out.println("Goodbye");
				System.exit(0);
			}

		}
		while (answer.equals("y"));




	}


}
