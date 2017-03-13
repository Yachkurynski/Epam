package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for day of month matched key-word "dd".
 */
public class DDDayOfMonth extends DateFormat{
  private static int TWO_SYMBOLS = 10;
  private static String ZERO = "0";
  private static String format = "dd";

  /**
   * Returns day of month in format 01-31.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return day of month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int date = calendar.get(Calendar.DAY_OF_MONTH);
      return date < TWO_SYMBOLS ? ZERO + date : String.valueOf(date);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
