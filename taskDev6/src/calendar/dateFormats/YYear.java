package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for year matched key-word "y".
 */
public class YYear extends DateFormat {
  private static int HUNDRED = 100;
  private static String format = "y";

  /**
   * Returns year in format 0-99.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed year.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.YEAR) % HUNDRED);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
