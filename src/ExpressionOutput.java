import java.util.Map;


public class ExpressionOutput {
	public int nextVariableIndex;
	public String code;
	public String expressionVariable;
	public Map<String, String> variableTypes;
	
	/**
	 * @param nextVariable
	 * @param code
	 * @param expressionVariable
	 */
	public ExpressionOutput(String expressionVariable , String code, Map<String, String> variableTypes,
			int nextVariableIndex) {
		super();
		this.nextVariableIndex = nextVariableIndex;
		this.code = code;
		this.variableTypes = variableTypes;
		this.expressionVariable = expressionVariable;
	}
}
