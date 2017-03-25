package checkers;

import checkers.exceptions.InvalidCoordinateException;

/**
 * Describes coordinates ob chessboard.
 */
public class Coordinate {
  private static final int MAX_DESK_BOUND = 8;
  private static final int MIN_DESK_BOUND = 1;
  private int xCoordinate;
  private int yCoordinate;

  /**
   * Creates instance of coordinate.
   *
   * @param xCoordinate x position on the chessboard.
   * @param yCoordinate y position on the chessboard.
   * @throws InvalidCoordinateException when position doesn't exist on the chessboard or if it
   * matches white position.
   * @throws IllegalArgumentException when entered x-coordinate is not contained in enum Positions.
   */
  public Coordinate(String xCoordinate, String yCoordinate) throws InvalidCoordinateException,
      IllegalArgumentException {
    int x = Positions.valueOf(String.valueOf(xCoordinate).toLowerCase()).ordinal() + 1;
    int y = Integer.parseInt(String.valueOf(yCoordinate));

    if(isValidPosition(x, y)) {
      this.xCoordinate = x;
      this.yCoordinate = y;
    } else {
      throw new InvalidCoordinateException("Invalid coordinate: " + xCoordinate + yCoordinate);
    }
  }

  /**
   * Enumeration of positions by x-scale.
   */
  public enum Positions {
    a, b, c, d, e, f, g, h
  }

  /**
   * Checks that current coordinate is equal to given coordinate.
   *
   * @param otherCoordinate other coordinate for checking.
   * @return true if they are same.
   */
  public boolean isEqual(Coordinate otherCoordinate) {
    return (this.getxCoordinate() == otherCoordinate.getxCoordinate()) &&
        (this.getyCoordinate() == otherCoordinate.getyCoordinate());
  }

/**
 * Checks that position is valid (not white position and not out of chessboard's bounds).
 *
 * @param xPosition x-coordinate.
 * @param yPosition y-coordinate.
 * @return true if position is valid.
 */
  private boolean isValidPosition(int xPosition, int yPosition) {
    if ((xPosition > MAX_DESK_BOUND || xPosition < MIN_DESK_BOUND) ||
        (yPosition > MAX_DESK_BOUND || yPosition < MIN_DESK_BOUND)) {
      return false;
    } else {
      return ((xPosition + yPosition) % 2 == 0);
    }
  }

  public int getxCoordinate() {
    return xCoordinate;
  }

  public int getyCoordinate() {
    return yCoordinate;
  }

  public void setxCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public void setyCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }
}
