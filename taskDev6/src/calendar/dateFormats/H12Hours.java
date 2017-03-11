package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for hours matched key-word "h".
 */
public class H12Hours extends DateFormat {
  private static String format = "h";

  /**
   * Returns hours of day in format 1-12.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed hour.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.HOUR));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
