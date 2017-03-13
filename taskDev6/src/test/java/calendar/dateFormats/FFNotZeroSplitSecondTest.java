package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class FFNotZeroSplitSecondTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FFNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "FF";
    wrongFormat = "aa";
    millis = new FFNotZeroSplitSecond();
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