package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class MMMinutesTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMMinutes minute;

  @Before
  public void setUp() throws Exception {
    minute = new MMMinutes();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "mm";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = minute.getFormatedDate(rightFormat, calendar);
    assertEquals("07", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = minute.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}