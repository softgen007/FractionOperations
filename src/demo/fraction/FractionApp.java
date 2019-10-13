package demo.fraction;

import java.util.Scanner;

import demo.fraction.controller.FractionController;
import demo.fraction.model.FractionNumber;
import demo.fraction.service.FractionService;

public class FractionApp {

	public static void main(String[] args) {
		//Sample input 5_2/3 * 3/2
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Input: ");
		String str = sc.nextLine();
		System.out.println("Str: " + str);
		sc.close();
		System.out.println("Str: " + str);
		//System.out.println(new FractionService().multiplyFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		//System.out.println(new FractionService().divideFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		//System.out.println(new FractionService().addFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		//System.out.println(new FractionService().subtractFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		System.out.println(new FractionController().perfromOperation(str));
	}

}
