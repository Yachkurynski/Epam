package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "HH".
 */
public class HH24HoursTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  HH24Hours hour;

  @Before
  public void setUp() throws Exception {
    hour = new HH24Hours();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "HH";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(rightFormat, calendar);
    assertEquals("21", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}