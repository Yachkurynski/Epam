package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for year matched key-word "yyyy".
 */
public class YYYYYear extends DateFormat {
  private static String ZERO = "0";
  private static int FORMAT_LENGTH = 4;
  private static String format = "yyyy";

  /**
   * Returns year in format 0000-9999.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed year.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      String zeros = "";
      String yearStr = String.valueOf(calendar.get(Calendar.YEAR));

      while (zeros.length() < FORMAT_LENGTH - yearStr.length()) {
        zeros += ZERO;
      }
      return zeros + yearStr;
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
