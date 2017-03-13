package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "FF".
 */
public class FFNotZeroSplitSecondTest {
  Calendar calendar1;
  Calendar calendar2;
  String rightFormat;
  String wrongFormat;
  FFNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FFNotZeroSplitSecond();

    calendar1 = Calendar.getInstance();
    calendar2 = Calendar.getInstance();
    calendar1.set(Calendar.MILLISECOND, 300);
    calendar2.set(Calendar.MILLISECOND, 0);
    rightFormat = "FF";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar1);
    assertEquals("30", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(wrongFormat, calendar1);
    assertEquals(wrongFormat, actual);
  }

  @Test
  public void testNegativeGetFormatedDateWithZeroMillis() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar2);
    assertEquals("", actual);
  }
}