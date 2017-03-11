package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for half of the day matched key-word "tt".
 */
public class TTHalfOfTheDay extends DateFormat {
  private static String format = "tt";

  /**
   * Describes words matched half of the day.
   */
  private enum FullHalfOfTheDay {
    AM, PM
  }

  /**
   * Returns half of the day.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed half of the day.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(FullHalfOfTheDay.values()[calendar.get(Calendar.AM_PM)]);
    } else {
      return getNextFormat().getFormatedDate(format, calendar);
    }
  }
}
