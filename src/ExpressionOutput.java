
public class ExpressionOutput {
	public int nextVariableIndex;
	public String code;
	public String expressionVariable;
	
	/**
	 * @param nextVariable
	 * @param code
	 * @param expressionVariable
	 */
	public ExpressionOutput(String expressionVariable , String code,
			int nextVariableIndex) {
		super();
		this.nextVariableIndex = nextVariableIndex;
		this.code = code;
		this.expressionVariable = expressionVariable;
	}
}
