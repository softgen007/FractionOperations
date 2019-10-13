package demo.fraction;

import java.util.Scanner;

import demo.fraction.controller.FractionController;

public class FractionApp {

	public static void main(String[] args) {
		// Sample input 5_2/3 * 3/2

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Input: ");

		String str = sc.nextLine();

		sc.close();

		System.out.println("Result: " + new FractionController().perfromOperation(str));
	}

}
