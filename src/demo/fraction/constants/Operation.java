package demo.fraction.constants;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

	MULTIPLY("*"),
	DIVIDE("/"),
	ADD("+"),
	SUBTRACT("-");
	
	private String operation;
	
	Operation(String operator){
		this.operation = operator;
	}
	
	public String getOperation() {
		return operation;
	}
	private static final Map<String, Operation> operations = new HashMap<String, Operation>();
	
	static
	{
		for (Operation op : Operation.values()) {
			operations.put(op.getOperation(), op);
		}
	}
	
	public static Operation getOperationName(String operator) {
		if(operations.get(operator) == null)
			throw new IllegalArgumentException("Not a valid Operator");
		return operations.get(operator);
	}
	
}
