package checkers.exceptions;

/**
 * Occurs when entered coordinates are out of chessboard's bounds.
 */
public class InvalidCoordinateException extends Exception {
  /**
   * Creates instance of exception.
   * @param message message which describes problem.
   */
  public InvalidCoordinateException(String message) {
    super(message);
  }
}
