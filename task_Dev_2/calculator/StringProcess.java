package task_Dev_2.calculator;

import java.util.*;

class StringProcess {
  private static final String DEV = "/";
  private static final String PROD = "*";
  private static final String DIF = "-";
  private static final String SUM = "+";
  
  // TODO: Process negative exponential numbers
  public List process(String expr) {
	List<String> expressionArray = new ArrayList<String>();
	int mark = 0;
	
	for (int i = 0; i < expr.length(); i++) {
	  if (getBool(i, i + 1, expr, PROD) || getBool(i, i + 1, expr, DEV) || 
	      getBool(i, i + 1, expr, SUM) || getBool(i, i + 1, expr, DIF)) {
		expressionArray.add(expr.substring(mark, i));
		expressionArray.add(expr.substring(i, i + 1));
		mark = i + 1;
	  }
	  if (i == expr.length() - 1) {
		expressionArray.add(expr.substring(mark, i + 1));
	  }
    }
	System.out.println(expressionArray);
	return expressionArray;
  }
  
  public boolean getBool(int beg, int end, String str, String sym) {
	return (str.substring(beg, end)).equals(sym);
  }
}