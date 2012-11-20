
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
	public MJMethod(String name, List<Map<String, String>> parameters, String returnType)
	{
		super();
		this.parameters = parameters;
		this.returnType = returnType;
		this.name = name;
	}
}
