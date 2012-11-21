import java.util.Map;


public class MethodInput {
	public int nextVariableIndex;
	public String className;
	public Map<String, String> fields;

	/**
	 * @param nextVariableIndex
	 * @param className
	 * @param fields
	 */
	public MethodInput(int nextVariableIndex, String className,
			Map<String, String> fields) {
		super();
		this.nextVariableIndex = nextVariableIndex;
		this.className = className;
		this.fields = fields;
	}
}
