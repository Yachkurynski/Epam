package dateFormatChecker.dateChecker;

/**
 * Checks that day of month is right.
 */
public class DayOfMonthChecker extends DateChecker {
  private static final int FEBRUARY = 2;
  private static final int APRIL = 4;
  private static final int JUNE = 6;
  private static final int SEPTEMBER = 9;
  private static final int NOVEMBER = 11;
  private static final int LONG_FEBRUARY_DAYS = 29;
  private static final int SHORT_FEBRUARY_DAYS = 28;
  private static final int SHORT_MONTHS_DAYS = 30;

  /**
   * Checks that day isn't out of month's borders.
   *
   * @param value value of day which need to check.
   * @return true if day is in the borders.
   */
  @Override
  public boolean check(String value) {
    int dayOfMonth = Integer.parseInt(value);

    if (dayOfMonth > 0 && dayOfMonth < 32 && value.length() == 2) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks value of day according to amount of days in each month including leap years.
   *
   * @param monthStr given number of month.
   * @param dayStr given number of day.
   * @param isLeapYear value which shows that year is leap if it's true.
   * @return true if number of day satisfies the conditions.
   */
  public boolean checkDayOfMonth(String monthStr, String dayStr, boolean isLeapYear) {
    int month = Integer.parseInt(monthStr);
    int day = Integer.parseInt(dayStr);
    boolean isValid = false;

    if (isShortMonth(month)) {
      if (month == FEBRUARY && isLeapYear && day <= LONG_FEBRUARY_DAYS) {
        isValid = true;
      } else if (month == FEBRUARY && !isLeapYear && day <= SHORT_FEBRUARY_DAYS) {
        isValid = true;
      } else if (month != FEBRUARY && day <= SHORT_MONTHS_DAYS) {
        isValid = true;
      }
    } else {
      if (month <= 31) {
        isValid = true;
      }
    }
    return isValid;
  }

  /**
   * Checks that given month is short (less than 31 days).
   *
   * @param month number of month.
   * @return true if it's short.
   */
  private boolean isShortMonth(int month) {
    return month == FEBRUARY || month == APRIL || month == JUNE || month == SEPTEMBER
        || month == NOVEMBER;
  }
}
