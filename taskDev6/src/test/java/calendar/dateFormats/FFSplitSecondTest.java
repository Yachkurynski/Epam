package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "ff".
 */
public class FFSplitSecondTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FFSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FFSplitSecond();

    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "ff";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar);
    assertEquals("30", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}