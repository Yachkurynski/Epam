package textHandler;

import java.util.*;

/**
 * Prints data
 */
public class PrintResults {
  private static final String NUMBER_OF_WORDS = "Number of special words = ";
  private static final String TOTAL_KEY = "total";
  private static final String VALUE = "Value: \"";
  private static final String FREQUENCY = "\" Frequency: ";

  /**
   * Prints results of calculations with words.
   *
   * @param numberOfWords - result of calculations.
   */
  public void print(int numberOfWords) {
    System.out.println(NUMBER_OF_WORDS + numberOfWords);
  }

  /**
   * Prints letters with their frequencies.
   *
   * @param lettersMap - Map, where key - letters, and value - their amount.
   */
  public void print(Map<String, Integer> lettersMap) {
    Set<String> keys = lettersMap.keySet();
    double numbOfPairs = lettersMap.remove(TOTAL_KEY);

    for (String key : keys) {
      double frequency = (double)lettersMap.get(key) / numbOfPairs;
      System.out.println(VALUE + key + FREQUENCY + frequency);
    }
  }
}