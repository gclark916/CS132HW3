import java.io.FileInputStream;
import java.io.FileNotFoundException;

import syntaxtree.*;

public class J2V {
	
	public static void main(String [] args) 
	{
		try {
			FileInputStream fileInput = new FileInputStream("test/Factorial.java");
			System.setIn(fileInput);
			Node root = new MiniJavaParser(System.in).Goal();
			System.out.println("Program parsed successfully");

			TranslateToVaporVisitor visitor = new TranslateToVaporVisitor();
			root.accept(visitor, null);
		}
		catch (ParseException e) 
		{
			System.out.println(e.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
