package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for year matched key-word "yyy".
 */
public class YYYYear extends DateFormat {
  private static String ZERO = "0";
  private static int FORMAT_LENGTH = 3;
  private static int THOUSAND = 1000;
  private static String format = "yyy";

  /**
   * Returns year. (1234 => 234, 2004 => 004)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed year.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      String zeros = "";
      String yearStr = String.valueOf(calendar.get(Calendar.YEAR) % THOUSAND);

      while (zeros.length() < FORMAT_LENGTH - yearStr.length()) {
        zeros += ZERO;
      }
      return zeros + yearStr;
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
