package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for day of week matched key-word "dddd".
 */
public class DDDDDayOfTheWeek extends DateFormat {
  private static String format = "dddd";

  /**
   * Contains all the days of week in full format.
   */
  private enum FullDays {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
  }

  /**
   * Returns day of week in format full format.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return day of week.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(FullDays.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
