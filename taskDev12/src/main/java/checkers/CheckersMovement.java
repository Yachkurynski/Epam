package checkers;

/**
 * Describes checker's movement.
 */
public class CheckersMovement {

  /**
   * Performs checker's movement.
   *
   * @param ch1 departure point as instant of first checker.
   * @param ch2 destination point as instant of other checker.
   * @return number of steps from departure to destination point.
   * @throws IllegalArgumentException if checker can't reach the destination point.
   */
  public int move(Checkers ch1, Checkers ch2) throws IllegalArgumentException {
    if (!isValid(ch1, ch2)) {
      throw new IllegalArgumentException("It's impossible! Choose other points. \n");
    }

    if (ch1.getColor().equals("white")) {
      return goWhite(ch1, ch2);
    } else {
      return goBlack(ch1, ch2);
    }
  }

  /**
   * Checks that checker can reach the destination point.
   *
   * @param ch1 departure point as instant of first checker.
   * @param ch2 destination point as instant of other checker.
   * @return true if it's possible.
   */
  private boolean isValid(Checkers ch1, Checkers ch2) {
    boolean isValid = true;

    if (!ch1.getColor().equals(ch2.getColor())) {
      isValid = false;
    }

    if (ch1.getColor().equals("white")) {
      if ((ch1.getPositionX() - ch1.getPositionY() < ch2.getPositionX() - ch2.getPositionY()) ||
          (ch1.getPositionX() + ch1.getPositionY() > ch2.getPositionX() + ch2.getPositionY())){
        isValid = false;
      }
    } else {
      if ((ch1.getPositionX() - ch1.getPositionY() > ch2.getPositionX() - ch2.getPositionY()) ||
          (ch1.getPositionX() + ch1.getPositionY() < ch2.getPositionX() + ch2.getPositionY())){
        isValid = false;
      }
    }
    return isValid;
  }

  /**
   * Performs movement for white checker.
   *
   * @param ch1 departure point as instant of first checker.
   * @param ch2 destination point as instant of other checker.
   * @return number of performed steps.
   */
  private int goWhite(Checkers ch1, Checkers ch2) {
    int steps = 0;

    if (ch1.getPositionX() < ch2.getPositionX()) {
      while (!ch1.areSame(ch2)) {
        while (ch1.getPositionX() + ch1.getPositionY() != ch2.getPositionX() + ch2.getPositionY()) {
          ch1.goRight();
          steps++;
        }
        ch1.goLeft();
        steps++;
      }
    } else {
      while (!ch1.areSame(ch2)) {
        while (ch1.getPositionX() - ch1.getPositionY() != ch2.getPositionX() - ch2.getPositionY()) {
          ch1.goLeft();
          steps++;
        }
        ch1.goRight();
        steps++;
      }
    }
    return steps;
  }

  /**
   * Performs movement for black checker.
   *
   * @param ch1 departure point as instant of first checker.
   * @param ch2 destination point as instant of other checker.
   * @return number of performed steps.
   */
  private int goBlack(Checkers ch1, Checkers ch2) {
    int steps = 0;

    if (ch1.getPositionX() < ch2.getPositionX()) {
      while (!ch1.areSame(ch2)) {
        while (ch1.getPositionX() - ch1.getPositionY() != ch2.getPositionX() - ch2.getPositionY()) {
          ch1.goRight();
          steps++;
        }
        ch1.goLeft();
        steps++;
      }
    } else {
      while (!ch1.areSame(ch2)) {
        while (ch1.getPositionX() + ch1.getPositionY() != ch2.getPositionX() + ch2.getPositionY()) {
          ch1.goLeft();
          steps++;
        }
        ch1.goRight();
        steps++;
      }
    }
    return steps;
  }
}
