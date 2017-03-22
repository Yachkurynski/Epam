package checkers;

/**
 * Calculate number of steps for checker from departure point to destination point.
 */
public class Main {
  private static final String ENTER_DEPARTURE_POINT_ASK = "Enter departure position: ";
  private static final String ENTER_DESTINATION__POINT_ASK = "Enter destination position: ";
  private static final String ENTER_CHECKERS_COLOR_ASK = "Enter checker's color: ";
  private static final String NUMBER_OF_STEPS_MSG = "Number of steps = ";

  /**
   * Entry point to the program.
   * @param args are not used.
   */
  public static void main(String[] args) {
    CheckersMovement movement = new CheckersMovement();
    ConsoleReader reader = new ConsoleReader();

    boolean needToRepeat = true;
    int numberOfRepeats = 0;

    do {
      try {
        String departurePosition = reader.readFromConsole(ENTER_DEPARTURE_POINT_ASK);
        String destinationPosition = reader.readFromConsole(ENTER_DESTINATION__POINT_ASK);
        String checkerColor = reader.readFromConsole(ENTER_CHECKERS_COLOR_ASK);

        System.out.println(NUMBER_OF_STEPS_MSG + movement.move(new Checkers(departurePosition, checkerColor),
            new Checkers(destinationPosition, checkerColor)));
        needToRepeat = false;
      } catch (NumberFormatException ex) {
        System.out.println(ex.getLocalizedMessage());
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getLocalizedMessage());
      }
    } while (needToRepeat && reader.isNeedToRepeatEnter(numberOfRepeats++));
  }
}
