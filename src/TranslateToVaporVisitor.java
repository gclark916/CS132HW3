import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import syntaxtree.AllocationExpression;
import syntaxtree.AndExpression;
import syntaxtree.ArrayAllocationExpression;
import syntaxtree.ArrayAssignmentStatement;
import syntaxtree.ArrayLength;
import syntaxtree.ArrayLookup;
import syntaxtree.ArrayType;
import syntaxtree.AssignmentStatement;
import syntaxtree.Block;
import syntaxtree.BooleanType;
import syntaxtree.BracketExpression;
import syntaxtree.ClassDeclaration;
import syntaxtree.ClassExtendsDeclaration;
import syntaxtree.CompareExpression;
import syntaxtree.Expression;
import syntaxtree.ExpressionList;
import syntaxtree.ExpressionRest;
import syntaxtree.FalseLiteral;
import syntaxtree.FormalParameter;
import syntaxtree.FormalParameterList;
import syntaxtree.FormalParameterRest;
import syntaxtree.Goal;
import syntaxtree.Identifier;
import syntaxtree.IfStatement;
import syntaxtree.IntegerLiteral;
import syntaxtree.IntegerType;
import syntaxtree.MainClass;
import syntaxtree.MessageSend;
import syntaxtree.MethodDeclaration;
import syntaxtree.MinusExpression;
import syntaxtree.Node;
import syntaxtree.NodeList;
import syntaxtree.NodeListOptional;
import syntaxtree.NodeOptional;
import syntaxtree.NodeSequence;
import syntaxtree.NodeToken;
import syntaxtree.NotExpression;
import syntaxtree.PlusExpression;
import syntaxtree.PrimaryExpression;
import syntaxtree.PrintStatement;
import syntaxtree.Statement;
import syntaxtree.ThisExpression;
import syntaxtree.TimesExpression;
import syntaxtree.TrueLiteral;
import syntaxtree.Type;
import syntaxtree.TypeDeclaration;
import syntaxtree.VarDeclaration;
import syntaxtree.WhileStatement;
import visitor.GJDepthFirst;


