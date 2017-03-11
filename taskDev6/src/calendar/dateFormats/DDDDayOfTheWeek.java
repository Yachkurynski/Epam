package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for day of week matched key-word "ddd".
 */
public class DDDDayOfTheWeek extends DateFormat {
  private static String format = "ddd";

  /**
   * Contains all the days of week in short format.
   */
  private enum ShortDays {
    Sun, Mon, Tue, Wed, Thu, Fri, Sat
  }

  /**
   * Returns day of week in format short format.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return day of week.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(ShortDays.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
