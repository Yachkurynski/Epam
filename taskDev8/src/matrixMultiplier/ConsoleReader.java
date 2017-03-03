package matrixMultiplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads data from console.
 */
public class ConsoleReader {
  private static final String WRONG_VALUE_MSG = "Wrong value! Try again.";

  /**
   * Reads int value from console.
   * @return int value.
   */
  public int readInt() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean isCorrectEnter = true;
    int valueToReturn = 0;

    do {
      try {
        valueToReturn = Integer.parseInt(reader.readLine());
        isCorrectEnter = true;
      } catch (NumberFormatException ex) {
        System.out.println(WRONG_VALUE_MSG);
        isCorrectEnter = false;
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (!isCorrectEnter);
    return valueToReturn;
  }

  /**
   * Reads double value from console.
   * @return double value.
   */
  public double readDouble() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean isCorrectEnter = true;
    double valueToReturn = 0;

    do {
      try {
        valueToReturn = Double.parseDouble(reader.readLine());
        isCorrectEnter = true;
      } catch (NumberFormatException ex) {
        System.out.println(WRONG_VALUE_MSG);
        isCorrectEnter = false;
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (!isCorrectEnter);
    return valueToReturn;
  }
}
