package fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read data from console.
 */
public class ConsoleReader {

  private static final String ENTER_ASK = "Enter %s: ";
  private static final String INCORRECT_INPUT_MSG = "Incorrect input! No more attempts to enter ";
  private static final int NUMBER_OF_REPEATS = 10;

  /**
   * Read value from console. Requested value depends on given message.
   *
   * @param valueMsg string with name of requested value.
   * @return needed value.
   * @throws NullPointerException when number of attempts to enter the value is ended.
   */
  public String readFromConsole(String valueMsg) throws NullPointerException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String value = "";
    int iteration = 0;

    do {
      try {
        System.out.printf(ENTER_ASK, valueMsg);
        value = reader.readLine();
        iteration++;

        if (iteration == NUMBER_OF_REPEATS) {
          throw new NullPointerException(INCORRECT_INPUT_MSG + valueMsg);
        }
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (value.length() == 0 && iteration < NUMBER_OF_REPEATS);
    return value;
  }
}
