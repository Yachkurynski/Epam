package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for fractions of a second matched key-word "fff".
 */
public class FFFSplitSecond extends DateFormat {
  private static int FORMAT_LENGTH = 3;
  private static String ZERO = "0";
  private static String format = "fff";

  /**
   * Returns fractions of a second. (31 ms => 031)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      String zeros = "";
      String splitSecondStr = String.valueOf(calendar.get(Calendar.MILLISECOND));

      while (zeros.length() < FORMAT_LENGTH - splitSecondStr.length()) {
        zeros += ZERO;
      }
      return zeros + splitSecondStr;
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
