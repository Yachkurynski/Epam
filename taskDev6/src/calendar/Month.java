package calendar;

import java.util.*;

/**
 * Describes months.
 */
public class Month {
  private Map<Integer, String> months = new HashMap<>();
  private static Month month;

  /**
   * Create object and fills Map by months and their numbers.
   */
  private Month() {
    this.months.put(1, "January");
    this.months.put(2, "February");
    this.months.put(3, "March");
    this.months.put(4, "April");
    this.months.put(5, "May");
    this.months.put(6, "June");
    this.months.put(7, "July");
    this.months.put(8, "August");
    this.months.put(9, "September");
    this.months.put(10, "October");
    this.months.put(11, "November");
    this.months.put(12, "December");
  }

  /**
   * Allows to get string representation of month by its number.
   *
   * @param number month's number.
   * @return month's name.
   */
  public String getMonth(int number) {
    return this.months.get(number);
  }

  /**
   * Provides existence only one instance.
   *
   * @return instance.
   */
  public static Month getMonth() {
    if (month == null) {
      month = new Month();
    }
    return month;
  }
}
