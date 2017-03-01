package recruitment.employment;

import recruitment.employees.*;
import java.util.*;

/**
 * Performs employment by needed productivity.
 */
public class EmploymentByProductivity extends Employment {
  private static final String ENTER_VALUE_MSG = "Enter amount of money: ";

  /**
   * Performs employment by maximal productivity for fixed amount of money.
   *
   * @param amountOfMoney given amount of money.
   * @param employees - list of available employees.
   * @return employees.
   */
  public List<Employee> employ(int amountOfMoney, List<Employee> employees) {
    List<Employee> team = new ArrayList<>();

    for (Employee employee : employees) {
      while (amountOfMoney - employee.getSalary() >= 0) {
        team.add(employee);
        amountOfMoney -= employee.getSalary();
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
