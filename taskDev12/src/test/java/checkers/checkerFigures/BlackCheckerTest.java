package checkers.checkerFigures;

import static org.junit.Assert.*;

import checkers.Coordinate;
import checkers.exceptions.ImpossibleMovementException;
import org.junit.Before;
import org.junit.Test;

public class BlackCheckerTest {
  Coordinate departureCoordinate;
  Coordinate destinationRightCoordinate;
  Coordinate destinationWrongCoordinate;
  CheckersFigure checker;
  CheckersFigure wrongChecker;

  @Before
  public void setUp() throws Exception {
    departureCoordinate = new Coordinate("c", "7");
    destinationRightCoordinate = new Coordinate("a", "1");
    destinationWrongCoordinate = new Coordinate("g", "7");
    checker = new BlackChecker(departureCoordinate, destinationRightCoordinate);
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationCheckerWithUnreachableDestinationPoint() throws Exception {
    wrongChecker = new BlackChecker(departureCoordinate, destinationWrongCoordinate);
  }

  @Test
  public void testMovement() throws Exception {
    int actualNumberOfSteps = checker.move();
    int expectedNumberOfSteps = 6;

    assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
  }
}