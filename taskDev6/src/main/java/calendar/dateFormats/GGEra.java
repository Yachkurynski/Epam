package calendar.dateFormats;

import java.util.Calendar;

/**
 * Describes formatter for era matched key-word "gg".
 */
public class GGEra extends DateFormat {
  private static String format = "gg";

  /**
   * Describes eras.
   */
  private enum Eras {
    BD, AD
  }

  /**
   * Returns era described in enum Eras.
   *
   * @param format given key-word of needed format.
   * @param calendar calendar for date getting.
   * @return needed era.
   */
  public String getFormatedDate(String format, Calendar calendar) {
    if (format.equals(this.format)) {
      return String.valueOf(Eras.values()[calendar.get(Calendar.ERA)]);
    } else if (getNextFormat() != null) {
      return getNextFormat().getFormatedDate(format, calendar);
    } else {
      return format;
    }
  }
}
