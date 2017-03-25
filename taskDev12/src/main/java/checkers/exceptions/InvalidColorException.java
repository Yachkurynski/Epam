package checkers.exceptions;

/**
 * Occurs when entered color doesn't match "white" or "black". Case doesn't matter.
 */
public class InvalidColorException extends Exception {

  /**
   * Creates instance of exception.
   * @param message message which describes problem.
   */
  public InvalidColorException(String message) {
    super(message);
  }
}
