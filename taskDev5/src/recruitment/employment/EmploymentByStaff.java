package recruitment.employment;

import java.util.*;
import recruitment.employees.*;

/**
 * Performs employment by staff.
 */
public class EmploymentByStaff extends Employment {
  private static final String ENTER_VALUE_MSG = "Enter productivity: ";
  private static final String USELESS_QUALIFICATION = "Junior";

  /**
   * Performs employment with minimal number of employees higher than Junior for fixed productivity.
   *
   * @param productivity needed productivity.
   * @param employees - list of available employees.
   * @return employees.
   */
  public List<Employee> employ(int productivity, List<Employee> employees) {
    List<Employee> team = new ArrayList<>();
    List<Employee> bufferedTeam = getListWithoutOneQualific(USELESS_QUALIFICATION, employees);

    for (Employee employee : bufferedTeam) {
      while (productivity - employee.getProductivity() >= 0) {
        team.add(employee);
        productivity -= employee.getProductivity();

        if (bufferedTeam.indexOf(employee) == 0) {
          Employee secondQualific = bufferedTeam.get(1);
          Employee thirdQualific = bufferedTeam.get(2);

          if (secondQualific.getProductivity()+ thirdQualific.getProductivity() == productivity) {
            team.add(secondQualific);
            team.add(thirdQualific);
            productivity -= (secondQualific.getProductivity()+ thirdQualific.getProductivity());
          }
        }
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

  /**
   * Returns list without one useless qualification.
   *
   * @param qualification - useless qualification
   * @param employees - list of all qualifications.
   * @return list without useless qualification.
   */
  public List<Employee> getListWithoutOneQualific(String qualification, List<Employee> employees) {
    List<Employee> bufferedTeam = new ArrayList<>();

    for (Employee employee : employees) {
      if (employee.getQualification().equals(qualification)) {
        continue;
      } else {
        bufferedTeam.add(employee);
      }
    }
    return bufferedTeam;
  }
}
