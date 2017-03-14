package checkers;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CheckersMovementTest {
  Checkers checkerDestination1;
  Checkers checkerDestination2;
  Checkers checkerDestination3;
  Checkers checkerDestination4;
  Checkers checkerDeparture1;
  Checkers checkerDeparture2;
  CheckersMovement movement;

  @Before
  public void setUp() throws Exception {
    movement = new CheckersMovement();
    checkerDeparture1 = new Checkers("c3", "white");
    checkerDeparture2 = new Checkers("d6", "black");
    checkerDestination1 = new Checkers("a7", "white");
    checkerDestination2 = new Checkers("f4", "white");
    checkerDestination3 = new Checkers("e1", "black");
    checkerDestination4 = new Checkers("a7", "black");
  }

  @Test
  public void testPositiveMovementForWhite() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture1, checkerDestination1);
    assertEquals(4, numberOfSteps);
  }

  @Test
  public void testPositiveMovementForBlack() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture2, checkerDestination3);
    assertEquals(5, numberOfSteps);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeMovementForWhite() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture1, checkerDestination2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeMovementForBlack() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture2, checkerDestination4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMovementFromWhiteToBlack() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture1, checkerDestination4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMovementFromBlackToWhite() throws Exception {
    int numberOfSteps = movement.move(checkerDeparture2, checkerDestination2);
  }
}