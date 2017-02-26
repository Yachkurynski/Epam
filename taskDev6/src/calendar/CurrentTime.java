package calendar;

/**
 * Calculate current time according to format.
 */
public class CurrentTime {

  /**
   * Returns current time according to given format.
   *
   * @param format needed time format.
   * @return a string representation of time.
   */
  public String getCurrentTime(String[] format) {
    Month months = Month.getMonth();
    DayOfWeek days = DayOfWeek.getDayOfWeek();
    DateBuilder dateBuilder = new DateBuilder();
    StringBuilder stringBuilder = new StringBuilder();

    for (String str : format) {
      stringBuilder.append(dateBuilder.getMatchedTime(str, months, days) + " ");
    }
    return stringBuilder.toString();
  }
}
