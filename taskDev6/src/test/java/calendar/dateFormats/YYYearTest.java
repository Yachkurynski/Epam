package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "yy".
 */
public class YYYearTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  YYYear year;

  @Before
  public void setUp() throws Exception {
    year = new YYYear();

    calendar = Calendar.getInstance();
    calendar.set(2009, 2, 12, 21, 7, 30);
    rightFormat = "yy";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(rightFormat, calendar);
    assertEquals("09", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}