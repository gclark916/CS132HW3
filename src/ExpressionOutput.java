import java.util.Map;


public class ExpressionOutput extends Output {
	public String expressionVariable;
	public Map<String, String> variableTypes;
	
	/**
	 * @param nextVariable
	 * @param code
	 * @param expressionVariable
	 */
	public ExpressionOutput(String expressionVariable , String code, Map<String, String> variableTypes,
			int nextVariableIndex) {
		super(code, nextVariableIndex);
		this.variableTypes = variableTypes;
		this.expressionVariable = expressionVariable;
	}
}
