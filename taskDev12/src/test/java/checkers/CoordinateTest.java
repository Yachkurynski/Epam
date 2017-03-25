package checkers;

import static org.junit.Assert.*;

import checkers.exceptions.InvalidCoordinateException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Павел on 25.03.2017.
 */
public class CoordinateTest {
  Coordinate firstCoordinate;
  Coordinate secondCoordinate;
  Coordinate thirdCoordinate;
  Coordinate testCoordinate;

  @Before
  public void setUp() throws Exception {
    firstCoordinate = new Coordinate("c", "1");
    secondCoordinate = new Coordinate("a", "7");
    thirdCoordinate = new Coordinate("a", "7");
  }

  @Test
  public void testPositiveIsEqual() throws Exception {
    assertTrue(secondCoordinate.isEqual(thirdCoordinate));
  }

  @Test
  public void testNegativeIsEqual() throws Exception {
    assertFalse(firstCoordinate.isEqual(secondCoordinate));
  }

  @Test
  public void testCreationCoordinateWithValidPosition() throws Exception {
    testCoordinate = new Coordinate("c", "3");
    assertEquals(3, testCoordinate.getxCoordinate());
    assertEquals(3, testCoordinate.getyCoordinate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreationXCoordinateOutOfBounds() throws Exception {
    testCoordinate = new Coordinate("m", "5");
  }

  @Test (expected = InvalidCoordinateException.class)
  public void testCreationYCoordinateOutOfBounds() throws Exception {
    testCoordinate = new Coordinate("c", "9");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreationXCoordinateAsNumber() throws Exception {
    testCoordinate = new Coordinate("3", "3");
  }

  @Test (expected = NumberFormatException.class)
  public void testCreationYCoordinateOutOfInteger() throws Exception {
    testCoordinate = new Coordinate("c", "3000000000");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreationXCoordinateAsSymbol() throws Exception {
    testCoordinate = new Coordinate("%", "3");
  }

  @Test (expected = NumberFormatException.class)
  public void testCreationYCoordinateAsSymbol() throws Exception {
    testCoordinate = new Coordinate("c", "#");
  }

  @Test (expected = InvalidCoordinateException.class)
  public void testCreationYCoordinateNegativeNumber() throws Exception {
    testCoordinate = new Coordinate("c", "-1");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreationEmptyXCoordinate() throws Exception {
    testCoordinate = new Coordinate("", "3");
  }

  @Test (expected = NumberFormatException.class)
  public void testCreationEmptyYCoordinate() throws Exception {
    testCoordinate = new Coordinate("c", "");
  }

  @Test (expected = InvalidCoordinateException.class)
  public void testCreationCoordinateOnTheWhitePosition() throws Exception {
    testCoordinate = new Coordinate("c", "2");
  }

  @Test (expected = NumberFormatException.class)
  public void testCreationCoordinateWithLetterYCoordinate() throws Exception {
    testCoordinate = new Coordinate("c", "c");
  }
}