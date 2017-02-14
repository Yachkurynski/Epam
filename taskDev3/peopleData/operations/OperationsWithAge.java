package taskDev3.peopleData.operations;

import java.util.*;
import taskDev3.peopleData.*;

/**
 * Performs some actions with people's age.
 */
public class OperationsWithAge {
  
  /**
   * Calculate mean age.
   * 
   * @param people - list of people.
   * @return mean age.
   */
  public double calcMeanAge(List<People> people) {
    double sumAge = 0;
    double amount = 0;
    
    for (People p : people) {
      sumAge += p.getAge();
      amount++;
    }
    return sumAge/amount;
  }
  
  /**
   * Looks for oldest person.
   * 
   * @param people - list of people.
   * @return the oldest person.
   */
  public People getOldestPers(List<People> people) {
    int maxAge = (people.get(0)).getAge();
    People oldestPeop = people.get(0);
	
    for (People p : people) {
      if (p.getAge() > maxAge) {
        maxAge = p.getAge();
        oldestPeop = p;
      }
    }
    return oldestPeop;
  }
}