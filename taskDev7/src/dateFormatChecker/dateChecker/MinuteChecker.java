package dateFormatChecker.dateChecker;

/**
 * Checks that minutes have right value.
 */
public class MinuteChecker extends DateChecker {

  /**
   * Checks that value of minutes aren't out of borders (00-59).
   *
   * @param value amount of minutes which need to check.
   * @return true if it satisfies the conditions.
   */
  @Override
  public boolean check(String value) {
    int minute = Integer.parseInt(value);

    if (minute >= 0 && minute < 60 && value.length() == 2) {
      return true;
    } else {
      return false;
    }
  }
}
