package checkers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CheckersTest {
  Checkers checker1;
  Checkers checker2;
  Checkers checker3;
  Checkers checker4;
  Checkers checker5;
  Checkers checker6;

  @Before
  public void setUp() throws Exception {
    checker1 = new Checkers("c1", "white");
    checker2 = new Checkers("c1", "white");
    checker3 = new Checkers("d8", "black");
    checker4 = new Checkers("d8", "black");
    checker5 = new Checkers("b2", "white");
    checker6 = new Checkers("b2", "white");
  }

  @Test
  public void testGoLeftWhite() throws Exception {
    checker1.goLeft();
    String actual = String.valueOf(Checkers.Positions.values()[checker1.getPositionX() - 1]) +
        checker1.getPositionY();
    assertEquals("b2", actual);
  }

  @Test
  public void testGoLeftBlack() throws Exception {
    checker3.goLeft();
    String actual = String.valueOf(Checkers.Positions.values()[checker3.getPositionX() - 1]) +
        checker3.getPositionY();
    assertEquals("c7", actual);
  }

  @Test
  public void testGoRightWhite() throws Exception {
    checker2.goRight();
    String actual = String.valueOf(Checkers.Positions.values()[checker2.getPositionX() - 1]) +
        checker2.getPositionY();
    assertEquals("d2", actual);
  }

  @Test
  public void testGoRightBlack() throws Exception {
    checker4.goRight();
    String actual = String.valueOf(Checkers.Positions.values()[checker4.getPositionX() - 1]) +
        checker4.getPositionY();
    assertEquals("e7", actual);
  }

  @Test
  public void testAreSamePositive() throws Exception {
    assertTrue(checker5.areSame(checker6));
  }

  @Test
  public void testAreSameNegative() throws Exception {
    assertFalse(checker1.areSame(checker3));
  }
}