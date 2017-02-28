package dateFormatChecker;

import dateFormatChecker.dateChecker.YearChecker;
import java.io.IOException;

/**
 * Checks that entered date satisfies fixed format - dd/MM/yyyy HH:mm
 */
public class Main {

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();
    Validator validator = new Validator();

    try {
      System.out.print("Enter date according to format \"dd/MM/yyyy HH:mm\" -> ");
      String date = reader.readFromConsole();

      if (validator.isValid(date)) {
        System.out.println("Correct.");
      } else {
        System.out.println("Format is incorrect!");
      }
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}
