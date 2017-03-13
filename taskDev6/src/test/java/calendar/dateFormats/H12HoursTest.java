package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "h".
 */
public class H12HoursTest {
  H12Hours hour;
  Calendar calendar;
  String rightFormat;
  String wrongFormat;

  @Before
  public void setUp() throws Exception {
    hour = new H12Hours();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 23, 7, 30);
    rightFormat = "h";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(rightFormat, calendar);
    assertEquals("11", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}