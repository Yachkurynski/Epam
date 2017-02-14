package taskDev3.peopleData;

import java.util.*;
import taskDev3.peopleData.operations.*;

/**
 * Prints several information about people.
 */
class Printer {
  private static final String SPACE = " ";
  private static final String MEAN_AGE_MSG = "Mean people's age: ";
  private static final String OLDEST_PERSON_MSG = "Oldest person: ";
  private static final String THE_MOST_POPULAR_NAME_MSG = "The most popular women's name: ";
  private static final String SIMILAR_SURNAMES_MASG = "People with similar surnames: ";
  
  /**
   * Prints results of operations with People list.
   * 
   * @param people - list of the persons.
   */
  public void printResults(List<People> people) {
    OperationsWithAge ageOp = new OperationsWithAge();
    OperationsWithName nameOp = new OperationsWithName();
    OperationsWithSurname surnameOp = new OperationsWithSurname();
    
    People oldestPerson = ageOp.getOldestPers(people);
    
    System.out.println(MEAN_AGE_MSG + ageOp.calcMeanAge(people));
	System.out.print(OLDEST_PERSON_MSG);
    printPeople(ageOp.getOldestPers(people)); // For one person.
    System.out.println(THE_MOST_POPULAR_NAME_MSG + nameOp.getTheMostPopulName(people));
	System.out.println(SIMILAR_SURNAMES_MASG);
    printPeople(surnameOp.lookForSimSurname(people)); // For list of persons.
  }
  
  /**
   * Prints information about persons from list.
   * 
   * @param people - list of the persons.
   */
  public void printPeople(List<People> people) {
    List<String> persInformation = new ArrayList<String>();
    
    for (People p : people) {
      StringBuilder persInform = new StringBuilder(p.getSurname());
      persInform.append(SPACE + p.getName());
      persInform.append(SPACE + p.getSex());
      persInform.append(SPACE + p.getAge());
      
      persInformation.add(persInform.toString());
    }
    for (String str : persInformation) {
      System.out.println(str);
    }
  }
  
  /**
   * Prints information about one person.
   * 
   * @param people - one person.
   */
  public void printPeople(People people) {
    StringBuilder persInform = new StringBuilder(people.getSurname());
    persInform.append(SPACE + people.getName());
    persInform.append(SPACE + people.getSex());
    persInform.append(SPACE + people.getAge());
    
    System.out.println(persInform);
  }
}