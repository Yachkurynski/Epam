package recruitment;

import java.io.*;

/**
 * Read data from console.
 */
public class ConsoleReader {

  /**
   * Ask user to choose the way of recruitment.
   *
   * @return number of the way.
   */
  public int readWayOfRecruitment() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean incorrectAnswer = true;
    int answer = 0;

    do {
      System.out.println("Choose: ");
      System.out.println("1. Maximal productivity for this amount of money.");
      System.out.println("2. Minimal cost for fixed productivity.");
      System.out
          .println("3. Minimal number of employees higher than Junior for fixed productivity");

      try {
        answer = Integer.parseInt(reader.readLine());
      } catch (NumberFormatException ex) {
        System.out.println("Please, enter only 1, 2 or 3.");
        continue;
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
      }

      if (answer > 0 && answer < 4) {
        incorrectAnswer = false;
      }
    } while (incorrectAnswer);
    return answer;
  }

  /**
   * Read value from console.
   *
   * @param message prints before reading the value
   * @return value
   */
  public int readValue(String message) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int value = 0;
    boolean incorrectAnswer = false;

    do {
      System.out.println(message);

      try {
        value = Integer.parseInt(reader.readLine());
        incorrectAnswer = false;
      } catch (NumberFormatException ex) {
        System.out.println(ex.getLocalizedMessage());
        incorrectAnswer = true;
      } catch (IOException ex) {
        System.out.println(ex.getLocalizedMessage());
        incorrectAnswer = true;
      }
    } while (incorrectAnswer);
    return value;
  }
}
