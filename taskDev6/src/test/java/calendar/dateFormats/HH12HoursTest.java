package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class HH12HoursTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  HH12Hours hour;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 21, 7, 30);
    rightFormat = "hh";
    wrongFormat = "aa";
    hour = new HH12Hours();
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