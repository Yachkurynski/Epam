package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "f".
 */
public class FSplitSecondTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FSplitSecond();

    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "f";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar);
    assertEquals("3", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}