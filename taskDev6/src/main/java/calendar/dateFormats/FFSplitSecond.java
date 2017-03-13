package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for fractions of a second matched key-word "ff".
 */
public class FFSplitSecond extends DateFormat {
  private static int TEN = 10;
  private static int FORMAT_LENGTH = 2;
  private static String ZERO = "0";
  private static String format = "ff";

  /**
   * Returns not zero fractions of a second. (31 ms => 03)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      String zeros = "";
      String splitSecondStr = String.valueOf(calendar.get(Calendar.MILLISECOND) / TEN);

      while (zeros.length() < FORMAT_LENGTH - splitSecondStr.length()) {
        zeros += ZERO;
      }
      return zeros + splitSecondStr;
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
