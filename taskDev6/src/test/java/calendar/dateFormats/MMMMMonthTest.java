package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "MMMM".
 */
public class MMMMMonthTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMMMMonth month;

  @Before
  public void setUp() throws Exception {
    month = new MMMMMonth();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "MMMM";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(rightFormat, calendar);
    assertEquals("March", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}