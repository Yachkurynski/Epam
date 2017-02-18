package textHandler.operationsWithText;

import java.util.*;

/**
 * Performs operations with letters.
 */
public class LetterOperations {
  private static final String TOTAL_KEY = "total";
  private static final char A_SYMB = 97;
  private static final char Z_SYMB = 122;

  /**
   * Fills Map by letters as key and their amount as value.
   *
   * @param listTexts - list of texts.
   * @return Map with letters and their amount.
   */
  public Map<String, Integer> fillMapByLetters(List<String> listTexts, int sequence_size) {
    Map<String, Integer> twoLettersMap = new HashMap<>();

    for (String text : listTexts) {
      for (int i = sequence_size - 1; i < text.length(); i++) {
        if (isLetters(text.substring(i - (sequence_size - 1), i + 1))) {
          String twoLetters = text.substring(i - (sequence_size - 1), i + 1);
          if (twoLettersMap.containsKey(twoLetters)) {
            twoLettersMap.put(twoLetters, twoLettersMap.get(twoLetters) + 1);
          } else {
            twoLettersMap.put(twoLetters, 1);
          }
        }
      }
    }
    twoLettersMap.put(TOTAL_KEY, getTotalSequences(listTexts, sequence_size));
    return twoLettersMap;
  }

  /**
   * Calculate total amount of letter's sequences.
   *
   * @param listTexts - list of texts.
   * @return total amount of letter's sequences.
   */
  public int getTotalSequences(List<String> listTexts, int sequence_size) {
    int totalNumbOfSequences = 0;

    for (String text : listTexts) {
      int numbOfSequences = 0;
      int wordBeginFlag = 0;

      for (int i = 0; i < text.length(); i++) {
        String currSymbol = text.substring(i, i + 1);
        if (currSymbol.equals(" ")) {
          String lastWord = text.substring(wordBeginFlag, i);
          numbOfSequences += calcNumbOfSequences(lastWord, sequence_size);
          wordBeginFlag = i + 1;
        } else if(i == text.length() - 1) {
          String lastWord = text.substring(wordBeginFlag, i + 1);
          numbOfSequences += calcNumbOfSequences(lastWord, sequence_size);
        }
      }
      totalNumbOfSequences += numbOfSequences;
    }
    return totalNumbOfSequences;
  }

  /**
   * Calculate number of sequences in some piece of text.
   *
   * @param word - piece of text.
   * @return number of needed sequences in some piece of text.
   */
  public int calcNumbOfSequences(String word, int sequence_size) {
    if (word.length() < sequence_size) {
      return 0;
    } else {
      return word.length() - 1;
    }
  }

  /**
   * Check that sequence contains only letters.
   *
   * @param letters - sequence.
   * @return true if it contains only letters.
   */
  public boolean isLetters(String letters) {
    for (int i = 0; i < letters.length(); i++) {
      if(letters.charAt(i) < A_SYMB || letters.charAt(i) > Z_SYMB) {
        return false;
      }
    }
    return true;
  }
}
