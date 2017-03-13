package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "M".
 */
public class MMonthTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMonth month;

  @Before
  public void setUp() throws Exception {
    month = new MMonth();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "M";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(rightFormat, calendar);
    assertEquals("3", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}