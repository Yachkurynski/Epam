package dateFormatChecker.dateChecker;

/**
 * Parent class for all date checkers.
 */
public abstract class DateChecker {

  /**
   * Checks entered value according to class purpose.
   *
   * @param value value which need to check.
   * @return true if value is valid (it depends on class purpose).
   */
  public abstract boolean check(String value);
}
