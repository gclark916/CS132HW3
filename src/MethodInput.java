

public class MethodInput extends Input {
	public MJClass currentClass;

	/**
	 * @param nextVariableIndex
	 * @param currentClass
	 */
	public MethodInput(int nextVariableIndex, MJClass currentClass) {
		super(nextVariableIndex);
		this.currentClass = currentClass;
	}
}
