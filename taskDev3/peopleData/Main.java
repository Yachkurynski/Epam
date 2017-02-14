package taskDev3.peopleData;

import java.io.*;
import java.util.*;

/**
 * Entry point to the program.
 */
class Main {
  private static final String NEED_TO_ADD_ASK = "Do you want add person? (y|n)";
  private static final String YES_ANSWER = "y";
  private static final String NO_ANSWER = "n";
  private static final String ENTER_YES_OR_NO = "Please, enter only 'y' or 'n'.";
  
  /**
   * Makes interviews cycle from console. Params from CL don't used.
   */
  public static void main(String[] args) throws IOException {
    List<People> people = new ArrayList<People>();
    boolean needRepeat = interview( people);

    do {
      needRepeat = interview( people);
    } while (needRepeat);

    Printer printer = new Printer();
    printer.printResults(people);
  }
  
  /**
   * Ask about need to describe new person and does it, if it's necessary.
   * 
   * @param people - list of people for filling.
   * @return true if it needs to add one more person.
   */ 
  private static boolean interview( List<People> people) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean needRepeat = true;  
    
	System.out.println(NEED_TO_ADD_ASK);
	String ans = reader.readLine();

    if (ans.toLowerCase().equals(YES_ANSWER)) { 
      Builder build = new Builder();
      ConsoleReader readInform = new ConsoleReader();

      people.add(build.buildPerson(readInform.readFromConsole()));
    } else if (ans.toLowerCase().equals(NO_ANSWER)) {
      if (people.size() != 0) {
        needRepeat = false;
      }
    } else {
      System.out.println(ENTER_YES_OR_NO);
    }
    return needRepeat;
  }
}