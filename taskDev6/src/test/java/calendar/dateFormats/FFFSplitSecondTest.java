package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "fff".
 */
public class FFFSplitSecondTest {

  Calendar calendar;
  String rightFormat;
  String wrongFormat;
  FFFSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FFFSplitSecond();

    calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, 300);
    rightFormat = "fff";
    wrongFormat = "aa";
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