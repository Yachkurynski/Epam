package calendar;

import static org.junit.Assert.*;

import calendar.dateFormats.DateFormat;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class DateBuilderTest {
  DateBuilder dateBuilder;
  DateGetter getter;
  DateFormat formatter;
  Calendar calendar;
  String firstFormat;
  String secondFormat;
  String thirdFormat;
  String fourthFormat;

  @Before
  public void setUp() throws Exception {
    dateBuilder = new DateBuilder();
    getter = new DateGetter();
    calendar = Calendar.getInstance();
    formatter = getter.getCurrentTime();

    calendar.set(2017, 5, 23, 15, 0, 0);

    firstFormat = "dd/MM/yyyy hh:mm:ss tt dddd";
    secondFormat = "Today is: dd/MM/yyyy dddd";
    thirdFormat = "Invalid symbols = (-)";
    fourthFormat = "";
  }

  @Test
  public void testPositiveBuildCurrentDate() throws Exception {
    String actual = dateBuilder.buildCurrentDate(firstFormat, formatter, calendar);
    String expected = "23/05/2017 03:00:00 PM Friday";
    assertEquals(expected, actual);
  }

  @Test
  public void testPositiveBuildCurrentDateWithOtherWords() throws Exception {
    String actual = dateBuilder.buildCurrentDate(secondFormat, formatter, calendar);
    String expected = "Today is: 23/05/2017 Friday";
    assertEquals(expected, actual);
  }

  @Test
  public void testPositiveBuildCurrentDateWithIllegalSymbols() throws Exception {
    String actual = dateBuilder.buildCurrentDate(thirdFormat, formatter, calendar);
    String expected = thirdFormat;
    assertEquals(expected, actual);
  }

  @Test
  public void testPositiveBuildCurrentDateWithEmptyString() throws Exception {
    String actual = dateBuilder.buildCurrentDate(fourthFormat, formatter, calendar);
    String expected = fourthFormat;
    assertEquals(expected, actual);
  }
}