package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class FFFNotZeroSplitSecondTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FFFNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "FFF";
    wrongFormat = "aa";
    millis = new FFFNotZeroSplitSecond();
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar);
    assertEquals("300", actual);
  }

  @Test
    public void testNegativeGetFormatedDate() throws Exception {
      String actual = millis.getFormatedDate(wrongFormat, calendar);
      assertEquals(wrongFormat, actual);
    }

}