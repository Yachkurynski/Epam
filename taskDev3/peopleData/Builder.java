package taskDev3.peopleData;

import java.util.*;

/**
 * Create instance of any class.
 */
class Builder {
  private static final int SURNAME_NUM = 0;
  private static final int NAME_NUM = 1;
  private static final int SEX_NUM = 2;
  private static final int AGE_NUM = 3;
  
  /**
   * Makes one person with given parameters.
   *
   * @param persInform - array with parameters.
   * @return person.
   */
  public People buildPerson(String[] persInform) {
    String surname = persInform[SURNAME_NUM];
    String name = persInform[NAME_NUM];
    String sex = persInform[SEX_NUM];
    int age = Integer.parseInt(persInform[AGE_NUM]);
    
    People person = new People(surname, name, sex, age);
    return person;
  }
}