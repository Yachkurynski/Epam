package fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read data from console.
 */
public class ConsoleReader {
  private static final String ENTER_ASK = "Enter %s: ";

  /**
   * Read value from console. Requested value depends on given message.
   *
   * @param valueMsg string with name of requested value.
   * @return needed value.
   */
  public String readFromConsole(String valueMsg) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String value = "";

    do {
      try {
        System.out.printf(ENTER_ASK, valueMsg);
        value = reader.readLine();
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (value.length() == 0);
    return value;
  }
}
