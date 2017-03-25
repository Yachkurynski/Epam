package checkers.checkerFigures;

import static org.junit.Assert.*;

import checkers.Coordinate;
import checkers.exceptions.ImpossibleMovementException;
import org.junit.Before;
import org.junit.Test;

public class WhiteCheckerTest {
  Coordinate departureCoordinate;
  Coordinate destinationRightCoordinate;
  Coordinate destinationWrongCoordinate;
  CheckersFigure checker;
  CheckersFigure wrongChecker;

  @Before
  public void setUp() throws Exception {
    departureCoordinate = new Coordinate("c", "1");
    destinationRightCoordinate = new Coordinate("b", "4");
    destinationWrongCoordinate = new Coordinate("e", "1");
    checker = new WhiteChecker(departureCoordinate, destinationRightCoordinate);
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationCheckerWithUnreachableDestinationPoint() throws Exception {
    wrongChecker = new WhiteChecker(departureCoordinate, destinationWrongCoordinate);
  }

  @Test
  public void testMovement() throws Exception {
    int expectedNumberOfSteps = 3;
    int actualNumberOfSteps = checker.move();

    assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
  }
}