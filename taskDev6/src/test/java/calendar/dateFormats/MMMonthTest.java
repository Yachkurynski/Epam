package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "MM".
 */
public class MMMonthTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  MMMonth month;

  @Before
  public void setUp() throws Exception {
    month = new MMMonth();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "MM";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(rightFormat, calendar);
    assertEquals("03", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = month.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}