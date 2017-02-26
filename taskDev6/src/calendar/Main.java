package calendar;

/**
 * Prints current time according to entered format.
 */
public class Main {

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    ConsoleReader reader = new ConsoleReader();
    CurrentTime currentTime = new CurrentTime();

    String[] format = reader.readFromConsole();
    String curTime = currentTime.getCurrentTime(format);
    System.out.println(curTime);
  }
}
