package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for not zero split seconds matched key-word "F".
 */
public class FNotZeroSplitSecond extends DateFormat {
  private static int HUNDRED = 100;
  private static String format = "F";

  /**
   * Returns not zero fractions of a second. (631 ms => 6)
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed time.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    String valueToReturn = "";

    if (format.equals(this.format)) {
      int millis = calendar.get(Calendar.MILLISECOND) / HUNDRED;

      if (millis != 0) {
        valueToReturn = String.valueOf(millis);
      }
    } else {
      valueToReturn = getNextFormat().getFormatedDate(format, calendar);
    }
    return valueToReturn;
  }
}
