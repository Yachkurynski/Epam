package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for zone offset matched key-word "zz".
 */
public class ZZTimeOffset extends DateFormat {
  private static String ZERO = "0";
  private static double FROM_MILLIS_TO_HOURS = 36e5;
  private static int FORMAT_LENGTH = 2;
  private static String format = "zz";

  /**
   * Returns zone offset in format (1:00 => 01).
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed zone time offset.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      double hoursOffset = calendar.get(Calendar.ZONE_OFFSET) / FROM_MILLIS_TO_HOURS;
      String hoursOffsetStr = String.valueOf((int)hoursOffset);

      if (hoursOffsetStr.length() < FORMAT_LENGTH) {
        hoursOffsetStr = ZERO + hoursOffsetStr;
      }
      return hoursOffsetStr;
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
