import java.util.Map;


public class ExpressionInput extends Input {
	public Map<String, String> variableTypes; // Maps Vapor variable name to MiniJave Class name

	/**
	 * @param nextVariable
	 */
	public ExpressionInput(int nextVariableIndex, Map<String, String> variableTypes) {
		super(nextVariableIndex);
		this.variableTypes = variableTypes;
	}
}
