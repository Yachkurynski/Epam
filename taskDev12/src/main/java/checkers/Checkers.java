package checkers;

import static java.lang.String.valueOf;

import java.util.Scanner;

/**
 * Describes checker.
 */
public class Checkers {
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
    int x = Positions.valueOf(String.valueOf(position.charAt(0)).toLowerCase()).ordinal() + 1;
    int y = Integer.parseInt(String.valueOf(position.charAt(1)));

    if (isValidPosition(x, y) && isValidColor(color)) {
      this.positionX = x;
      this.positionY = y;
      this.color = color;
    } else {
      throw new IllegalArgumentException("Invalid position " + position);
    }
  }

  /**
   * Moves forward and left. Depends on checker's color.
   */
  public void goLeft() {
    positionX--;

    if(color.equals("white")) {
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

    if(color.equals("white")) {
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
    return color.toLowerCase().equals("black") || color.toLowerCase().equals("white");
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

    if ((xPosition > 9 || xPosition < 0) || (yPosition > 9 || yPosition < 0)) {
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
