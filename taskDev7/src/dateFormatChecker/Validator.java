package dateFormatChecker;

import dateFormatChecker.dateChecker.DateChecker;
import dateFormatChecker.dateChecker.DayOfMonthChecker;
import dateFormatChecker.dateChecker.HourChecker;
import dateFormatChecker.dateChecker.MinuteChecker;
import dateFormatChecker.dateChecker.MonthChecker;
import dateFormatChecker.dateChecker.YearChecker;
import java.util.Arrays;
import java.util.List;

/**
 * Checks that input string satisfies fixed format.
 */
public class Validator {

  /**
   * Checks that input string is date in fixed format.
   *
   * @param inputString given date.
   * @return true if it satisfies format.
   */
  public boolean isValid(String inputString) {
    boolean isValidValue = false;
    List<DateChecker> checkerArray = Arrays.asList(new DayOfMonthChecker(), new MonthChecker(),
        new YearChecker(), new HourChecker(), new MinuteChecker());

    if (isValidFormat(inputString)) {
      String[] dateArray = inputString.split("[ /:]+");

      if (dateArray.length == checkerArray.size()) {
        isValidValue = isValidDate(dateArray, checkerArray);
      }
    } else {
      isValidValue = false;
    }
    return isValidValue;
  }

  /**
   * Checks that values of date are valid.
   *
   * @param dateArray array of date's values.
   * @param checkerArray array of checkers for date.
   * @return true if all values of date are valid.
   */
  private boolean isValidDate(String[] dateArray, List<DateChecker> checkerArray) {
    boolean isValidDate = true;

    for (int i = 0; i < dateArray.length; i++) {
      boolean isCorrectValue = checkerArray.get(i).check(dateArray[i]);

      if (!isCorrectValue) {
        isValidDate = false;
        break;
      }
    }
    DayOfMonthChecker dayChecker = new DayOfMonthChecker();
    YearChecker yearChecker = new YearChecker();

    isValidDate &= dayChecker.checkDayOfMonth(dateArray[1], dateArray[0],
        yearChecker.isLeap(dateArray[2]));
    return isValidDate;
  }

  /**
   * Checks that format of given date satisfies fixed format.
   *
   * @param inputString given date.
   * @return true if string satisfies format.
   */
  private boolean isValidFormat(String inputString) {
    String wrongSymbols = inputString.replaceAll("[ :/0-9]+", "");
    boolean isValidFormat = true;

    if (wrongSymbols.length() == 0) {
      String buffString = inputString.replaceAll("[ ]+", "").replaceAll("[0-9]+", " ");

      for (int i = 1; i < buffString.length(); i++) {
        if (buffString.charAt(i) == buffString.charAt(i - 1)) {
          isValidFormat = false;
          break;
        }
      }

    } else {
      isValidFormat = false;
    }
    return isValidFormat;
  }
}
