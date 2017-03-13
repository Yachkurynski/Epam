package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "H".
 */
public class H24HoursTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  H24Hours hour;

  @Before
  public void setUp() throws Exception {
    hour = new H24Hours();

    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 23, 7, 30);
    rightFormat = "H";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(rightFormat, calendar);
    assertEquals("23", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = hour.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}