package task_Dev_2.calculator;

import java.util.*;

/**
 * Calculate expression stored in list.
 */
class Calculator {
  private static final String DEV = "/";
  private static final String PROD = "*";
  private static final String DIF = "-";
  private static final String SUM = "+";
  
  /**
   * Calculate results by priority of operations. Firstly they are divided and multiplication, 
   * then sum and substraction.
   * Returns nothing. 
   * @param exprArr - list of string elements
   */
  public void calculateResult(List<String> exprArr) {
	System.out.println("Size: " + exprArr.size());
	try {
	  reWriteList(PROD, DEV, exprArr);
	  reWriteList(SUM, DIF, exprArr);
	} catch (NumberFormatException ex) {
	  System.out.println("Sorry! Incorrect number format!");
	}
  }
  
  /**
   * Make intermidiate calculations of given operators and rewrite list. One of operators and two 
   * operands are replaced with result.
   * Params firstOper and secOper - operators for calculations.
   * Returns nothing.
   */
  public void reWriteList(String firstOper, String secOper, List<String> exprArr) {
	int i = 0;

	while (i < exprArr.size()) {
	  if ((exprArr.get(i)).equals(firstOper) || (exprArr.get(i)).equals(secOper)) {
		exprArr.set(i - 1, calcOneOperat(exprArr.get(i - 1), exprArr.remove(i + 1), exprArr.remove(i)));
		i -= 1;
	  }
	  i++;
	}
	
	if (exprArr.size() == 1) {
      System.out.println(exprArr.get(0));
	}
  }
  
  /**
   * Make one operation. 
   * Params f_num and s_num - are operands.
   * @param oper - operator.
   * @return result of calculation.
   */
  public String calcOneOperat(String f_num, String s_num, String oper) {
	double first_num = Double.parseDouble(f_num);
	double second_num = Double.parseDouble(s_num);
	double result = 0;
	
	switch (oper) {
      case SUM:
	    result = first_num + second_num;
		break;
	  case DIF:
	    result = first_num - second_num;
		break;
	  case DEV:
	    result = first_num / second_num;
		break;
	  case PROD:
	    result = first_num * second_num;
		break;
	}
	return String.valueOf(result);
  }
  
}