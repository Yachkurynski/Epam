package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "y".
 */
public class YYearTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  YYear year;

  @Before
  public void setUp() throws Exception {
    year = new YYear();

    calendar = Calendar.getInstance();
    calendar.set(2009, 2, 12, 21, 7, 30);
    rightFormat = "y";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(rightFormat, calendar);
    assertEquals("9", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}