package dateFormatChecker.dateChecker;

/**
 * Checks that hour has right value.
 */
public class HourChecker extends DateChecker{

  /**
   * Checks that value of hour isn't out of borders (00-23).
   *
   * @param value value of hour which need to check.
   * @return true if it satisfies the conditions.
   */
  @Override
  public boolean check(String value) {
    int hour = Integer.parseInt(value);

    if (hour >= 0 && hour < 24 && value.length() == 2) {
      return true;
    } else {
      return false;
    }
  }
}
