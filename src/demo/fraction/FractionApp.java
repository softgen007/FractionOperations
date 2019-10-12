package demo.fraction;

import demo.fraction.model.FractionNumber;
import demo.fraction.util.FractionOperations;

public class FractionApp {

	public static void main(String[] args) {
		String operand1 = "-3_1/2";
		String operand2 = "3/2";
		
		System.out.println(new FractionOperations().multiplyFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		System.out.println(new FractionOperations().divideFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		System.out.println(new FractionOperations().addFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

		System.out.println(new FractionOperations().subtractFractions(new FractionNumber(operand1), new FractionNumber(operand2)));

	}

}
