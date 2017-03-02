package fileReader;

/**
 * Prints result of program execution.
 */
public class PrintResults {
  private static final String EMPTY_ARRAY_MSG = "There is no values.";

  /**
   * Prints given array.
   *
   * @param values array need to print.
   */
  public void printArray(String[] values) {
    if (values.length == 0) {
      System.out.println(EMPTY_ARRAY_MSG);
    } else {
      for (String value : values) {
        System.out.println(value.trim());
      }
    }
  }
}
