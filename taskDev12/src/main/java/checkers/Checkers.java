package checkers;

import static java.lang.String.valueOf;

import java.util.Scanner;

/**
 * Describes checker.
 */
public class Checkers {
  private static final int X_POSITION = 0;
  private static final int Y_POSITION = 1;
  private static final int MAX_DESK_BOUND = 8;
  private static final int MIN_DESK_BOUND = 1;
  private static final String WHITE = "white";
  private static final String BLACK = "black";
  private static final String INVALID_POSITION_MSG = "Invalid position ";

  private int positionX;
  private int positionY;
  private String color;

  /**
   * Enumeration of positions by y-scale.
   */
  public enum Positions {
    a, b, c, d, e, f, g, h
  }

  /**
   * Creates instance of checker.
   * @param position checker's position on the chessboard.
   * @param color checker's color.
   * @throws IllegalArgumentException when position has invalid value or given color is illegal.
   */
  public Checkers(String position, String color) throws IllegalArgumentException {
    int x = Positions.valueOf(String.valueOf(position.charAt(X_POSITION)).toLowerCase()).ordinal()
        + 1;
    int y = Integer.parseInt(String.valueOf(position.charAt(Y_POSITION)));

    if (isValidPosition(x, y) && isValidColor(color)) {
      this.positionX = x;
      this.positionY = y;
      this.color = color;
    } else {
      throw new IllegalArgumentException(INVALID_POSITION_MSG + position);
    }
  }

  /**
   * Moves forward and left. Depends on checker's color.
   */
  public void goLeft() {
    positionX--;

    if(color.equals(WHITE)) {
      positionY++;
    } else {
      positionY--;
    }
  }

  /**
   * Moves forward and right. Depends on checker's color.
   */
  public void goRight() {
    positionX++;

    if(color.equals(WHITE)) {
      positionY++;
    } else {
      positionY--;
    }
  }

  /**
   * Checks that position of checker coincides with given position as other checker.
   * @param checkers some position for comparing with current checker's position.
   * @return true if positions are same.
   */
  public boolean areSame(Checkers checkers) {
    return this.positionY == checkers.getPositionY() && this.positionX == checkers.getPositionX();
  }

  /**
   * Checks that given color is valid (
   * @param color color for checking.
   * @return true if color is valid.
   */
  private boolean isValidColor(String color) {
    return color.toLowerCase().equals(BLACK) || color.toLowerCase().equals(WHITE);
  }

  /**
   * Checks that checker's position is valid (not white position and not out of
   * chessboard's bounds).
   *
   * @param xPosition x-coordinate of checker.
   * @param yPosition y-coordinate of checker.
   * @return true if position is valid.
   */
  private boolean isValidPosition(int xPosition, int yPosition) {
    boolean valueToReturn = true;

    if ((xPosition >= MAX_DESK_BOUND || xPosition <= MIN_DESK_BOUND) ||
        (yPosition >= MAX_DESK_BOUND || yPosition <= MIN_DESK_BOUND)) {
      valueToReturn = false;
    } else {
      if ((xPosition + yPosition) % 2 != 0) {
        valueToReturn = false;
      }
    }
    return valueToReturn;
  }

  public int getPositionX() {
    return positionX;
  }

  public String getColor() {
    return color;
  }

  public int getPositionY() {
    return positionY;
  }
}
