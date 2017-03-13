package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class FNotZeroSplitSecondTest {
  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "F";
    wrongFormat = "aa";
    millis = new FNotZeroSplitSecond();
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