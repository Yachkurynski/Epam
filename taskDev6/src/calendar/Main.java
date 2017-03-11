package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Prints current time according to entered format.
 */
public class Main {

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();
    DateBuilder date = new DateBuilder();
    Calendar calendar = new GregorianCalendar();

    String[] formats = reader.readFromConsole();

    for (String format : formats) {
      String currDate = date.getCurrentTime().getFormatedDate(format, calendar);
      System.out.print(currDate + " ");
    }

  }
}
