package checkers.exceptions;

/**
 * Occurs when checker can't reach destination point.
 */
public class ImpossibleMovementException extends Exception {
  /**
   * Creates instance of exception.
   * @param message message which describes problem.
   */
  public ImpossibleMovementException(String message) {
    super(message);
  }
}
