package checkers.checkerFigures;

import checkers.Coordinate;
import checkers.exceptions.ImpossibleMovementException;

/**
 * Describes white checker figure.
 */
public class WhiteChecker extends CheckersFigure {
  /**
   * Creates instance of white checker.
   * @param departureCoordinate current checker's position.
   * @param destinationCoordinate destination checker's point.
   * @throws ImpossibleMovementException when checker can't reach destination point.
   */
  public WhiteChecker(Coordinate departureCoordinate, Coordinate destinationCoordinate)
      throws ImpossibleMovementException {
    if (isPossibleMovement(departureCoordinate, destinationCoordinate)) {
      this.departureCoordinate = departureCoordinate;
      this.destinationCoordinate = destinationCoordinate;
    } else {
      throw new ImpossibleMovementException("Impossible movement! Wrong choice of coordinates.");
    }
  }

  /**
   * Performs movement to destination point.
   * @return number of steps from departure to destination point.
   */
  public int move() {
    int departXCoordinate = departureCoordinate.getxCoordinate();
    int departYCoordinate = departureCoordinate.getyCoordinate();
    int destinXCoordinate = destinationCoordinate.getxCoordinate();
    int destinYCoordinate = destinationCoordinate.getyCoordinate();
    int numberOfSteps = 0;

    if (departXCoordinate < destinXCoordinate) {
      while (!departureCoordinate.isEqual(destinationCoordinate)) {
        while (departXCoordinate + departYCoordinate != destinXCoordinate + destinYCoordinate) {
          goRight();
          numberOfSteps++;
          departXCoordinate = departureCoordinate.getxCoordinate();
          departYCoordinate = departureCoordinate.getyCoordinate();
        }
        goLeft();
        numberOfSteps++;
        departXCoordinate = departureCoordinate.getxCoordinate();
        departYCoordinate = departureCoordinate.getyCoordinate();
      }
    } else {
      while (!departureCoordinate.isEqual(destinationCoordinate)) {
        while (departXCoordinate - departYCoordinate != destinXCoordinate - destinYCoordinate) {
          goLeft();
          numberOfSteps++;
          departXCoordinate = departureCoordinate.getxCoordinate();
          departYCoordinate = departureCoordinate.getyCoordinate();
        }
        goRight();
        numberOfSteps++;
        departXCoordinate = departureCoordinate.getxCoordinate();
        departYCoordinate = departureCoordinate.getyCoordinate();
      }
    }
    return numberOfSteps;
  }

  /**
   * Performs movement forward and left on one position.
   */
  private void goLeft() {
    this.departureCoordinate.setxCoordinate((departureCoordinate.getxCoordinate()) - 1);
    this.departureCoordinate.setyCoordinate((departureCoordinate.getyCoordinate()) + 1);
  }

  /**
   * Performs movement forward and right on one position.
   */
  private void goRight() {
    this.departureCoordinate.setxCoordinate((departureCoordinate.getxCoordinate()) + 1);
    this.departureCoordinate.setyCoordinate((departureCoordinate.getyCoordinate()) + 1);
  }

  /**
   * Checks that checker can reach the destination point and that departure and destination points
   * are not same.
   *
   * @param departCoordinate departure checker's point.
   * @param destinCoordinate checker's destination point.
   * @return true if it's possible.
   */
  private boolean isPossibleMovement(Coordinate departCoordinate, Coordinate destinCoordinate) {
    int departXCoordinate = departCoordinate.getxCoordinate();
    int departYCoordinate = departCoordinate.getyCoordinate();
    int destinXCoordinate = destinCoordinate.getxCoordinate();
    int destinYCoordinate = destinCoordinate.getyCoordinate();

    if ((departXCoordinate - departYCoordinate < destinXCoordinate - destinYCoordinate) ||
        (departXCoordinate + departYCoordinate > destinXCoordinate + destinYCoordinate)) {
      return false;
    } else {
      return (!departCoordinate.isEqual(destinCoordinate));
    }
  }
}