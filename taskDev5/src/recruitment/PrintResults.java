package recruitment;

import java.util.List;
import recruitment.employees.Employee;

/**
 * Prints results of calculations.
 */
public class PrintResults {

  /**
   * Prints selected in the parameters team.
   *
   * @param team selected team.
   */
  public void print(List<Employee> team) {
    if (team.size() == 0) {
      System.out.println("There is nobody matches your requirements");
    } else {
      for (Employee employee : team) {
        System.out.println(employee.toString());
      }
    }
  }
}
