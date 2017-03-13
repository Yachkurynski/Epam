package calendar.dateFormats;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class GGEraTest {
  GGEra era;
  Calendar calendar;
  String rightFormat;
  String wrongFormat;

  @Before
  public void setUp() throws Exception {
    era = new GGEra();
    calendar = Calendar.getInstance();
    calendar.set(2017, 3, 12, 23, 7, 30);
    rightFormat = "gg";
    wrongFormat = "aa";
  }

  @Test
  public void testPositiveGetFormatedDate() throws Exception {
    String actual = era.getFormatedDate(rightFormat, calendar);
    assertEquals("AD", actual);
  }

  @Test
  public void testNegativeGetFormatedDate() throws Exception {
    String actual = era.getFormatedDate(wrongFormat, calendar);
    assertEquals(wrongFormat, actual);
  }
}