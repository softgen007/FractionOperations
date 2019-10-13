package demo.fraction.model;

import demo.fraction.exception.FractionException;

public class FractionNumber {
	
	private int numerator;
	private int denominator;
	private int wholePart;
	
	public FractionNumber(String number) {
		denominator = 1;
		
		if(number.contains("_"))
			numerator = Integer.valueOf(number.split("/")[0].split("_")[1]);
		else if(number.contains("/"))
			numerator = Integer.valueOf(number.split("/")[0]);
		
		System.out.println("Numerator: " + numerator);
		
		if(number.contains("/"))
			denominator = Integer.valueOf(number.split("/")[1]);
			
		System.out.println("Denominator: " + denominator);
		
		try{
			if(denominator == 0)
				throw new FractionException("Denominator can not be zero");
		}catch(FractionException fe) {
			System.err.println("Fraction Exception: " + fe.getMessage());
			System.exit(1);
		}
			
		if(number.contains("_") || (!number.contains("/") && !number.contains("_")))
			wholePart = Integer.valueOf(number.split("_")[0]);
		
		System.out.println("Whole Part: " + wholePart);
		
		if(Math.abs(numerator) >= denominator && (denominator != 0 || denominator != 1))
			normalizeFraction();
		if(Math.abs(numerator) >= denominator && denominator > 1)
			convertToProperFraction();
		//System.out.println("FractionNumber: " + this.toString());
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public int getWholePart() {
		return wholePart;
	}

	public void setWholePart(int wholePart) {
		this.wholePart = wholePart;
	}
	
	public int getImproperNumerator() {
		int improperNumerator;
		if(wholePart == 0)
			return numerator;
		else 
			improperNumerator = wholePart * denominator + numerator;
		
		System.out.println("Improper Numerator: " + improperNumerator);
			return improperNumerator;
		
	}
	
	private void normalizeFraction(){
		int div = getCommonDivisor(Math.abs(numerator), denominator);
		System.out.println("GCD: " + div);
		numerator = numerator/div;
		System.out.println("Normalized Numerator: " + numerator);
		denominator = denominator/div;
		System.out.println("Normalized Denominator: " + denominator);
	}
	
	private int getCommonDivisor(int numerator, int denominator) {
		if(numerator%denominator == 0)
			return denominator;
		return getCommonDivisor(denominator, numerator%denominator);
	}
	
	private void convertToProperFraction() {
		wholePart = numerator/denominator;
		numerator = Math.abs(numerator%denominator);
		System.out.println("Proper Numerator: " + numerator);
		System.out.println("Proper WholePart: " + wholePart);
	}
	@Override
	public String toString() {
		
		if(numerator == 0)
			return String.valueOf(numerator);
		
		StringBuilder fractionNumber = new StringBuilder();
		
		if(wholePart != 0)
			fractionNumber = fractionNumber.append(wholePart + "_");
		fractionNumber = fractionNumber.append(numerator);
		if(denominator != 0 && denominator != 1)
			fractionNumber = fractionNumber.append("/" + denominator);
		//System.out.println("FractionNumber: " + fractionNumber);
		return fractionNumber.toString();
	}
	
	
}
