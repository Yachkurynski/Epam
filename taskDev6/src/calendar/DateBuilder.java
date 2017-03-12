package calendar;

import calendar.dateFormats.DateFormat;
import java.util.Calendar;

/**
 * Builds current date according to format.
 */
public class DateBuilder {
  private static final String COLON = ":";
  private static final String SLASH = "/";
  private static final String SPACE = " ";

  /**
   * Builds current date according to given format.
   *
   * @param format needed format
   * @param formatter formatter for giving date.
   * @param calendar calendar for formatter
   * @return date in needed format.
   */
  public String buildCurrentDate(String format, DateFormat formatter, Calendar calendar) {
    StringBuilder formatToReturn = new StringBuilder();
    int formatBeginning = 0;

    for (int i = 0; i < format.length(); i++) {
      String currentSymb = format.substring(i, i + 1);

      if (isOperator(currentSymb)) {
        String currFormat = format.substring(formatBeginning, i);
        formatToReturn.append(formatter.getFormatedDate(currFormat, calendar)).append(currentSymb);
        formatBeginning = i + 1;
      }

      if (i == format.length() - 1) {
        String currFormat = format.substring(formatBeginning, i + 1);
        formatToReturn.append(formatter.getFormatedDate(currFormat, calendar));
      }
    }
    return formatToReturn.toString();
  }

  /**
   * Checks that current symbol is operator.
   *
   * @param currentSymbol symbol to compare.
   * @return true if it is operator.
   */
  private boolean isOperator(String currentSymbol) {
    return currentSymbol.equals(SLASH) || currentSymbol.equals(COLON) ||
        currentSymbol.equals(SPACE);
  }
}
