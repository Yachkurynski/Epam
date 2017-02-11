package task_Dev_2.calculator;

import java.util.*;

/**
 * Entry point of program.
 */
class Main {
  
  /**
   * Read and process expression from CL or console.
   * @param args - arguments of CL. If there is no arguments from CL, than program wait expression from console.
   */
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
	calculator.calculateResult(proc.fromStrToList(str));
  }
}