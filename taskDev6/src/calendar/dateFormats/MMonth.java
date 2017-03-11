package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for months matched key-word "M".
 */
public class MMonth extends DateFormat {
  private static String format = "M";

  /**
   * Returns month in format 1-12.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.MONTH));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
