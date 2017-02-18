package textHandler.operationsWithText;

import java.util.*;
/**
 * Performs operations with words.
 */
public class WordsOperations {
  /**
   * Get number of words of needed size from list.
   *
   * @param size - needed size.
   * @param listTexts - list of texts.
   * @return number of needed words.
   */
  public int getNumberOfSpecialWordsInList(int size, List<String> listTexts) {
    int totalNumberOfWords = 0;

    for (String text : listTexts) {
      totalNumberOfWords += getNumberOfSpecialWords(size, text);
    }
    return totalNumberOfWords;
  }

  /**
   * Get number of words of needed size from one string.
   *
   * @param size - needed size.
   * @param text - source string.
   * @return number of needed words in the string.
   */
  public int getNumberOfSpecialWords(int size, String text) {
    int numberOfWords = 0;
    int wordBeginFlag = 0;

    for (int i = 0; i < text.length(); i++) {
      String currSymbol = text.substring(i, i + 1);

      if (currSymbol.equals(" ") || i == text.length() - 1) {
        if (isLongWord(size, text.substring(wordBeginFlag, i + 1))) {
          numberOfWords++;
        }
        wordBeginFlag = i + 1;
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

      if (currSymbol > 96 && currSymbol < 123 ) {
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
