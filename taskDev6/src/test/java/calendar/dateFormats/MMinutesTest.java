package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "m".
 */
public class MMinutesTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMinutes minute;

  @Before
  public void setUp() throws Exception {
    minute = new MMinutes();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "m";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = minute.getFormatedDate(rightFormat, calendar);
    assertEquals("7", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = minute.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}