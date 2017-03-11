package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for zone offset matched key-word "z".
 */
public class ZTimeOffset extends DateFormat {
  private static double FROM_MILLIS_TO_HOURS = 36e5;
  private static String format = "z";

  /**
   * Returns zone offset in format (1:00 => 1).
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed zone time offset.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      double offset = calendar.get(Calendar.ZONE_OFFSET) / FROM_MILLIS_TO_HOURS;
      return String.valueOf((int)offset);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
