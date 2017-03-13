package calendar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class DateGetterTest {
  DateGetter getter;

  @Before
  public void setUp() throws Exception {
    getter = new DateGetter();
  }

  @Test
  public void getCurrentTime() throws Exception {
    assertNotNull(getter.getCurrentTime());
  }

}