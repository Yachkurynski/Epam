package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for months matched key-word "MMMM".
 */
public class MMMMMonth extends DateFormat {
  private static String format = "MMMM";

  /**
   * Describes all the months in full form.
   */
  private enum FullMonths {
    January, February, March, April, May, June, July, August, September, October, November,
    December
  }

  /**
   * Returns month in format described in FullMonths enum.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(FullMonths.values()[calendar.get(Calendar.MONTH)]);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
