package checkers;

import checkers.checkerFigures.BlackChecker;
import checkers.checkerFigures.CheckersFigure;
import checkers.checkerFigures.WhiteChecker;
import checkers.exceptions.ImpossibleMovementException;
import checkers.exceptions.InvalidColorException;

/**
 * Creates instance of class CheckerFigure.
 */
public class CheckerFigureBuilder {
  private static final String WHITE_CHECKERS_COLOR = "white";
  private static final String BLACK_CHECKERS_COLOR = "black";
  private CheckersFigure checker;

  /**
   * Returns instance of CheckerFigure which depends on given parameter color.
   *
   * @param color color of needed checker.
   * @param departure checker's departure point.
   * @param destination checker's destination point.
   * @return instance of checker (white or black).
   * @throws InvalidColorException when entered color doesn't match "white" or "black". Case
   * doesn't matter.
   * @throws ImpossibleMovementException when departure and destination points have a conflict.
   */
  public CheckersFigure buildChecker(String color, Coordinate departure, Coordinate destination)
      throws InvalidColorException, ImpossibleMovementException {
    if (color.toLowerCase().equals(WHITE_CHECKERS_COLOR)) {
      checker = new WhiteChecker(departure, destination);
    } else if (color.toLowerCase().equals(BLACK_CHECKERS_COLOR)) {
      checker = new BlackChecker(departure, destination);
    } else {
      throw new InvalidColorException("Unknown checker's color!");
    }
    return this.getChecker();
  }

  private CheckersFigure getChecker() {
    return checker;
  }
}
