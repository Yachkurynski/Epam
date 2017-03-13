package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class DDayOfMonthTest {
  DDayOfMonth dayOfMonth;
  Calendar calendar;
  String rightFormat;
  String wrongFormat;

  @Before
  public void setUp() throws Exception {
    dayOfMonth = new DDayOfMonth();
    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 23, 7, 30);
    rightFormat = "d";
    wrongFormat = "dd";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = dayOfMonth.getFormatedDate(rightFormat, calendar);
    assertEquals("12", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = dayOfMonth.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }

}