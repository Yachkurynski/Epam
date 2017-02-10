package yachk.printoptions;

import java.util.*;

/**
 * Class, which find tools in array of entry data from CL.
 */
public class Searcher {
	public static final char OPT_SYMB = '-'; // Symbol in the bigining of tool.
	
	/**
	 * Find tools in entry data and send them to Ptrinter class.
	 *
	 * Parameter is array from CL.
	 */
    public static void searchTools(String[] comString) {
	List<String> optionArray = new ArrayList<String>();
	
	for (String str : comString) {
	  char[] word = str.toCharArray();
	  boolean condition = Checker.checkToolName(word);
	  
	  if (word[0] == OPT_SYMB) {
		if (condition) { // Check the correctness of data in the class Checker.
		  optionArray.add(str);
		} else {
		  continue;
		}
	  }
	}
	Printer.printArray(optionArray);
  }
}