package textHandler.operationsWithText;

import java.util.*;
/**
 * Performs operations with words.
 */
public class WordsOperations {
  private static final char A_SYMB = 96;
  private static final char Z_SYMB = 123;

  /**
   * Get number of words of needed size from list.
   *
   * @param size - needed size.
   * @param listTexts - list of texts.
   * @param invalidSymbols - list of invalid values.
   * @return number of needed words.
   */
  public int getNumberOfSpecialWordsInList(int size, List<String> listTexts,
      List<String> invalidSymbols) {
    int totalNumberOfWords = 0;

    for (String text : listTexts) {
      totalNumberOfWords += getNumberOfSpecialWords(size, text, invalidSymbols);
    }
    return totalNumberOfWords;
  }

  /**
   * Get number of words of needed size from one string.
   *
   * @param size - needed size.
   * @param text - source string.
   * @param invalidSymbols - list of invalid values.
   * @return number of needed words in the string.
   */
  public int getNumberOfSpecialWords(int size, String text, List<String> invalidSymbols) {
    int numberOfWords = 0;
    int wordBeginFlag = 0;

    for (int i = 0; i < text.length(); i++) {
      String currSymbol = text.substring(i, i + 1);
      for (String symb : invalidSymbols) {
        if (currSymbol.equals(symb) || i == text.length() - 1) {
          if (isLongWord(size, text.substring(wordBeginFlag, i + 1))) {
            numberOfWords++;
          }
          wordBeginFlag = i + 1;
        }
      }
    }
    return numberOfWords;
  }

  /**
   * Check that the word satisfied requirements.
   *
   * @param size - needed size.
   * @param word - word for check.
   * @return true its required.
   */
  public boolean isLongWord(int size, String word) {
    int wordSize = 0;

    for (int i = 0; i < word.length(); i++) {
      char currSymbol = word.toLowerCase().charAt(i);

      if (currSymbol > A_SYMB && currSymbol < Z_SYMB ) {
        wordSize++;
      }
    }

    if (wordSize > size) {
      return true;
    } else {
      return false;
    }
  }
}