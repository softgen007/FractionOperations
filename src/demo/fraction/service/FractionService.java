package demo.fraction.service;

import demo.fraction.model.FractionNumber;

public class FractionService {

	public FractionNumber multiplyFractions(FractionNumber op1, FractionNumber op2) {
		int num = op1.getImproperNumerator() * op2.getImproperNumerator();
		int den = op1.getDenominator() * op2.getDenominator();

		return new FractionNumber(num + "/" + den);
	}

	public FractionNumber divideFractions(FractionNumber op1, FractionNumber op2) {
		int num = op1.getImproperNumerator() * op2.getDenominator();
		int den = op1.getDenominator() * op2.getImproperNumerator();

		return new FractionNumber(num + "/" + den);
	}

	public FractionNumber addFractions(FractionNumber op1, FractionNumber op2) {
		int num = (op1.getImproperNumerator() * op2.getDenominator())
				+ (op2.getImproperNumerator() * op1.getDenominator());
		int den = op1.getDenominator() * op2.getDenominator();

		return new FractionNumber(num + "/" + den);
	}

	public FractionNumber subtractFractions(FractionNumber op1, FractionNumber op2) {
		int num = (op1.getImproperNumerator() * op2.getDenominator())
				- (op2.getImproperNumerator() * op1.getDenominator());
		int den = op1.getDenominator() * op2.getDenominator();

		return new FractionNumber(num + "/" + den);
	}
}
