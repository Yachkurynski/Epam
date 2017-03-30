package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "yyyy".
 */
public class YYYYYearTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  YYYYYear year;

  @Before
  public void setUp() throws Exception {
    year = new YYYYYear();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "yyyy";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(rightFormat, calendar);
    assertEquals("2017", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}