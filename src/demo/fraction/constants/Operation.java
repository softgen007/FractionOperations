package demo.fraction.constants;

import java.util.HashMap;
import java.util.Map;

import demo.fraction.exception.FractionException;

public enum Operation {

	MULTIPLY("*"), DIVIDE("/"), ADD("+"), SUBTRACT("-");

	private String operation;

	Operation(String operator) {
		this.operation = operator;
	}

	public String getOperation() {
		return operation;
	}

	private static final Map<String, Operation> operations = new HashMap<String, Operation>();

	static {
		for (Operation op : Operation.values()) {
			operations.put(op.getOperation(), op);
		}
	}

	public static Operation getOperationName(String operator) {
		try {
			if (operations.get(operator) == null)
				throw new FractionException("Not a valid Operator");
		} catch (FractionException fe) {
			System.err.println("Fraction Exception: " + fe.getMessage());
			;
			System.exit(1);
		}

		return operations.get(operator);
	}

}
