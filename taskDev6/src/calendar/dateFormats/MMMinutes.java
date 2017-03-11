package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for minutes matched key-word "mm".
 */
public class MMMinutes extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static String format = "mm";

  /**
   * Returns minutes in format 00-59.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed minutes.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int minute = calendar.get(Calendar.MINUTE);
      return minute < TWO_SYMBOLS ? ZERO + minute : String.valueOf(minute);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
