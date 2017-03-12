package calendar;

import java.io.*;

/**
 * Reads data from console.
 */
public class ConsoleReader {
  private static final String INCORRECT_INPUT_MSG = "Incorrect input! Check your input: ";
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

      if (dateFormat.length() == 0 || !isValid(dateFormat)) {
        throw new IllegalArgumentException(INCORRECT_INPUT_MSG + dateFormat);
      }
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return dateFormat;
  }

  /**
   * Checks that given format doesn't contain illegal symbols.
   * @param format format for checking.
   * @return true if it doesn't contain illegal symbols.
   */
  private boolean isValid(String format) {
    String illegalSymbol = format.replaceAll("[/: ]", "").replaceAll("[a-zA-Z]+", "");
    if (illegalSymbol.length() > 0) {
      return false;
    }
    return true;
  }
}
