package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for months matched key-word "MMM".
 */
public class MMMMonth extends DateFormat {
  private static String format = "MMM";

  /**
   * Describes all the months in short form.
   */
  private enum ShortMonths {
    Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
  }

  /**
   * Returns month in format described in ShortMonths enum.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed month.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(ShortMonths.values()[calendar.get(Calendar.MONTH)]);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
