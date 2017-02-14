package taskDev3.peopleData.operations;

import java.util.*;
import taskDev3.peopleData.*;

/**
 * Performs some actions with people's name.
 */
public class OperationsWithName {
  
  /**
   * Looks for the most popular name.
   *
   * @param people - list of people.
   * @return the most popular name.
   */
  public String getTheMostPopulName(List<People> people) {
    String popularName = "";
    int frequency = 0;
    String needGender = "w";
    
    for (int i = 0; i < people.size(); i++) {
      if (needGender.equals((people.get(i)).getSex())) {
        String currentName = (people.get(i)).getName();
        int freqThisName = 0;
        
        for (int j = 0; j < people.size(); j++) {
          if (currentName.equals((people.get(j)).getName())) {
            freqThisName++;
          }
        }
        if (freqThisName > frequency) {
          frequency = freqThisName;
          popularName = currentName;
        }
      }
    }
    return popularName;
  }
}