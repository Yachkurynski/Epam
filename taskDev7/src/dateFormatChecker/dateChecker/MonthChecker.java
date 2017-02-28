package dateFormatChecker.dateChecker;

/**
 * Checks that number of month has right value.
 */
public class MonthChecker extends DateChecker {

  /**
   * Checks that month's value isn't out of borders (01-12).
   *
   * @param value month's value which need to check.
   * @return true if it satisfies the conditions.
   */
  @Override
  public boolean check(String value) {
    int month = Integer.parseInt(value);

    if (month > 0 && month < 13 && value.length() == 2) {
      return true;
    } else {
      return false;
    }
  }
}
