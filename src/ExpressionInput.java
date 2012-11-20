import java.util.Map;


public class ExpressionInput {
	public int nextVariableIndex;
	public Map<String, String> variableTypes; // Maps Vapor variable name to MiniJave Class name

	/**
	 * @param nextVariable
	 */
	public ExpressionInput(int nextVariableIndex, Map<String, String> variableTypes) {
		super();
		this.nextVariableIndex = nextVariableIndex;
		this.variableTypes = variableTypes;
	}
}
