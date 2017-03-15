package checkers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads data from console.
 */
public class ConsoleReader {
  private static final String INCORRECT_INPUT_MSG = "There is empty input!";
  private static final String NUMBER_OF_REPEATS_END_MSG = "Number of repeats is ended.";
  private static final int MAX_NUMBER_OF_REPEATS = 5;

  /**
   * Reads data from console which depends on given message.
   *
   * @param message hint with name of needed value.
   * @return string representation of needed value.
   */
  public String readFromConsole(String message) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String stringToReturn = "";
    int numberOfRepeats = 0;
    boolean needToRepeat = false;

    do {
      try {
        System.out.println(message);
        stringToReturn = reader.readLine().trim();
        needToRepeat = false;

        if (stringToReturn.length() == 0) {
          System.out.println(INCORRECT_INPUT_MSG);
          needToRepeat = true;
        }
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (needToRepeat && isNeedToRepeatEnter(numberOfRepeats++));
    return stringToReturn;
  }

  /**
   * Checks that number of repeats less than some fixed value.
   * @param numberOfRepeats given number of repeats.
   * @return true if number of repeats less than fixed value.
   */
  public boolean isNeedToRepeatEnter(int numberOfRepeats) {
    if (numberOfRepeats == MAX_NUMBER_OF_REPEATS) {
      System.out.println(NUMBER_OF_REPEATS_END_MSG);
      return false;
    } else {
      return true;
    }
  }
}
