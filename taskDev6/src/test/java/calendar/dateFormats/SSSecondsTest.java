package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class SSSecondsTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  SSSeconds second;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 3);
    rightFormat = "ss";
    wrongFormat = "aa";
    second = new SSSeconds();
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = second.getFormatedDate(rightFormat, calendar);
    assertEquals("03", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = second.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}