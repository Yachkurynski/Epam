package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for date format "F".
 */
public class FNotZeroSplitSecondTest {
  Calendar calendar1;
  Calendar calendar2;
  String rightFormat;
  String wrongFormat;
  FNotZeroSplitSecond millis;

  @Before
  public void setUp() throws Exception {
    millis = new FNotZeroSplitSecond();

    calendar1 = Calendar.getInstance();
    calendar2 = Calendar.getInstance();
    calendar1.set(Calendar.MILLISECOND, 300);
    calendar2.set(Calendar.MILLISECOND, 0);
    rightFormat = "F";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = millis.getFormatedDate(rightFormat, calendar1);
    assertEquals("3", actual);
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