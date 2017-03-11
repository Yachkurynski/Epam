package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for hours matched key-word "HH".
 */
public class HH24Hours extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static String format = "HH";

  /**
   * Returns hours of day in format 01-24.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed hours.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      return hour < TWO_SYMBOLS ? ZERO + hour : String.valueOf(hour);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
