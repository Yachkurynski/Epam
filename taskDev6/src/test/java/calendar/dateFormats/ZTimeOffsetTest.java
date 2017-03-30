package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "z".
 */
public class ZTimeOffsetTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  ZTimeOffset offset;

  @Before
  public void setUp() throws Exception {
    offset = new ZTimeOffset();

    calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
    rightFormat = "z";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = offset.getFormatedDate(rightFormat, calendar);
    assertEquals("3", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = offset.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}