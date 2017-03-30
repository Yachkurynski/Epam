package calendar;

import java.io.*;

/**
 * Reads data from console.
 */
public class ConsoleReader {
  private static final String INCORRECT_INPUT_MSG = "There is empty input!";
  private static final String ENTER_DATE_ASK = "Enter date format: ";

  /**
   * Reads format of date from console.
   *
   * @return array of format descriptors.
   * @throws IOException when array is empty.
   */
  public String readFromConsole() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String dateFormat = "";

    try {
      System.out.println(ENTER_DATE_ASK);
      dateFormat = reader.readLine();

      if (dateFormat.length() == 0) {
        throw new IllegalArgumentException(INCORRECT_INPUT_MSG);
      }
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return dateFormat;
  }
}
