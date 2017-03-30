package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "tt".
 */
public class TTHalfOfTheDayTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  TTHalfOfTheDay halfOfTheDay;

  @Before
  public void setUp() throws Exception {
    halfOfTheDay = new TTHalfOfTheDay();

    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "tt";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = halfOfTheDay.getFormatedDate(rightFormat, calendar);
    assertEquals("PM", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = halfOfTheDay.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}