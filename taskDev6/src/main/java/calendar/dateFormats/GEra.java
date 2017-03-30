package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for era matched key-word "g".
 */
public class GEra extends DateFormat {
  private static String format = "g";

  /**
   * Describes eras.
   */
  private enum Era {
    BD, AD
  }

  /**
   * Returns era described in enum Era.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed era.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(Era.values()[calendar.get(Calendar.ERA)]);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
