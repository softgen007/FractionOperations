package demo.fraction.controller;

import demo.fraction.constants.Operation;
import demo.fraction.exception.FractionException;
import demo.fraction.model.FractionNumber;
import demo.fraction.service.FractionService;

public class FractionController {

	String operator;
	
	FractionService fs;
	
	Operation operation;
	
	FractionNumber result;
	
	String regex;
	
	public FractionNumber perfromOperation(String input) {
		
		String[] ar = input.trim().split(" +");
		
		regex = "^\\d+(\\_\\d+\\/\\d+|/\\d+)?$";
		System.out.println("Matches: " + ar[0].matches(regex));
		try{
		if(ar.length != 3 || ar[0].matches(regex) == false || ar[2].matches(regex) == false)
			throw new FractionException("Not a valid input");
		}catch(FractionException fe) {
			System.err.println("Fraction Exception: " + fe.getMessage());
			System.exit(1);
		}
		
		operator = ar[1];
		
		operation = Operation.getOperationName(operator);
		System.out.println("Operation: " + operation);
		
		fs = new FractionService();
		
		switch(operation.toString()) {
			case "MULTIPLY":
				System.out.println("Multiplication");
				result = fs.multiplyFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
				break;
			case "DIVIDE":
				System.out.println("Division");
				result = fs.divideFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
				break;
			case "ADD":
				System.out.println("Addition");
				result = fs.addFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
				break;
			case "SUBTRACT":
				System.out.println("Subtraction");
				result = fs.subtractFractions(new FractionNumber(ar[0]), new FractionNumber(ar[2]));
				break;
			default:
				try{
				throw new FractionException("Invalid Operation");
				}catch(FractionException fe) {
					System.err.println("Fraction Exception: " + fe.getMessage());
					System.exit(1);
				}
		}
		
		return result;
		
			
	}
}
