import java.util.Scanner;
import java.util.Random;

public class Lottery {

	public static boolean checkForYes(String value) {
		if (value.equals("y") || value.equals("yes")) {
			return true;
		}

		return false;

	}

	public static int rangeCheck(int value, int minimum, int maximum) {

		int rangeSize = (maximum = minimum) + 1;
		while (value > maximum) {
			value -= rangeSize;
		}
		while (value < minimum) {
			value += rangeSize;
		}
		return value;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = input.nextLine();

		System.out.println("Hello " + name);

		System.out.println("Do you wish to play the lottery?");
		String answer = input.nextLine();
		if (!checkForYes(answer)) {
			System.out.println("Please come back another time to play.");
			System.exit(0);
		}

		System.out.println("What is your favorite pets name?");
		String petName = input.nextLine();

		System.out.println("What is your favorite pets age?");
		int petAge = Integer.parseInt(input.nextLine());

		System.out.println("What is your lucky number?");
		int luckyNumber = Integer.parseInt(input.nextLine());

		System.out.println("Do  you have a fav quarterback?");
		String qbReply = input.nextLine();
		Integer jerseyNumber = null;
		if (checkForYes(qbReply)) {
			System.out.println("Whats their jersey number?");
			jerseyNumber = Integer.parseInt(input.nextLine());
		}

		System.out.println("What is your cars two-digit year model?");
		int carYear = Integer.parseInt(input.nextLine());

		System.out.println("What is your favorite actors name?");
		String actorName = input.nextLine();

		System.out.println("Enter a number between 1 and 50");
		int randomNumber = Integer.parseInt(input.nextLine());

		int magicNumber;
		if (qbReply.equalsIgnoreCase("no")) {
			magicNumber = luckyNumber;
		} else {
			try {
				int quarterbackNumber = Integer.parseInt(qbReply);
				magicNumber = quarterbackNumber * luckyNumber;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input for quarterback number. Magic number will be based on lucky number.");
				magicNumber = luckyNumber;
			}
		}

		int[] lotteryNumbers = new int[5];
		lotteryNumbers[1] = carYear + luckyNumber;
		lotteryNumbers[3] = actorName.charAt(0);
		lotteryNumbers[4] = actorName.charAt(actorName.length() - 1);

		System.out.print("Lottery numbers: ");
		for (int i = 0; i < lotteryNumbers.length; i++) {
			int lotteryNumber = lotteryNumbers[i];

			System.out.print(lotteryNumber);
			if (i != lotteryNumbers.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("  Magic ball: " + magicNumber);

		System.out.println("Thank you for playing the lottery!");

	}

}
