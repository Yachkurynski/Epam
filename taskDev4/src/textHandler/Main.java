package textHandler;

import java.io.*;
import java.util.*;
import textHandler.operationsWithText.*;

/**
 * Calculate frequency and number of words of a special length.
 */
public class Main {
  private static final int MIN_TEXT_NUMBER = 3;
  private static final int NEEDED_WORD_SIZE = 5;
  private static final int NEEDED_SEQUENCE_SIZE = 2;

  /**
   * Entry point to the program.
   *
   * @param args - not used.
   */
  public static void main(String[] args) {
    ConsoleReader consoleReader = new ConsoleReader();
    List<String> listOfTexts = new ArrayList<>();
    PrintResults printer = new PrintResults();
    InvalidSymbols invalidSymbols = new InvalidSymbols();
    int iter = 0;

    try {
      do {
        WordsOperations findWords = new WordsOperations();
        LetterOperations findLetters = new LetterOperations();

        listOfTexts.add(consoleReader.read());
        printer.print(findWords.getNumberOfSpecialWordsInList(NEEDED_WORD_SIZE, listOfTexts,
            invalidSymbols.getInvalidSymbols()));
        printer.print(findLetters.fillMapByLetters(listOfTexts, NEEDED_SEQUENCE_SIZE,
            invalidSymbols.getInvalidSymbols()));
      } while (++iter < MIN_TEXT_NUMBER || consoleReader.needRepeat());
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}