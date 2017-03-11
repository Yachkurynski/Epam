package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for fractions of a second matched key-word "f".
 */
public class FSplitSecond extends DateFormat {
  private static int HUNDRED = 100;
  private static String format = "f";

  /**
   * Returns not zero fractions of a second. (631 ms => 6)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf((calendar.get(Calendar.MILLISECOND) / HUNDRED));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
