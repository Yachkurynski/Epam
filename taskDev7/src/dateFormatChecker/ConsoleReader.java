package dateFormatChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Communicates with console.
 */
public class ConsoleReader {

  /**
   * Reads data from console.
   *
   * @return read string.
   */
  public String readFromConsole() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String inputData = reader.readLine();
    return inputData;
  }
}
