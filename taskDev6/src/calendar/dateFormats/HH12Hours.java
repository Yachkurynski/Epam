package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for hours matched key-word "hh".
 */
public class HH12Hours extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static String format = "hh";

  /**
   * Returns hours of day in format 01-12.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed hours.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int hour = calendar.get(Calendar.HOUR);
      return hour < TWO_SYMBOLS ? ZERO + hour : String.valueOf(hour);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
