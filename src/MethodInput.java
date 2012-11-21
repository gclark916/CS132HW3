import java.util.Map;


public class MethodInput extends Input {
	public String className;
	public Map<String, String> fields;

	/**
	 * @param nextVariableIndex
	 * @param className
	 * @param fields
	 */
	public MethodInput(int nextVariableIndex, String className,
			Map<String, String> fields) {
		super(nextVariableIndex);
		this.className = className;
		this.fields = fields;
	}
}
