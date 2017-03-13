package calendar.dateFormats;

import java.util.Calendar;

/**
 * Parent class for date formatter. Allows to use chain of responsibility.
 */
public abstract class DateFormat {
  private static String format;
  private DateFormat nextFormat;

  public void setNextFormat(DateFormat nextFormat) {
    this.nextFormat = nextFormat;
  }

  public DateFormat getNextFormat() {
    return nextFormat;
  }

  public abstract String getFormatedDate(String format, Calendar calendar);
}
