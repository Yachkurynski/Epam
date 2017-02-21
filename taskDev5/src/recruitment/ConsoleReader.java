package recruitment;

import java.io.*;

/**
 * Read data from console.
 */
public class ConsoleReader {
  private static final String FIRST_WAY_OF_RECRUITMENT =
      "1. Maximal productivity for this amount of money.\n";
  private static final String SECOND_WAY_OF_RECRUITMENT =
      "2. Minimal cost for fixed productivity.\n";
  private static final String THIRD_WAY_OF_RECRUITMENT =
      "3. Minimal number of employees higher than Junior for fixed productivity.";
  private static final String INCORRECT_ENTER_MSG = "Please, enter only 1, 2 or 3.";
  private static final String CHOOSE_ASK = "Choose the way of recruitment:\n";

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
      System.out.println(CHOOSE_ASK + FIRST_WAY_OF_RECRUITMENT + SECOND_WAY_OF_RECRUITMENT
          + THIRD_WAY_OF_RECRUITMENT);

      try {
        answer = Integer.parseInt(reader.readLine());
      } catch (NumberFormatException ex) {
        System.out.println(INCORRECT_ENTER_MSG);
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
