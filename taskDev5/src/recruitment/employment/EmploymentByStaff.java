package recruitment.employment;

import java.util.*;
import recruitment.employees.*;

/**
 * Performs employment by staff.
 */
public class EmploymentByStaff extends Employment {
  private static final String ENTER_VALUE_MSG = "Enter productivity: ";
  private static final String UNUSELESS_QUALIFICATION = "Junior";

  /**
   * Performs employment with minimal number of employees higher than Junior for fixed productivity.
   *
   * @param productivity needed productivity.
   * @param employees - list of available employees.
   * @return employees.
   */
  public List<Employee> employ(int productivity, List<Employee> employees) {
    List<Employee> team = new ArrayList<>();
    List<Employee> bufferedTeam = new ArrayList<>();

    for (Employee employee : employees) {
      if (employee.getQualification().equals(UNUSELESS_QUALIFICATION)) {
        continue;
      } else {
        bufferedTeam.add(employee);
      }
    }

    for (Employee employee : bufferedTeam) {
      while (productivity - employee.getProductivity() >= 0) {
        team.add(employee);
        productivity -= employee.getProductivity();
      }

      if(bufferedTeam.indexOf(employee) == bufferedTeam.size() - 1 && productivity > 0) {
        team.add(employee);
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
