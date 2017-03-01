package recruitment;

import java.util.*;
import recruitment.employees.*;
import recruitment.employment.*;

/**
 * Performs recruitment.
 */
public class Recruitment {
  /**
   * Performs recruitment by way which depends on entered parameter.
   *
   * @param number entered parameter
   * @return team match parameter
   */
  public Map<String, Integer> recruit(int number) {
    ConsoleReader reader = new ConsoleReader();
    List<Employment> employments = createListOfEmployments();
    List<Employee> employees = createListOfEmployees();

    List<Employee> bufferedTeam = employments.get(number - 1)
        .employ(reader.readValue(employments.get(number - 1).getMessage()), employees);

    Map<String, Integer> team = new HashMap<>();

    for (Employee person : bufferedTeam) {
      if (team.containsKey(person.getQualification())) {
        team.put(person.getQualification(), team.get(person.getQualification()) + 1);
      } else {
        team.put(person.getQualification(), 1);
      }
    }
    return team;
  }

  /**
   * Creates list of the employees.
   *
   * @return list of the employees.
   */
  private List<Employee> createListOfEmployees() {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Lead());
    employees.add(new Senior());
    employees.add(new Middle());
    employees.add(new Junior());

    List<Employee> sortedEmployees = sortEmployeesByPerformance(employees);
    return sortedEmployees;
  }

  /**
   * Creates list of the employments.
   *
   * @return list of the employments.
   */
  private List<Employment> createListOfEmployments() {
    List<Employment> employments = new ArrayList<>();

    employments.add(new EmploymentByProductivity());
    employments.add(new EmploymentByCost());
    employments.add(new EmploymentByStaff());
    return employments;
  }

  /**
   * Sorts the list of the employees by ratio salary/productivity.
   *
   * @param employees list which is need to sort.
   * @return sorted list.
   */
  public List<Employee> sortEmployeesByPerformance(List<Employee> employees) {
    Employee buffer;

    for (int i = 0; i < employees.size(); i++) {
      for (int j = employees.size() - 1; j > i; j--) {
        if (getPerformance(i, employees) > getPerformance(j, employees)) {
          buffer = employees.remove(j);
          employees.add(j - 1, employees.remove(i));
          employees.add(i, buffer);
        }
      }
    }
    return employees;
  }

  /**
   * Calculate the ratio salary/productivity.
   *
   * @param number number of the employee in the list.
   * @param employees list of the employees.
   * @return ratio salary/productivity.
   */
  public double getPerformance(int number, List<Employee> employees) {
    return (double) employees.get(number).getSalary() /
        (double) employees.get(number).getSalary();
  }
}
