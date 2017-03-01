package calendar;

import java.util.HashMap;
import java.util.Map;

/**
 * Describes days of the week.
 */
public class DayOfWeek {
  private Map<Integer, String> days = new HashMap<>();
  private static DayOfWeek dayOfWeek;

  /**
   * Create object and fills Map by days and their numbers.
   */
  private DayOfWeek() {
    this.days.put(2, "Monday");
    this.days.put(3, "Tuesday");
    this.days.put(4, "Wednesday");
    this.days.put(5, "Thursday");
    this.days.put(6, "Friday");
    this.days.put(7, "Saturday");
    this.days.put(1, "Sunday");
  }

  /**
   * Allows to get string representation of day by its number.
   *
   * @param number day's number in Map
   * @return day's name.
   */
  public String getDay(int number) {
    return this.days.get(number);
  }

  /**
   * Provides existence only one instance.
   *
   * @return instance.
   */
  public static DayOfWeek getDayOfWeek() {
    if (dayOfWeek == null) {
      dayOfWeek = new DayOfWeek();
    }
    return dayOfWeek;
  }
}
