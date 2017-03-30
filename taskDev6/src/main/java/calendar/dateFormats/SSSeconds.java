package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for seconds matched key-word "ss".
 */
public class SSSeconds extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static String format = "ss";

  /**
   * Returns seconds in format 00-59.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed seconds.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int second = calendar.get(Calendar.SECOND);
      return second < TWO_SYMBOLS ? ZERO + second : String.valueOf(second);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
