package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for not zero split seconds matched key-word "FF".
 */
public class FFNotZeroSplitSecond extends DateFormat {
  private static final int TEN = 10;
  private static final int FORMAT_LENGTH = 2;
  private static String ZERO = "0";
  private static String format = "FF";

  /**
   * Returns not zero fractions of a second. (631 ms => 63)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    String valueToReturn = "";

    if (format.equals(this.format)) {
      String zeros = "";
      int millis = calendar.get(Calendar.MILLISECOND) / TEN;

      if (millis != 0) {
        String splitSecondStr = String.valueOf(millis);

        while (zeros.length() < FORMAT_LENGTH - splitSecondStr.length()) {
          zeros += ZERO;
        }
        valueToReturn = zeros + splitSecondStr;
      }
    } else if (getNextFormat() != null) {
      valueToReturn = getNextFormat().getFormatedDate(format, calendar);
    } else {
      valueToReturn = format;
    }
    return valueToReturn;
  }
}
