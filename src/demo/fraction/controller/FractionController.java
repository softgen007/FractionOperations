package demo.fraction.controller;

import demo.fraction.constants.Operation;
import demo.fraction.exception.FractionException;
import demo.fraction.model.FractionNumber;
import demo.fraction.service.FractionService;

public class FractionController {

	FractionService fs;

	Operation operation;

	FractionNumber result;

	String regex;

	public FractionNumber perfromOperation(String input) {

		String[] ar = input.trim().split(" +");

		regex = "^(\\-)?\\d+(\\_\\d+\\/\\d+|/\\d+)?$";

		try {
			if (ar.length != 3 || ar[0].matches(regex) == false || ar[2].matches(regex) == false)
				throw new FractionException("Not a valid input");
		} catch (FractionException fe) {
			System.err.println("Fraction Exception: " + fe.getMessage());
			System.exit(1);
		}

		operation = Operation.getOperationName(ar[1]);

		fs = new FractionService();

		switch (operation.toString()) {
		case "MULTIPLY":

			result = fs.multiplyFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
			break;
		case "DIVIDE":

			result = fs.divideFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
			break;
		case "ADD":

			result = fs.addFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
			break;
		case "SUBTRACT":

			result = fs.subtractFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
			break;
		default:
			try {
				throw new FractionException("Unsupported Operation");
			} catch (FractionException fe) {
				System.err.println("Fraction Exception: " + fe.getMessage());
				System.exit(1);
			}
		}

		return result;

	}
}
