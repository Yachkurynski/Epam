package recruitment.employment;

import java.util.*;
import recruitment.employees.Employee;

/**
 * Performs employment by the cost.
 */
public class EmploymentByCost extends Employment {
  private static final String ENTER_VALUE_MSG = "Enter productivity: ";

  /**
   * Performs employment by minimal cost for fixed productivity.
   *
   * @param productivity needed productivity.
   * @param employees - list of available employees.
   * @return employees.
   */
  public List<Employee> employ(int productivity, List<Employee> employees) {
    List<Employee> team = new ArrayList<>();

    for (Employee employee : employees) {
      while (productivity - employee.getProductivity() >= 0) {
        team.add(employee);
        productivity -= employee.getProductivity();
      }
    }
    return team;
  }

  /**
   * Returns help message.
   *
   * @return message.
   */
  public String getMessage() {
    return ENTER_VALUE_MSG;
  }
}
