package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class THalfOfTheDayTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  THalfOfTheDay halfOfTheDay;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(2017, 2, 12, 21, 7, 30);
    rightFormat = "t";
    wrongFormat = "aa";
    halfOfTheDay = new THalfOfTheDay();
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = halfOfTheDay.getFormatedDate(rightFormat, calendar);
    assertEquals("P", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = halfOfTheDay.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}