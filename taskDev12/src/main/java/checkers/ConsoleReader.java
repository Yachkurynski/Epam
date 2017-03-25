package checkers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads data from console.
 */
public class ConsoleReader {
  private static final String EMPTY_INPUT_MSG = "There is empty input!";
  private String enteredValue;

  /**
   * Reads data from console which depends on given message.
   *
   * @param message hint with name of needed value.
   * @return string representation of needed value.
   */
  public String readFromConsole(String message) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(message);
    setEnteredValue(reader.readLine().trim());

    if (getEnteredValue().length() == 0) {
      throw new IOException(EMPTY_INPUT_MSG);
    }
    return getEnteredValue();
  }

  public String getEnteredValue() {
    return enteredValue;
  }

  public void setEnteredValue(String enteredValue) {
    this.enteredValue = enteredValue;
  }
}
