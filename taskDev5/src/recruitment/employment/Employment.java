package recruitment.employment;

import recruitment.employees.*;
import java.util.*;

/**
 * Basic class for the ways of employment.
 */
public abstract class Employment {

  /**
   * Performs employment which depends on realisation.
   *
   * @param someValue entered value which depends of the way of the employment.
   * @param employees - list of available employees.
   * @return employees.
   */
  public abstract List<Employee> employ(int someValue, List<Employee> employees);

  /**
   * Returns hint message which depends on the way of employment.
   *
   * @return message.
   */
  public abstract String getMessage();
}
