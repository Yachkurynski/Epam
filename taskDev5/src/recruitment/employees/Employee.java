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
}
