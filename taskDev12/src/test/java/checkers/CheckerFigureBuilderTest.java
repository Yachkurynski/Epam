package checkers;

import static org.junit.Assert.*;

import checkers.checkerFigures.CheckersFigure;
import checkers.exceptions.ImpossibleMovementException;
import checkers.exceptions.InvalidColorException;
import org.junit.Before;
import org.junit.Test;

public class CheckerFigureBuilderTest {
  Coordinate firstCoordinate;
  Coordinate secondCoordinate;
  Coordinate unreachableCoordinate;
  String blackColor;
  String whiteColor;
  String unknownColor;
  String justSymbols;
  CheckersFigure checker;
  CheckersFigure wrongChecker;
  CheckerFigureBuilder builder;

  @Before
  public void setUp() throws Exception {
    builder = new CheckerFigureBuilder();
    firstCoordinate = new Coordinate("c", "1");
    secondCoordinate = new Coordinate("c", "5");
    unreachableCoordinate = new Coordinate("g", "3");

    blackColor = "black";
    whiteColor = "white";
    unknownColor = "green";
    justSymbols = "&^%)";
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationWhiteCheckerWithUnreachableCoordinate() throws Exception {
    checker = builder.buildChecker(whiteColor, firstCoordinate, unreachableCoordinate);
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationBlackCheckerWithUnreachableCoordinate() throws Exception {
    checker = builder.buildChecker(blackColor, secondCoordinate, unreachableCoordinate);
  }

  @Test (expected = InvalidColorException.class)
  public void testCreationCheckerWithUnknownColor() throws Exception {
    checker = builder.buildChecker(unknownColor, firstCoordinate, secondCoordinate);
  }

  @Test (expected = InvalidColorException.class)
  public void testCreationCheckerWithInvalidColor() throws Exception {
    checker = builder.buildChecker(justSymbols, firstCoordinate, secondCoordinate);
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationCheckerWithSameCoordinatesWHite() throws Exception {
    checker = builder.buildChecker(whiteColor, firstCoordinate, firstCoordinate);
  }

  @Test (expected = ImpossibleMovementException.class)
  public void testCreationCheckerWithSameCoordinatesBlack() throws Exception {
    checker = builder.buildChecker(blackColor, secondCoordinate, secondCoordinate);
  }
}