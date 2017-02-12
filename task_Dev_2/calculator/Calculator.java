package task_Dev_2.calculator;

import java.util.*;

/**
 * Calculate expression stored in list.
 */
class Calculator {
  private static final String DIVISION = "/";
  private static final String MULTIPLICATION = "*";
  private static final String SUBTRACTION = "-";
  private static final String ADDITION = "+";
  private static final String FORMAT_EXCEPTION_MESSAGE = "Incorrect number format! ";
  
  /**
   * Calculate results by priority of operations.
   *
   * @param exprArr - list with operands and operators
   * @exception NumberFormatException Occurs when the operation of the incorrect number.
   */
  public void calculateResult(List<String> exprArr) {
	try {
	  reWriteList(MULTIPLICATION, DIVISION, exprArr);
	  reWriteList(ADDITION, SUBTRACTION, exprArr);
	  if (exprArr.size() == 1) {
        System.out.println(exprArr.get(0));
	  }
	} catch (NumberFormatException ex) {
	  System.out.println(FORMAT_EXCEPTION_MESSAGE + ex.getLocalizedMessage());
	}
  }
  
  /**
   * Rewrite list by replacing operator and two operands with result
   *
   * @param firstOper - one operator need for calculation.
   * @param secOper - other operator need for calculation.
   * @param exprArr - list with operands and operators.
   */
  public void reWriteList(String firstOper, String secOper, List<String> exprArr) {
	int position = 0;

	while (position < exprArr.size()) {
	  String currSymb = exprArr.get(position);
	  
	  if (currSymb.equals(firstOper) || currSymb.equals(secOper)) {
		String firstNum = exprArr.get(position - 1);
		String secondNum = exprArr.remove(position + 1);
		String operator = exprArr.remove(position);
		
		exprArr.set(position - 1, calcOneOperat(firstNum, secondNum, operator));
		position -= 1;
	  }
	  position++;
	}
  }
  
  /**
   * Calculate one operation. 
   *
   * @param fNum - first operand. 
   * @param sNum - second operand.
   * @param oper - operator.
   * @return result of calculation.
   */
  public String calcOneOperat(String fNum, String sNum, String oper) {
	double firstNum = Double.parseDouble(fNum);
	double secondNum = Double.parseDouble(sNum);
	double result = 0;
	
	switch (oper) {
      case ADDITION:
	    result = firstNum + secondNum;
		break;
	  case SUBTRACTION:
	    result = firstNum - secondNum;
		break;
	  case DIVISION:
	    result = firstNum / secondNum;
		break;
	  case MULTIPLICATION:
	    result = firstNum * secondNum;
		break;
	  default:
	}
	return String.valueOf(result);
  }
}