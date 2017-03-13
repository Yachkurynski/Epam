package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class MMinutesTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMinutes minute;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "m";
    wrongFormat = "aa";
    minute = new MMinutes();
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