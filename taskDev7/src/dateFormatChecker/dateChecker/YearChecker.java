package dateFormatChecker.dateChecker;

/**
 * Performs operations with year's value.
 */
public class YearChecker extends DateChecker {

  /**
   * Checks that value of year isn't negative.
   *
   * @param value year's value which need to check.
   * @return true if it satisfies the conditions.
   */
  @Override
  public boolean check(String value) {
    int year = Integer.parseInt(value);

    if (year >= 0 && value.length() == 4) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks that given year is leap or not.
   *
   * @param yearStr value of year which need to check.
   * @return true if it's leap.
   */
  public boolean isLeap(String yearStr) {
    int year = Integer.parseInt(yearStr);
    boolean isLeapYear = false;

    if (year % 4 == 0) {
      if (year % 100 != 0) {
        isLeapYear = true;
      } else if (year % 100 == 0 && year % 400 == 0) {
        isLeapYear = true;
      }
    }
    return isLeapYear;
  }
}