public class TranslateToVaporVisitor extends GJDepthFirst<Object, Object> 
{
	Map<String, MJClass> classes;
	//
	// Auto class visitors--probably don't need to be overridden.
	//
	public Object visit(NodeList n, Object argu) 
	{
		Object _ret=null;
		int _count=0;
		for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) 
		{
			e.nextElement().accept(this,argu);
			_count++;
		}
		return _ret;
	}

	   public Object visit(NodeListOptional n, Object argu) {
	      if ( n.present() ) {
	         Object _ret=null;
	         int _count=0;
	         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	            e.nextElement().accept(this,argu);
	            _count++;
	         }
	         return _ret;
	      }
	      else
	         return null;
	   }

	   public Object visit(NodeOptional n, Object argu) {
	      if ( n.present() )
	         return n.node.accept(this,argu);
	      else
	         return null;
	   }

	   public Object visit(NodeSequence n, Object argu) {
	      Object _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this,argu);
	         _count++;
	      }
	      return _ret;
	   }

	   public Object visit(NodeToken n, Object argu) { return null; }

	   //
	   // User-generated visitor methods below
	   //

	   /**
	    * f0 -> MainClass()
	    * f1 -> ( TypeDeclaration() )*
	    * f2 -> <EOF>
	    */
	   public Object visit(Goal n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "{"
	    * f3 -> "public"
	    * f4 -> "static"
	    * f5 -> "void"
	    * f6 -> "main"
	    * f7 -> "("
	    * f8 -> "String"
	    * f9 -> "["
	    * f10 -> "]"
	    * f11 -> Identifier()
	    * f12 -> ")"
	    * f13 -> "{"
	    * f14 -> ( VarDeclaration() )*
	    * f15 -> ( Statement() )*
	    * f16 -> "}"
	    * f17 -> "}"
	    */
	   public Object visit(MainClass n, Object argu) {
	      Object _ret=null;
	      System.out.println("func Main()");
	      n.f14.accept(this, argu);
	      n.f15.accept(this, argu);
	      System.out.print("  ret");
	      return _ret;
	   }

	   /**
	    * f0 -> ClassDeclaration()
	    *       | ClassExtendsDeclaration()
	    */
	   public Object visit(TypeDeclaration n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "{"
	    * f3 -> ( VarDeclaration() )*
	    * f4 -> ( MethodDeclaration() )*
	    * f5 -> "}"
	    */
	   public Object visit(ClassDeclaration n, Object argu) {
	      Object _ret=null;
	      n.f1.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "class"
	    * f1 -> Identifier()
	    * f2 -> "extends"
	    * f3 -> Identifier()
	    * f4 -> "{"
	    * f5 -> ( VarDeclaration() )*
	    * f6 -> ( MethodDeclaration() )*
	    * f7 -> "}"
	    */
	   public Object visit(ClassExtendsDeclaration n, Object argu) {
	      Object _ret=null;
	      n.f1.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Type()
	    * f1 -> Identifier()
	    * f2 -> ";"
	    */
	   public Object visit(VarDeclaration n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "public"
	    * f1 -> Type()
	    * f2 -> Identifier()
	    * f3 -> "("
	    * f4 -> ( FormalParameterList() )?
	    * f5 -> ")"
	    * f6 -> "{"
	    * f7 -> ( VarDeclaration() )*
	    * f8 -> ( Statement() )*
	    * f9 -> "return"
	    * f10 -> Expression()
	    * f11 -> ";"
	    * f12 -> "}"
	    */
	   public Object visit(MethodDeclaration n, Object argu) {
	      Object _ret=null;
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f7.accept(this, argu);
	      n.f8.accept(this, argu);
	      n.f10.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> FormalParameter()
	    * f1 -> ( FormalParameterRest() )*
	    */
	   public Object visit(FormalParameterList n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Type()
	    * f1 -> Identifier()
	    */
	   public Object visit(FormalParameter n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> ","
	    * f1 -> FormalParameter()
	    */
	   public Object visit(FormalParameterRest n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> ArrayType()
	    *       | BooleanType()
	    *       | IntegerType()
	    *       | Identifier()
	    */
	   public Object visit(Type n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    * f1 -> "["
	    * f2 -> "]"
	    */
	   public Object visit(ArrayType n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "boolean"
	    */
	   public Object visit(BooleanType n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "int"
	    */
	   public Object visit(IntegerType n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Block()
	    *       | AssignmentStatement()
	    *       | ArrayAssignmentStatement()
	    *       | IfStatement()
	    *       | WhileStatement()
	    *       | PrintStatement()
	    */
	   public Object visit(Statement n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "{"
	    * f1 -> ( Statement() )*
	    * f2 -> "}"
	    */
	   public Object visit(Block n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Identifier()
	    * f1 -> "="
	    * f2 -> Expression()
	    * f3 -> ";"
	    */
	   public Object visit(AssignmentStatement n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Identifier()
	    * f1 -> "["
	    * f2 -> Expression()
	    * f3 -> "]"
	    * f4 -> "="
	    * f5 -> Expression()
	    * f6 -> ";"
	    */
	   public Object visit(ArrayAssignmentStatement n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      n.f4.accept(this, argu);
	      n.f5.accept(this, argu);
	      n.f6.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "if"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> Statement()
	    * f5 -> "else"
	    * f6 -> Statement()
	    */
	   public Object visit(IfStatement n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e1 = (ExpressionOutput) n.f2.accept(this, input);
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      StatementOutput s1 = (StatementOutput) n.f4.accept(this, argu);
	      
	      input.nextVariableIndex = s1.nextVariableIndex;
	      StatementOutput s2 = (StatementOutput) n.f6.accept(this, input);
	      
	      String ifNum = Integer.toString(s2.nextVariableIndex);
	      String condCheck = "if0 " + e1.expressionVariable +" goto :if" + ifNum + "_else\n";
	      String gotoEnd = "goto :if" + ifNum + "_end\n";
	      String elseLabel = "if" + ifNum + "_else:\n";
	      String endLabel = "if" + ifNum + "end:\n";
	      String code = e1.code + condCheck + s1.code + gotoEnd + elseLabel + s2.code + endLabel;
	      
	      StatementOutput _ret = new StatementOutput(code, s2.nextVariableIndex+1);
	      return _ret;
	   }

	   /**
	    * f0 -> "while"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> Statement()
	    */
	   public Object visit(WhileStatement n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e1 = (ExpressionOutput) n.f2.accept(this, input);
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      StatementOutput s1 = (StatementOutput) n.f4.accept(this, input);
	      
	      String whileNum = Integer.toString(s1.nextVariableIndex);
	      String whileTop = "while" + whileNum  + "_top:\n";
	      String condCheck = "if0 " + e1.expressionVariable + " goto :while" + whileNum + "_end\n";
	      String loopToTop = "goto :while" + whileNum + "_top\n";
	      String whileEnd = "while" + whileNum + "_end:\n";
	      String code = whileTop + e1.code + condCheck + s1.code + loopToTop + whileEnd;
	      
	      StatementOutput _ret = new StatementOutput(code, s1.nextVariableIndex+1);
	      return _ret;
	   }

	   /**
	    * f0 -> "System.out.println"
	    * f1 -> "("
	    * f2 -> Expression()
	    * f3 -> ")"
	    * f4 -> ";"
	    */
	   public Object visit(PrintStatement n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e = (ExpressionOutput) n.f2.accept(this, input);
	      String printVariable = "t" + Integer.toString(e.nextVariableIndex);
	      String line = "PrintIntS(" + printVariable + ")\n";
	      String code = e.code + line;
	      StatementOutput _ret = new StatementOutput(code, e.nextVariableIndex+1);
	      return _ret;
	   }

	   /**
	    * f0 -> AndExpression()
	    *       | CompareExpression()
	    *       | PlusExpression()
	    *       | MinusExpression()
	    *       | TimesExpression()
	    *       | ArrayLookup()
	    *       | ArrayLength()
	    *       | MessageSend()
	    *       | PrimaryExpression()
	    */
	   public Object visit(Expression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput _ret = (ExpressionOutput) n.f0.accept(this, input);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "&&"
	    * f2 -> PrimaryExpression()
	    */
	   // nonzero is true, 0 is false. Multiply is same as &&
	   public Object visit(AndExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
		      
		      input.nextVariableIndex = e1.nextVariableIndex;
		      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
		      
		      String expressionVariable = "t" + e2.nextVariableIndex;
		      String line1 = expressionVariable + " = Mul(" + e1.expressionVariable + " " + e2.expressionVariable + ")\n";
		      String code = e1.code + e2.code + line1;
		      
		      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+1);
		      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "<"
	    * f2 -> PrimaryExpression()
	    */
	   public Object visit(CompareExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
		      
		      input.nextVariableIndex = e1.nextVariableIndex;
		      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
		      
		      String expressionVariable = "t" + e2.nextVariableIndex;
		      String line1 = expressionVariable + " = LtS(" + e1.expressionVariable + " " + e2.expressionVariable + ")\n";
		      String code = e1.code + e2.code + line1;
		      
		      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+1);
		      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "+"
	    * f2 -> PrimaryExpression()
	    */
	   public Object visit(PlusExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
		      
		      input.nextVariableIndex = e1.nextVariableIndex;
		      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
		      
		      String expressionVariable = "t" + e2.nextVariableIndex;
		      String line1 = expressionVariable + " = Add(" + e1.expressionVariable + " " + e2.expressionVariable + ")\n";
		      String code = e1.code + e2.code + line1;
		      
		      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+1);
		      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "-"
	    * f2 -> PrimaryExpression()
	    */
	   public Object visit(MinusExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
		      
		      input.nextVariableIndex = e1.nextVariableIndex;
		      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
		      
		      String expressionVariable = "t" + e2.nextVariableIndex;
		      String line1 = expressionVariable + " = Sub(" + e1.expressionVariable + " " + e2.expressionVariable + ")\n";
		      String code = e1.code + e2.code + line1;
		      
		      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+1);
		      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "*"
	    * f2 -> PrimaryExpression()
	    */
	   public Object visit(TimesExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
	      
	      String expressionVariable = "t" + e2.nextVariableIndex;
	      String line1 = expressionVariable + " = Mul(" + e1.expressionVariable + " " + e2.expressionVariable + ")\n";
	      String code = e1.code + e2.code + line1;
	      
	      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+1);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "["
	    * f2 -> PrimaryExpression()
	    * f3 -> "]"
	    */
	   public Object visit(ArrayLookup n, Object argu) {
		  // TODO: add an if-stmt to check for valid array access?
		  ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      ExpressionOutput e2 = (ExpressionOutput) n.f2.accept(this, input);
	      
	      String arrayAddrVariable = e1.expressionVariable;
	      String indexVariable = e2.expressionVariable;
	      String offsetVariable = "t" + Integer.toString(e2.nextVariableIndex);
	      String actualAddrVariable = "t" + Integer.toString(e2.nextVariableIndex+1);
	      
	      // calculate the address
	      String line1 = offsetVariable + " = Mul(" + indexVariable + " 4)\n"; 
	      String line2 = actualAddrVariable + " = Add(" + arrayAddrVariable + " " + offsetVariable + ")\n";
	      String expressionVariable = "[" + actualAddrVariable + "]";
	      
	      String code = e1.code + e2.code + line1 + line2;
	      
	      ExpressionOutput _ret = new ExpressionOutput(expressionVariable, code, e2.nextVariableIndex+2);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> "length"
	    */
	   //TODO: maybe allocate extra 4 bytes per array, return array addr as first byte, store length at addr-4
	   public Object visit(ArrayLength n, Object argu) {
	      Object _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> Identifier()
	    * f3 -> "("
	    * f4 -> ( ExpressionList() )?
	    * f5 -> ")"
	    */
	   //TODO: not finished with this method
	   public Object visit(MessageSend n, Object argu) {
	      ExpressionInput input = (ExpressionInput) argu;
	      String methodName = n.f2.f0.tokenImage;
	      
	      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
	      String objectVariable = e1.expressionVariable;
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      List<ExpressionOutput> el = (List<ExpressionOutput>) n.f4.accept(this, input);
	      
	      int nextVarIndex = e1.nextVariableIndex;
	      StringBuilder codeBuilder = new StringBuilder(e1.code);
	      codeBuilder.append("\n");
	      
	      // Add code for parameters
	      for (ExpressionOutput e_i : el)
	      {
	    	  codeBuilder.append(e_i.code);
	    	  codeBuilder.append("\n");
	    	  nextVarIndex = e_i.nextVariableIndex;
	      }
	      
	      // Assign method table addr to a variable
	      String methodTableAddr = "t" + Integer.toString(nextVarIndex);
	      String line1 = methodTableAddr + " = [" + e1.expressionVariable + "]\n";
	      
	      // Assign method addr to a variable
	      String methodAddr = methodTableAddr;
	      int methodIndex = input.variableTypes.get(key)
	      String line2 = methodAddr + " = [" + methodTableAddr + "+" + Integer.toString(i)
	      
	      // Add call line
	      codeBuilder.append(returnVar);
	      codeBuilder.append(" = ")
	      // Build parameter list for call
	      StringBuilder paramBuilder = new StringBuilder(objectVariable);
	      for (ExpressionOutput paramExpr : el)
	      {
	    	  paramBuilder.append(" ");
	    	  paramBuilder.append(paramExpr.expressionVariable);
	    	  returnVar = 
	      }
	      String parameters = paramBuilder.toString();
	      
	      String returnVar = "t" + 
	      String callLine = returnVar = call
	      return _ret;
	   }

	   /**
	    * f0 -> Expression()
	    * f1 -> ( ExpressionRest() )*
	    */
	   public Object visit(ExpressionList n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e1 = (ExpressionOutput) n.f0.accept(this, input);
	      
	      input.nextVariableIndex = e1.nextVariableIndex;
	      ExpressionOutput _ret = (ExpressionOutput) n.f1.accept(this, input);
	      return _ret;
	   }

	   /**
	    * f0 -> ","
	    * f1 -> Expression()
	    */
	   public Object visit(ExpressionRest n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput _ret = (ExpressionOutput) n.f1.accept(this, input);
	      return _ret;
	   }

	   /**
	    * f0 -> IntegerLiteral()
	    *       | TrueLiteral()
	    *       | FalseLiteral()
	    *       | Identifier()
	    *       | ThisExpression()
	    *       | ArrayAllocationExpression()
	    *       | AllocationExpression()
	    *       | NotExpression()
	    *       | BracketExpression()
	    */
	   public Object visit(PrimaryExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput _ret = (ExpressionOutput) n.f0.accept(this, input);
	      return _ret;
	   }

	   /**
	    * f0 -> <INTEGER_LITERAL>
	    */
	   public Object visit(IntegerLiteral n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		  ExpressionOutput _ret= new ExpressionOutput(n.f0.tokenImage, "", input.nextVariableIndex);
	      return _ret;
	   }

	   /**
	    * f0 -> "true"
	    */
	   public Object visit(TrueLiteral n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		  ExpressionOutput _ret= new ExpressionOutput("1", "", input.nextVariableIndex);
	      return _ret;
	   }

	   /**
	    * f0 -> "false"
	    */
	   public Object visit(FalseLiteral n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		  ExpressionOutput _ret= new ExpressionOutput("0", "", input.nextVariableIndex);
	      return _ret;
	   }

	   /**
	    * f0 -> <IDENTIFIER>
	    */
	   public Object visit(Identifier n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		  ExpressionOutput _ret= new ExpressionOutput(n.f0.tokenImage, "", input.nextVariableIndex);
	      return _ret;
	   }

	   /**
	    * f0 -> "this"
	    */
	   public Object visit(ThisExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
		   // TODO: maybe have code be null if no lines are needed
	      ExpressionOutput _ret = new ExpressionOutput("this", "", input.nextVariableIndex);
	      return _ret;
	   }

	   /**
	    * f0 -> "new"
	    * f1 -> "int"
	    * f2 -> "["
	    * f3 -> Expression()
	    * f4 -> "]"
	    */
	   // TODO: save length to mem
	   public Object visit(ArrayAllocationExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e = (ExpressionOutput) n.f3.accept(this, input);
	      String allocSizeVariable = e.expressionVariable;
	      String arrayAddrVariable = "t" + Integer.toString(e.nextVariableIndex);
	      String line1 = arrayAddrVariable + " = HeapAllocZ(" + allocSizeVariable + ")\n";
	      String newCode = e.code + line1;
	      
	      ExpressionOutput _ret = new ExpressionOutput(arrayAddrVariable, newCode, e.nextVariableIndex + 1);
	      return _ret;
	   }

	   /**
	    * f0 -> "new"
	    * f1 -> Identifier()
	    * f2 -> "("
	    * f3 -> ")"
	    */
	   public Object visit(AllocationExpression n, Object argu) {
		  ExpressionInput input = (ExpressionInput) argu;
	      String objectAddrVariable = "t" + Integer.toString(input.nextVariableIndex);
	      String className = n.f1.f0.tokenImage;
	      MJClass mjclass = classes.get(className);
	      int size = 4 * mjclass.getFields().size() + 4;
	      String line1 = objectAddrVariable + " = HeapAllocZ(" + size + ")\n";
	      String line2 = "[" + objectAddrVariable + "] = :vmt_" + className + "\n";
	      String code = line1 + line2;
	      
	      ExpressionOutput _ret = new ExpressionOutput(objectAddrVariable, code, input.nextVariableIndex + 1);
	      return _ret;
	   }

	   /**
	    * f0 -> "!"
	    * f1 -> Expression()
	    */
	   public Object visit(NotExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e = (ExpressionOutput) n.f1.accept(this, input);
	      String newVariable = "t" + Integer.toString(e.nextVariableIndex);
	      String line1 = newVariable + " = Eq(" + e.expressionVariable + " 0)\n";
	      String newCode = e.code + line1;
	      
	      ExpressionOutput _ret = new ExpressionOutput(newVariable, newCode, e.nextVariableIndex+1);
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> Expression()
	    * f2 -> ")"
	    */
	   public Object visit(BracketExpression n, Object argu) {
		   ExpressionInput input = (ExpressionInput) argu;
	      ExpressionOutput e = (ExpressionOutput) n.f1.accept(this, input);
	      String newVariable = "t" + Integer.toString(e.nextVariableIndex);
	      String line1 = newVariable + " = " + e.expressionVariable + "\n";
	      String newCode = e.code + line1;
	      
	      ExpressionOutput _ret = new ExpressionOutput(newVariable, newCode, e.nextVariableIndex+1);
	      return _ret;
	   }
}
