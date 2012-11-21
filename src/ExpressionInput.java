import java.util.Map;
import java.util.Set;


public class ExpressionInput extends Input {
	public Map<String, String> variableTypes; // Maps Vapor variable name to MiniJave Class name
	public MJClass currentClass;
	public Set<String> localVariables; // names of parameters and local variables

	/**
	 * @param nextVariable
	 */
	public ExpressionInput(int nextVariableIndex, Map<String, String> variableTypes, MJClass currentClass, Set<String> localVariables) {
		super(nextVariableIndex);
		this.variableTypes = variableTypes;
		this.currentClass = currentClass;
		this.localVariables = localVariables;
	}
}
