package yachk.printoptions;

import java.util.*;

/** 
 * Prints correct tools' names.
 *
 */
class Printer {
  public static final int ARR_SIZE = 3;
  
  /**
   * Parameter is array of tools for print.
   * Nothing returns.
   */
  public static void printArray(List<String> optionArray) {
	Random random = new Random();
	int iter = 0;
	
	while (iter < optionArray.size() || iter < ARR_SIZE) {
	  System.out.println(optionArray.remove(random.nextInt(optionArray.size())));
	  iter++;
	  
	  if (optionArray.size() == 0 && iter < ARR_SIZE) {
        System.out.println("WARNING! There are few tools.");
		break;
	  }
	}
  }
}