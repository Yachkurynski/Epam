package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class SSecondsTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  SSeconds seconds;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "s";
    wrongFormat = "aa";
    seconds = new SSeconds();
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = seconds.getFormatedDate(rightFormat, calendar);
    assertEquals("30", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = seconds.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}