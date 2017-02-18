package textHandler;

import java.io.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * Works with console.
 */
public class ConsoleReader {
  private static final String NOTHING_SYMB = "";
  private static final String ENTER_TEXT_ASK = "Enter text: ";
  private static final String ENTER_MORE_TEXT_QUESTION = "Do you want enter more text? (yes/no)";
  private static final String NO_ANSWER = "no";
  private static final String YES_ANSWER = "yes";

  /**
   * Read text from console.
   *
   * @return text from console.
   * @throws IOException for BufferedReader.
   */
  public String read() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String regex = "[\\d~`@#$%^&()_|№*-+]+"; // Ignored symbols

    System.out.println(ENTER_TEXT_ASK);

    return reader.readLine().replaceAll(regex,NOTHING_SYMB);
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
    boolean correctAnswer;

    do {
      System.out.println(ENTER_MORE_TEXT_QUESTION);
      String answer = reader.readLine();

      if (answer.toLowerCase().equals(YES_ANSWER)) {
        repeat = true;
        correctAnswer = true;
      } else if (answer.toLowerCase().equals(NO_ANSWER)) {
        repeat = false;
        correctAnswer = true;
      } else {
        correctAnswer = false;
      }
    } while (!correctAnswer);
    return repeat;
  }
}