package task_Dev_2.calculator;

import java.util.*;

/**
 * Class for checking and processing strings.
 */
class StringProcess {
  private static final String DIVISION = "/";
  private static final String MULTIPLICATION = "*";
  private static final String SUBTRACTION = "-";
  private static final String ADDITION = "+";
  private static final String EXP = "e";
  private static final String BOUNDS_ERROR_MSG = "Look for bounds of your expression!";
  private static final String USING_EXP_ERROR_MSG = "There is an operator after \'e\'";
  private static final String FOLLOWING_OPERATORS_MSG = "Two operators follow each other";
  private static final String NOT_ENOUGH_INFORM_MSG = "There is not enough information!";
  private static final int MIN_SIZE = 3;
  
  /**
   * Converts string expression to list of operators and operands.
   *
   * @param expr - input expression, which need to be processed.
   * @return ready for calculations list.
   */
  public List fromStrToList(String expr) {
	List<String> expressionArray = new ArrayList<String>();
	
	try {
	  checkBounds(expr, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION);
	  makeList(expressionArray, expr, ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION);
	  
	  if (expressionArray.size() < MIN_SIZE) {
	    throw new ArrayIndexOutOfBoundsException();
	  }
	} catch (ArrayIndexOutOfBoundsException ex) {
	  System.out.println(NOT_ENOUGH_INFORM_MSG);
	  System.exit(0);
	}
	
	System.out.println(expressionArray);
	return expressionArray;
  }
  
  /**
   * Divide string into elementary strings - operands or operators.
   *
   * @param addition - operator "+" need to find in expression.
   * @param multiplication - operator "*" need to find in expression.
   * @param subtraction - operator "-" need to find in expression.
   * @param division - operator "/" need to find in expression.
   * @param exprArr - list of new elementary strings.
   * @param expr - source string.
   */
  public void makeList(List<String> exprArr, String expr, String addition, String multiplication, 
      String subtraction, String division) {
    expr = expr.toLowerCase();
	String current;
	String next;
	int mark = 0;
	
	for (int i = 0; i < expr.length(); i++) {
	  current = expr.substring(i, i + 1);
	  
	  if (current.equals(multiplication) || current.equals(division) || current.equals(addition) ||
	      current.equals(subtraction)) {
        next = expr.substring(i + 1, i + 2);
		
		// Skip first in the string operators "+" and "-" and add them to first number.
		if (i == 0 && (current.equals(addition) || current.equals(subtraction))) {
		  continue;
		}
		
	    // Process case, when two operators follow each other.
		if (next.equals(addition) || next.equals(subtraction)) {
			exprArr.add(expr.substring(mark, i));
	        exprArr.add(expr.substring(i, i + 1));
	        mark = i + 1;
			i++;
			continue;
		} else if (next.equals(multiplication) || next.equals(division)) {
		  System.out.println(FOLLOWING_OPERATORS_MSG);
		  System.exit(0);
		}
		
	    exprArr.add(expr.substring(mark, i));
	    exprArr.add(expr.substring(i, i + 1));
	    mark = i + 1;
	  }
	  
	  if (i == expr.length() - 1) {
	    exprArr.add(expr.substring(mark, i + 1));
	  }
	  
	  if (current.equals(EXP)) {
		next = expr.substring(i + 1, i + 2);
		if (next.equals(addition) || next.equals(subtraction)) {
		  i++;
		  continue;
		} 
		else if (next.equals(multiplication) || next.equals(division)) {
		  System.out.println(USING_EXP_ERROR_MSG);
		  System.exit(0);
		}
	  }
	}
  }
  
  /**
   * Find illegal operators on bounds of string. If it find them, it exit.
   *
   * @param addition - operator "+" which need to find.
   * @param subtraction - operator "-" which need to find.
   * @param multiplication - operator "*" which need to find.
   * @param division - operator "/" which need to find.
   * @param str - list of new elementary strings.
   */
  public void checkBounds(String str, String addition, String subtraction, String multiplication, 
      String division) {
	boolean isCorrect = true;
	char[] expr = str.toCharArray();
	char[] oper = (addition + subtraction + multiplication + division).toCharArray();
	
	for (int i = 0; i < oper.length; i++) {
	  if (expr[expr.length - 1] == oper[i]) {
		isCorrect = false;
	  }
	  if (i > 1 && expr[0] == oper[i]) {
		isCorrect = false;
	  }
	}
	if (!isCorrect) {
	  System.out.println(BOUNDS_ERROR_MSG);
	  System.exit(0);
	}
  }  
}