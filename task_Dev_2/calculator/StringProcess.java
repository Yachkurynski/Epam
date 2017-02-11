package task_Dev_2.calculator;

import java.util.*;
import java.math.*;

/**
 * Class for checking and processing strings.
 */

class StringProcess {
  private static final String DEV = "/";
  private static final String PROD = "*";
  private static final String DIF = "-";
  private static final String SUM = "+";
  private static final int MIN_SIZE = 3;
  
  /**
   * @param expr - input expression, which need to be processed.
   * @return ready for calculations list.
   */
  public List fromStrToList(String expr) {
	List<String> expressionArray = new ArrayList<String>();
	
	if (expr.length() == 0) {
	  System.out.println("\n Be more attentive! There is not enough information!");
	  System.exit(0);
	}	
	
	checkBounds(expr, SUM, DIF, PROD, DEV);
	makeList(expressionArray, expr, SUM, PROD, DIF, DEV);
	
	if (expressionArray.size() < MIN_SIZE) {
	  System.out.println("\n Be more attentive! There is not enough information!");
	  System.exit(0);
	}
	System.out.println(expressionArray);
	return expressionArray;
  }
  
  /**
   * Make dividing of given string into elementary strings - operands or operators.
   * Params sum, prod, dif, dev - operators to find.
   * @param exprArr - list of new elementary strings.
   * @param expr - source string.
   */
  public void makeList(List<String> exprArr, String expr, String sum, String prod, String dif, 
      String dev) {
	String exp = "e";
    expr = expr.toLowerCase();
	String curr;
	String next;
	int mark = 0;
	
	for (int i = 0; i < expr.length(); i++) {
	  curr = expr.substring(i, i + 1);
	  
	  if (curr.equals(prod) || curr.equals(dev) || curr.equals(sum) || 
	      curr.equals(dif)) {
		/**
	     * Skip first "+" and "-" and add them to first number
	     */
		if (i == 0 && (curr.equals(sum) || curr.equals(dif))) {
		  continue;
		}
		
		next = expr.substring(i + 1, i + 2);
		/**
	     * Process case, when two operators follow each other
	     */
		if (next.equals(sum) || next.equals(dif)) {
			exprArr.add(expr.substring(mark, i));
	        exprArr.add(expr.substring(i, i + 1));
	        mark = i + 1;
			i++;
			continue;
		  } else if (next.equals(prod) || next.equals(dev)) {
			System.out.println("Sorry! Incorrect input.");
			System.exit(0);
		  }
		
	    exprArr.add(expr.substring(mark, i));
	    exprArr.add(expr.substring(i, i + 1));
	    mark = i + 1;
	  }
	  
	  if (i == expr.length() - 1) {
	    exprArr.add(expr.substring(mark, i + 1));
	  }
	  
	  if (curr.equals(exp)) {
		next = expr.substring(i + 1, i + 2);
		if (next.equals(sum) || next.equals(dif)) {
		  i++;
		  continue;
		} 
		else if (next.equals(prod) || next.equals(dev)) {
		  System.out.println("Sorry! Incorrect input.");
		  System.exit(0);
		}
	  }
	}
  }
  
  /**
   * Method find operators on bounds of string. If it find illegal operators on bounds, it exit.
   * Params SUM, DIF, PROD, DEV - operators to find.
   * @param str - list of new elementary strings.
   */
  public void checkBounds(String str, String SUM, String DIF, String PROD, String DEV) {
	boolean isCorrect = true;
	char[] expr = str.toCharArray();
	char[] oper = (SUM + DIF + PROD + DEV).toCharArray();
	
	for (int i = 0; i < oper.length; i++) {
	  if (expr[expr.length - 1] == oper[i]) {
		isCorrect = false;
	  }
	  if (i > 1 && expr[0] == oper[i]) {
		isCorrect = false;
	  }
	}
	if (!isCorrect) {
	  System.out.println("Look for bounds of your expression!");
	  System.exit(0);
	}
  }  
}