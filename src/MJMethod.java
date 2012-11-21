
import java.util.List;
import java.util.Map;


public class MJMethod 
{
	public List<Map<String, String>> parameters;
	public String returnType;
	public String name;
	public int methodTableIndex;
	
	/**
	 * @param parameterTypes
	 * @param returnType
	 * @param name
	 */
	public MJMethod(String name, List<Map<String, String>> parameters, String returnType, int methodTableIndex)
	{
		super();
		this.parameters = parameters;
		this.returnType = returnType;
		this.name = name;
		this.methodTableIndex = methodTableIndex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + methodTableIndex;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result
				+ ((returnType == null) ? 0 : returnType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MJMethod other = (MJMethod) obj;
		if (methodTableIndex != other.methodTableIndex)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (returnType == null) {
			if (other.returnType != null)
				return false;
		} else if (!returnType.equals(other.returnType))
			return false;
		return true;
	}
}
