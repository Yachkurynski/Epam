package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for day of month matched key-word "d".
 */
public class DDayOfMonth extends DateFormat {
  private static String format = "d";

  /**
   * Returns day of month in format 1-31.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return day of month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
