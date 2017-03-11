package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for hours matched key-word "H".
 */
public class H24Hours extends DateFormat {
  private static String format = "H";

  /**
   * Returns hours of day in format 1-24.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed hours.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
