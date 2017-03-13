package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "dddd".
 */
public class DDDDDayOfTheWeekTest {
  DDDDDayOfTheWeek dayOfTheWeek;
  Calendar calendar;
  String rightFormat;
  String wrongFormat;

  @Before
  public void setUp() throws Exception {
    dayOfTheWeek = new DDDDDayOfTheWeek();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 23, 7, 30);
    rightFormat = "dddd";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = dayOfTheWeek.getFormatedDate(rightFormat, calendar);
    assertEquals("Sunday", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = dayOfTheWeek.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }

}