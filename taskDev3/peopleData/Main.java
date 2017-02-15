package taskDev3.peopleData;

import java.io.*;
import java.util.*;

/**
 * Entry point to the program.
 */
class Main {
  
  /**
   * Makes interviews cycle from console. Params from CL don't used.
   */
  public static void main(String[] args) throws IOException {
    List<People> people = new ArrayList<People>();
    ConsoleReader readInform = new ConsoleReader();
    boolean needRepeat = readInform.interview( people);
    
    do {
      needRepeat = readInform.interview( people);
    } while (needRepeat);

    Printer printer = new Printer();
    printer.printResults(people);
  }
}