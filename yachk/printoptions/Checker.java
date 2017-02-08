package yachk.printoptions;

/**
 * Class for checking correctness of tool's name.
 * It must contains only lower case letters.
 */
public class Checker {
  public static final char FIRST_SYMB = 'a';
  public static final char LAST_SYMB = 'z';
  /**
   * Parameter is the name of checking tool. 
   * Returns TRUE, if name is correct (name is a symbol between 'a' and 'z')
   */
  public static boolean checkToolName(char[] toolName) {
	boolean valid = true;
	
	for (int i = 1; i < toolName.length; i++) {
	  if ((toolName[i] >= FIRST_SYMB) && (toolName[i] <= LAST_SYMB)) {
		continue;
	  } else {
		valid = false;
		break;
	  }
	}
	return valid;
  }
}