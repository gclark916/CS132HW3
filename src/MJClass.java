

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MJClass {
	public Map<String, MJMethod> methods;	// Map of method name-> Method. Assumes no overloading of method names.
	public Map<String, MJField> fields;	// Map of field name -> Type name
	public String name;
	public MJClass parentClass;
	
	/**
	 * @param methods
	 * @param fields
	 * @param name
	 * @param parentClass
	 */
	public MJClass(Map<String, MJMethod> methods, Map<String, MJField> fields,
			String name, MJClass parentClass) {
		super();
		this.methods = methods;
		if (this.methods == null)
		{
			this.methods = new HashMap<String, MJMethod>();
		}
		this.fields = fields;
		if (this.fields == null)
		{
			this.fields = new HashMap<String, MJField>();
		}
		this.name = name;
		this.parentClass = parentClass;
	}

	public Map<String, MJMethod> getMethods() 
	{
		Map<String, MJMethod> completeMethods = new HashMap<String, MJMethod>();
		
		if (parentClass != null)
		{
			completeMethods.putAll(parentClass.methods);
			completeMethods.putAll(methods);
		}
		else
		{
			completeMethods.putAll(methods);
		}
		return completeMethods;
	}
	
	public Map<String, MJField> getFields() 
	{
		Map<String, MJField> completeFields = new HashMap<String, MJField>();
		
		if (parentClass != null)
		{
			completeFields.putAll(parentClass.fields);
			completeFields.putAll(fields);
		}
		else
		{
			completeFields.putAll(fields);
		}
		return completeFields;
	}

	static Set<String> getClassNames(Set<MJClass> classes)
	{
		Set<String> classNames = new HashSet<String>();
		Iterator<MJClass> classIterator = classes.iterator();
		while (classIterator.hasNext())
		{
			MJClass mjclass = classIterator.next();
			classNames.add(mjclass.name);
		}
		return classNames;
	}
}
