package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for zone offset matched key-word "zzz".
 */
public class ZZZTimeOffset extends DateFormat {
  private static String ZERO = "0";
  private static String COLON = ":";
  private static double FROM_MILLIS_TO_MINUTES = 6e4;
  private static int FROM_MINUTES_TO_HOURS = 60;
  private static int FORMAT_LENGTH = 2;
  private static String format = "zzz";

  /**
   * Returns zone offset in format (1:00 => 01:00).
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed zone time offset.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      double minuteOffset = calendar.get(Calendar.ZONE_OFFSET) / FROM_MILLIS_TO_MINUTES;
      int minutes = (int)minuteOffset % FROM_MINUTES_TO_HOURS;
      int hours = (int)(minuteOffset / FROM_MINUTES_TO_HOURS);
      String hoursStr = String.valueOf(hours);
      String minuteStr = String.valueOf(minutes);

      if (hoursStr.length() < FORMAT_LENGTH) {
        hoursStr = ZERO + hoursStr;
      }

      if (minuteStr.length() < FORMAT_LENGTH) {
        minuteStr = ZERO + minuteStr;
      }
      return hoursStr + COLON + minuteStr;
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
