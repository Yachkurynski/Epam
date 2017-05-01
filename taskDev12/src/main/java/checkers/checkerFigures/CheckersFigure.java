package checkers.checkerFigures;

import checkers.Coordinate;

/**
 * Parent class for checkers (figures).
 */
public  abstract class CheckersFigure {
  protected Coordinate departureCoordinate;
  protected Coordinate destinationCoordinate;

  /**
   * Performs movement to destination point.
   * @return number of steps from departure to destination point.
   */
 public abstract int move();

  public Coordinate getDepartureCoordinate() {
    return departureCoordinate;
  }

  public Coordinate getDestinationCoordinate() {
    return destinationCoordinate;
  }

  public void setDepartureCoordinate(Coordinate departureCoordinate) {
    this.departureCoordinate = departureCoordinate;
  }

  public void setDestinationCoordinate(Coordinate destinationCoordinate) {
    this.destinationCoordinate = destinationCoordinate;
  }
}
