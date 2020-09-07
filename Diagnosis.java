import java.util.Scanner;

public class Diagnosis {
	public static void main(String args[]) {

		Scanner myScanner = new Scanner(System.in);
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		String answer = myScanner.nextLine();

		if (answer.equals("yes")) {
			System.out.println("Rebooting your computer seemed to work.");
			System.exit(0);
		} else {
			System.out.println(
					"Second step: reboot your router\n Now are you able to connect with the internet? (yes or no)");
		}

		String answer2 = myScanner.nextLine();

		if (answer2.equals("yes")) {
			System.out.println("Rebooting router seemed to work.");
			System.exit(0);
		} else {
			System.out.println(
					"Third step: make sure the cables to your router are plugged in frimly and your router is getting power\n Now are you able to connect with the internet? (yes or no)");
		}

		String answer3 = myScanner.nextLine();

		if (answer3.equals("yes")) {
			System.out.println("Checking the router's cables seemed to work.");
			System.exit(0);
		} else {
			System.out.println(
					"Fourth step: move your computer closer to your router\n Now are you able to connect with the internet? (yes or no)");
		}

		String answer4 = myScanner.nextLine();

		if (answer4.equals("yes")) {
			System.out.println(" Moving your computer closer to your router seemed to work.");
			System.exit(0);
		} else
			System.out.println(" Fifth step: contact your ISP\n Make sure your ISP is hooked up to your router.");
	}

}
