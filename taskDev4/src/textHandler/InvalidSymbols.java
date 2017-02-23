package textHandler;

import java.util.*;
/**
 * Describes invalid symbols for calculations.
 */
public class InvalidSymbols {
  private static final String PUNCTUATIONS = ",.:;\'\"\\-/<> ";
  private List<String> invalidSymbols;

  /**
   * Create an object which describes invalid values.
   */
  public InvalidSymbols() {
    List<String> invalidSymbs = new ArrayList<>();
    char[] punctuations = PUNCTUATIONS.toCharArray();

    for (char mark : punctuations) {
      invalidSymbs.add(String.valueOf(mark));
    }
    this.invalidSymbols = invalidSymbs;
  }

  public List<String> getInvalidSymbols() {
    return this.invalidSymbols;
  }
}