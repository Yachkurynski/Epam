package textHandler;

import java.util.*;
/**
 * Describes invalid symbols for calculations.
 */
public class InvalidSymbols {
  private static final char SPACE_SYMBOL = 32;
  private static final char A_SYMBOL = 65;
  private static final char SLASH_SYMBOL = 47;
  private static final char DOTS_SYMBOL = 58;
  private List<String> invalidSymbols;

  /**
   * Create an object which describes invalid values.
   */
  public InvalidSymbols() {
    List<String> invalidSymbs = new ArrayList<>();

    for (char i = SPACE_SYMBOL; i < A_SYMBOL; i++) {
      if(i > SLASH_SYMBOL && i < DOTS_SYMBOL) {
        continue;
      } else {
        invalidSymbs.add(String.valueOf(i));
      }
    }
    this.invalidSymbols = invalidSymbs;
  }

  public List<String> getInvalidSymbols() {
    return this.invalidSymbols;
  }
}