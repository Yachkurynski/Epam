package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for year matched key-word "yy".
 */
public class YYYear extends DateFormat {
  private static String ZERO = "0";
  private static int TWO_SYMBOLS = 10;
  private static int HUNDRED = 100;
  private static String format = "yy";

  /**
   * Returns year in format 00-99.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed year.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      int year = (calendar.get(Calendar.YEAR) % HUNDRED);
      return year < TWO_SYMBOLS ? ZERO + year : String.valueOf(year);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
