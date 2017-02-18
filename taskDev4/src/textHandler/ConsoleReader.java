package textHandler;

import java.io.*;
import java.util.*;

/**
 * Works with console.
 */
public class ConsoleReader {

  private static final String ENTER_TEXT_ASK = "Enter text: ";

  /**
   * Read text from console.
   *
   * @return text from console.
   * @throws IOException for BufferedReader.
   */
  public String read() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(ENTER_TEXT_ASK);
    return reader.readLine();
  }

  /**
   * Check conditions for cycle.
   *
   * @return true, if it needs to repeat.
   * @throws IOException for BufferedReader input.
   */
  public boolean needRepeat() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(ENTER_TEXT_ASK);

    boolean repeat = true;

    boolean correctAnswer = true;
    do {
      System.out.println("Do you want enter one more text? (yes/no)");
      String answer = reader.readLine();

      if (answer.toLowerCase().equals("yes")) {
        repeat = true;
        correctAnswer = true;
      } else if (answer.toLowerCase().equals("no")) {
        repeat = false;
        correctAnswer = true;
      } else {
        correctAnswer = false;
      }
    } while (!correctAnswer);
    return repeat;
  }
}
