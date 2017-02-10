package task_Dev_2.calculator;

import java.util.*;

class Main {
  public static void main(String[] args) {
	String str = "";
	
	if (args.length == 0) {
	  System.out.println("Please, enter expression:");
	  Scanner scaner = new Scanner(System.in);
	  str = scaner.nextLine();
	  
	} else {
	  for (int i = 0; i < args.length; i++) {
		str = str.concat(args[i]);
	  }
	}
	
	StringProcess proc = new StringProcess();
	Calculator calculator = new Calculator();
	String result = calculator.calculate_result(proc.process(str));
	System.out.println(result);
  }
}