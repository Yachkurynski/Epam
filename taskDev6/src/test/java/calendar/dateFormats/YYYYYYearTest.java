package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "yyyyy".
 */
public class YYYYYYearTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  YYYYYYear year;

  @Before
  public void setUp() throws Exception {
    year = new YYYYYYear();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "yyyyy";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(rightFormat, calendar);
    assertEquals("02017", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = year.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}