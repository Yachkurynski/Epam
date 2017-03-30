package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for minutes matched key-word "m".
 */
public class MMinutes extends DateFormat {
  private static String format = "m";

  /**
   * Returns minutes in format 0-59.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed minutes.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(calendar.get(Calendar.MINUTE));
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
