package calendar;

import java.util.*;

/**
 * Looking needed value of date or time according to given format.
 */
public class DateBuilder {
  private static final String F_LOWER_LETTER = "f";
  private static final String F_UPPER_LETTER = "F";
  private static final String M_LOWER_LETTER = "m";
  private static final String M_UPPER_LETTER = "M";
  private static final String H_LOWER_LETTER = "h";
  private static final String H_UPPER_LETTER = "H";
  private static final String G_LOWER_LETTER = "g";
  private static final String D_LOWER_LETTER = "d";
  private static final String Y_LOWER_LETTER = "y";
  private static final String S_LOWER_LETTER = "s";
  private static final String T_LOWER_LETTER = "t";
  private static final String Z_LOWER_LETTER = "z";
  private static final int ONE_LETTER = 1;
  private static final int TWO_LETTERS = 2;
  private static final int THREE_LETTERS = 3;
  private static final int FOUR_LETTERS = 4;
  private static final int TWO_DIGITS = 10;

  /**
   * Returns value of date or time that matches given descriptor.
   *
   * @param string descriptor of needed value.
   * @param months object which describes months.
   * @param days object which describes days of the week.
   * @return needed value of time or date.
   */
  public String getMatchedTime(String string, Month months, DayOfWeek days) {
    Calendar cal = new GregorianCalendar();

    if (string.contains(D_LOWER_LETTER)) {
      string = getDay(cal, days, string.length());
    } else if (string.contains(M_UPPER_LETTER)) {
      string = getValue(cal.get(Calendar.MONTH) + 1, string.length(),
          months.getMonth(cal.get(Calendar.MONTH) + 1));
    } else if (string.contains(Y_LOWER_LETTER)) {
      string = getValue(cal.get(Calendar.YEAR), string.length());
    } else if (string.contains(H_LOWER_LETTER)) {
      string = getValue(cal.get(Calendar.HOUR), string.length());
    } else if (string.contains(H_UPPER_LETTER)) {
      string = getValue(cal.get(Calendar.HOUR_OF_DAY), string.length());
    } else if (string.contains(M_LOWER_LETTER)) {
      string = getValue(cal.get(Calendar.MINUTE), string.length());
    } else if (string.contains(S_LOWER_LETTER)) {
      string = getValue(cal.get(Calendar.SECOND), string.length());
    } else if (string.contains(G_LOWER_LETTER)) {
      string = cal.get(Calendar.ERA) == 1 ? "A.D." : "B.D.";
    } else if (string.contains(T_LOWER_LETTER)) {
      string = getHalfOfDay(cal.get(Calendar.AM_PM), string.length());
    } else if (string.contains(F_LOWER_LETTER)) {
      string = getMillis(string.length(), cal.get(Calendar.MILLISECOND));
    } else if (string.contains(F_UPPER_LETTER)) {
      string = getNotNullMillis(string.length(), cal.get(Calendar.MILLISECOND));
    } else if (string.contains(Z_LOWER_LETTER)) {
      string = getOffset(cal.get(Calendar.ZONE_OFFSET), string.length());
    }
    return string;
  }

  /**
   * Returns time offset according to descriptor's length.
   *
   * @param value time offset in milliseconds.
   * @param length descriptor's length.
   * @return needed value of time offset.
   */
  public String getOffset(int value, int length) {
    double offset = value/36e5; // for convert milliseconds to hours.
    String string = String.valueOf((int)offset);

    if (length == TWO_LETTERS) {
      string = "0" + string;
    } else if (length == THREE_LETTERS) {
      string += ":" + String.valueOf((int)((offset - (int)offset) * 60));
    }
    return string;
  }

  /**
   * Returns string representation of needed value according to length of this value's descriptor.
   * For cases when months and days of week are used.
   *
   * @param value source current value, that matches to descriptor.
   * @param length descriptor's length.
   * @param string source string value, that matches current value.
   * @return string representation of the value.
   */
  public String getValue(int value, int length, String string) {
    if (length == ONE_LETTER) {
      string = String.valueOf(value);
    } else if (length == TWO_LETTERS) {
      if (value < TWO_DIGITS) {
        string = "0" + value;
      }
    } else if (length == THREE_LETTERS) {
      string = string.substring(0, length);
    }
    return string;
  }

  /**
   * Returns string representation of needed value according to length of this value's descriptor.
   *
   * @param value source current value, that matches to descriptor.
   * @param length descriptor's length.
   * @return string representation of the value.
   */
  public String getValue(int value, int length) {
    String string = String.valueOf(value);

    if (length == ONE_LETTER) {
      if (string.length() > TWO_LETTERS) {
        string = string.substring(2, string.length());
      }
    } else if (length == TWO_LETTERS) {
      if (string.length() > TWO_LETTERS) {
        string = string.substring(2, string.length());
      }
      if (Integer.parseInt(string) < TWO_DIGITS) {
        string = "0" + string;
      }
    } else if (length == THREE_LETTERS) {
      string = string.substring(1, length + 1);
    }
    return string;
  }

  /**
   * Returns milliseconds according to given descriptor's length.
   *
   * @param length descriptor's length.
   * @param value current value of milliseconds.
   * @return needed value of milliseconds.
   */
  public String  getMillis(int length, int value) {
    String string = String.valueOf(value);
    if (length < FOUR_LETTERS) {
      string =  string.substring(0, length);
    } else if (length > THREE_LETTERS && length < 8){
      string =  String.valueOf(value);
    }
    return string;
  }

  /**
   * Returns milliseconds according to given descriptor's length. For cases when they are not null.
   *
   * @param length descriptor's length.
   * @param value current value of milliseconds.
   * @return needed value of milliseconds.
   */
  public String getNotNullMillis(int length, int value) {
    String string = String.valueOf(value);
    if (length < FOUR_LETTERS) {
      string =  string.substring(0, length);
    } else if (length > THREE_LETTERS && length < 8){
      string =  String.valueOf(value);
    }
    return Integer.parseInt(string) != 0 ? string : "";
  }

  /**
   * Returns value which means half of day (AM/PM).
   *
   * @param value given value.
   * @param length needed length of returned value.
   * @return string representation of half of day.
   */
  public String getHalfOfDay(int value, int length) {
    if (length == ONE_LETTER) {
      return value == 1 ? "P" : "A";
    } else {
      return value == 1 ? "PM" : "AM";
    }
  }

  /**
   * Returns string value of day according to descriptor's length.
   *
   * @param calendar object of java.util.Calendar.
   * @param days object which describes days of the week.
   * @param length descriptor's length.
   * @return needed value of day.
   */
  public String getDay (Calendar calendar, DayOfWeek days, int length) {
    if (length < THREE_LETTERS) {
      return getValue(calendar.get(Calendar.DAY_OF_MONTH), length);
    } else {
      return getValue(calendar.get(Calendar.DAY_OF_WEEK), length,
          days.getDay(calendar.get(Calendar.DAY_OF_WEEK)));
    }
  }
}
