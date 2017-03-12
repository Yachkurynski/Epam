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
    DateGetter date = new DateGetter();
    Calendar calendar = new GregorianCalendar();
    DateBuilder builder = new DateBuilder();
    try {
      String formats = reader.readFromConsole();
      String currDate = builder.buildCurrentDate(formats, date.getCurrentTime(), calendar);
      System.out.print(currDate);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}
