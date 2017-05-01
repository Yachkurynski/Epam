package checkers;


import checkers.checkerFigures.CheckersFigure;
import checkers.exceptions.ImpossibleMovementException;
import checkers.exceptions.InvalidColorException;
import checkers.exceptions.InvalidCoordinateException;
import java.io.IOException;

/**
 * Calculate number of steps for checker from departure point to destination point.
 */
public class Main {
  private static final int MAX_NUMBER_OF_REPEATS = 5;
  private static final String ENTER_DEPARTURE_X_COORDINATE_ASK = "Enter departure x coordinate:";
  private static final String ENTER_DEPARTURE_Y_COORDINATE_ASK = "Enter departure y coordinate:";
  private static final String ENTER_DESTINATION_X_COORDINATE_ASK = "Enter destination x "
      + "coordinate:";
  private static final String ENTER_DESTINATION_Y_COORDINATE_ASK = "Enter destination y "
      + "coordinate:";
  private static final String ENTER_CHECKERS_COLOR_ASK = "Enter checker's color: ";
  private static final String NUMBER_OF_STEPS_MSG = "Number of steps = ";

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();
    CheckerFigureBuilder builder = new CheckerFigureBuilder();
    int numberOfRepeats = 0;

    do {
      try {
        String departureXCoordinate = reader.readFromConsole(ENTER_DEPARTURE_X_COORDINATE_ASK);
        String departureYCoordinate = reader.readFromConsole(ENTER_DEPARTURE_Y_COORDINATE_ASK);
        String destinationXCoordinate = reader.readFromConsole(ENTER_DESTINATION_X_COORDINATE_ASK);
        String destinationYCoordinate = reader.readFromConsole(ENTER_DESTINATION_Y_COORDINATE_ASK);
        String color = reader.readFromConsole(ENTER_CHECKERS_COLOR_ASK);

        Coordinate departureCoordinate = new Coordinate(departureXCoordinate, departureYCoordinate);
        Coordinate destinationCoordinate = new Coordinate(destinationXCoordinate,
            destinationYCoordinate);
        CheckersFigure checker = builder.buildChecker(color, departureCoordinate,
            destinationCoordinate);

        int numberOfSteps = checker.move();
        System.out.println(NUMBER_OF_STEPS_MSG + numberOfSteps);
        break;
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (InvalidColorException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (ImpossibleMovementException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (InvalidCoordinateException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (NumberFormatException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (Exception ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (numberOfRepeats++ <= MAX_NUMBER_OF_REPEATS);
  }
}