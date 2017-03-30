package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "FFF".
 */
public class FFFNotZeroSplitSecondTest {
  Calendar calendar1;
  Calendar calendar2;
  String rightFormat;
  String wrongFormat;
  FFFNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FFFNotZeroSplitSecond();

    calendar1 = Calendar.getInstance();
    calendar2 = Calendar.getInstance();
    calendar1.set(Calendar.MILLISECOND, 300);
    calendar2.set(Calendar.MILLISECOND, 0);
    rightFormat = "FFF";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar1);
    assertEquals("300", actual);
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