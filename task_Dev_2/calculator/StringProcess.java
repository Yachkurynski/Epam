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
      checkBounds(expr);
      makeList(expressionArray, expr);
      
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
   * @param exprArr - list of new elementary strings.
   * @param expr - source string.
   */
  public void makeList(List<String> exprArr, String expr) {
    expr = expr.toLowerCase();
    String current;
    String next;
    int mark = 0;
    
	// TODO: Decompose it better!
    for (int i = 0; i < expr.length(); i++) {
      current = expr.substring(i, i + 1);
	  
      if (current.equals(MULTIPLICATION) || current.equals(DIVISION) || current.equals(ADDITION) ||
          current.equals(SUBTRACTION)) {
        next = expr.substring(i + 1, i + 2);

        // Skip first in the string operators "+" and "-" and add them to first number.
        if (i == 0 && (current.equals(ADDITION) || current.equals(SUBTRACTION))) {
          continue;
        }

        // Process case, when two operators follow each other.
        if (next.equals(ADDITION) || next.equals(SUBTRACTION)) {
            addToList(exprArr, expr, i, mark);
			mark = i + 1;
            i++;
            continue;
        } else if (next.equals(MULTIPLICATION) || next.equals(DIVISION)) {
          System.out.println(FOLLOWING_OPERATORS_MSG);
          System.exit(0);
        }
        addToList(exprArr, expr, i, mark);
		mark = i + 1;
      }
      if (i == expr.length() - 1) {
        exprArr.add(expr.substring(mark, i + 1));
      }
      if (current.equals(EXP)) {
        next = expr.substring(i + 1, i + 2);
        if (next.equals(ADDITION) || next.equals(SUBTRACTION)) {
          i++;
          continue;
        } else if (next.equals(MULTIPLICATION) || next.equals(DIVISION)) {
          System.out.println(USING_EXP_ERROR_MSG);
          System.exit(0);
        }
      }
    }
  }

  /**
   * Adds to list current number and operator after it.
   *
   * @param exprArr - list.
   * @param expr - string expression.
   * @param iter - current symbol's number.
   * @param mark - number's beginning.
   */  
  public void addToList(List<String> exprArr, String expr, int iter, int mark) {
    exprArr.add(expr.substring(mark, iter));
    exprArr.add(expr.substring(iter, iter + 1));
  }
  
  /**
   * Find illegal operators on bounds of string. If it find them, it exit.
   *
   * @param str - list of new elementary strings.
   */
  public void checkBounds(String str) {
    boolean isCorrect = true;
    char[] expr = str.toCharArray();
    char[] oper = (ADDITION + SUBTRACTION + MULTIPLICATION + DIVISION).toCharArray();

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