package recruitment;

import java.util.*;
import recruitment.employees.Employee;

/**
 * Prints results of calculations.
 */
public class PrintResults {
  private static final String EMPTY_LIST_MSG = "There is nobody matches your requirements";
  /**
   * Prints selected in the parameters team.
   *
   * @param team selected team.
   */
  public void print(Map<String, Integer> team) {
    if (team.size() == 0) {
      System.out.println(EMPTY_LIST_MSG);
    } else {
      Set<String> keys = team.keySet();
      for (String key : keys) {
        System.out.println(key + " " + team.get(key).toString());
      }
    }
  }
}
