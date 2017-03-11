package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for seconds matched key-word "s".
 */
public class SSeconds extends DateFormat {
  private static String format = "s";

  /**
   * Returns seconds in format 0-59.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed seconds.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.SECOND));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
