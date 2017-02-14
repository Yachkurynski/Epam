package taskDev3.peopleData;

/**
 * Describes any person.
 */
public class People {
  private String surname;
  private String name;
  private String sex;
  private int age;
  
  /**
   * Create a person.
   * 
   * @param surname - person's surname.
   * @param name - person's name.
   * @param sex - person's sex.
   * @param age - person's age.
   */
  public People(String surname, String name, String sex, int age) {
    this.surname = surname;
    this.name = name;
    this.sex = sex;
    this.age = age;
  }
  
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  public String getSurname() {
    return this.surname;
  }
  public String getName() {
    return this.name;
  }
  public String getSex() {
    return this.sex;
  }
  public int getAge() {
    return this.age;
  }
}