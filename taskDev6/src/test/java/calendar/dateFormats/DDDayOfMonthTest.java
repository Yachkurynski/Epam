package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "dd".
 */
public class DDDayOfMonthTest {
  DDDayOfMonth dayOfMonth;
  Calendar calendar;
  String rightFormat;
  String wrongFormat;

  @Before
  public void setUp() throws Exception {
    dayOfMonth = new DDDayOfMonth();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 2, 23, 7, 30);
    rightFormat = "dd";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = dayOfMonth.getFormatedDate(rightFormat, calendar);
    assertEquals("02", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = dayOfMonth.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }

}