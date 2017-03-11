package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for half of the day matched key-word "t".
 */
public class THalfOfTheDay extends DateFormat {
  private static String format = "t";

  /**
   * Describes words matched half of the day.
   */
  private enum HalfOfTheDay {
    A, P
  }

  /**
   * Returns half of the day in short form.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed half of the day.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(HalfOfTheDay.values()[calendar.get(Calendar.AM_PM)]);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
