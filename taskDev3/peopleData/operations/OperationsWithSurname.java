package taskDev3.peopleData.operations;

import java.util.*;
import taskDev3.peopleData.*;

/**
 * Performs some actions with people's age.
 */
public class OperationsWithSurname {
  
  /**
   * Looks for people with similar surnames.
   * 
   * @param persons - list of people.
   * @return list with people with similar surnames.
   */
  public List<People> lookForSimSurname(List<People> persons) {
    List<People> people = new ArrayList<People>();
    
    // Copy our list to another for for more comfortable calculations with it.
    for (People person : persons) {
      people.add(person);
    }
    
    List<People> peopWithSimSurname = new ArrayList<People>();
    for (int i = 0; i < people.size(); i++) {
      String currSurname = (people.get(i)).getSurname();
      int countSimSurname = 0;
      int j = i + 1;
      
      while (j < people.size()) {
        if (currSurname.equals((people.get(j)).getSurname())) {
          peopWithSimSurname.add(people.remove(j));
          countSimSurname++;
        } else {
          j++;
        }
      }
      if (countSimSurname > 0) {
        peopWithSimSurname.add(people.get(i));
      }
    }
    return peopWithSimSurname;
  }
}