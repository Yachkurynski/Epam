package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for not zero fractions of a second matched key-word "FFF".
 */
public class FFFNotZeroSplitSecond extends DateFormat {
  private static int FORMAT_LENGTH = 3;
  private static String ZERO = "0";
  private static String format = "FFF";

  /**
   * Returns not zero fractions of a second. (631 ms => 631)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    String valueToReturn = "";

    if (format.equals(this.format)) {
      String zeros = "";
      int millis = calendar.get(Calendar.MILLISECOND);

      if (millis != 0) {
        String splitSecondStr = String.valueOf(millis);

        while (zeros.length() < FORMAT_LENGTH - splitSecondStr.length()) {
          zeros += ZERO;
        }
        valueToReturn = zeros + splitSecondStr;
      }
    } else {
      valueToReturn = getNextFormat().getFormatedDate(format, calendar);
    }
    return valueToReturn;
  }
}
