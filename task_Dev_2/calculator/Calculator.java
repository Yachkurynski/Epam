package task_Dev_2.calculator;

import java.util.*;

class Calculator {
  private static final String DEV = "/";
  private static final String PROD = "*";
  private static final String DIF = "-";
  private static final String SUM = "+";
  
  public String calculate_result(List<String> exprArr) {
	int i = 0;
    System.out.println(exprArr.size());
	
	while (i < exprArr.size()) {
	  if ((exprArr.get(i)).equals(PROD) || (exprArr.get(i)).equals(DEV)) {
		exprArr.set(i - 1, calc_operation(exprArr.get(i - 1), exprArr.remove(i + 1), exprArr.remove(i)));
		i -= 1;
	  }
	  i++;
	}
	int j = 0;
	while (j < exprArr.size()) {
		System.out.println((exprArr.get(j)).equals(SUM));
	  if ((exprArr.get(j)).equals(SUM) || (exprArr.get(j)).equals(DIF)) {
		exprArr.set(j - 1, calc_operation(exprArr.get(j - 1), exprArr.remove(j + 1), exprArr.remove(j)));
		j -= 1;
		//System.out.println(exprArr);
	  }
	  j++;
	}
	return exprArr.get(0);
  }
  
  public String calc_operation(String f_num, String s_num, String oper) {
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