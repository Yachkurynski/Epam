package recruitment.employees;

/**
 * Basic class for Employees.
 */
public class Employee {
  protected int salary;
  protected int productivity;
  protected String qualification;

  public int getSalary(){
    return this.salary;
  }

  public int getProductivity(){
    return this.productivity;
  }

  public String getQualification() {
    return this.qualification;
  }

  /**
   * Returns string representation of the employees' information.
   *
   * @return string representation of the object.
   */
  @Override
  public String toString() {
    String personInformaion = this.getQualification()
        + ", Salary: " + this.getSalary()
        + ", Productivity: " + this.getProductivity();
    return personInformaion;
  }
}
