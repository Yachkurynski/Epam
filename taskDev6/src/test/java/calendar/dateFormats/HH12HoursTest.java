package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "hh".
 */
public class HH12HoursTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  HH12Hours hour;

  @Before
  public void setUp() throws Exception {
    hour = new HH12Hours();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "hh";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(rightFormat, calendar);
    assertEquals("09", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}