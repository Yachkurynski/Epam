package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for months matched key-word "MM".
 */
public class MMMonth extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static String format = "MM";

  /**
   * Returns month in format 01-12.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int month = calendar.get(Calendar.MONTH);
      return month < TWO_SYMBOLS ? ZERO + month : String.valueOf(month);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
