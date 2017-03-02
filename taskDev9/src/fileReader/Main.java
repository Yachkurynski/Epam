package fileReader;

/**
 * Search value in section by key int the file.
 */
public class Main {
  private static final String SECTION_WORD = "section";
  private static final String KEY_WORD = "key";
  private static final String INCORRECT_ARGUMENT_ERROR_MSG = "Incorrect argument!";

  /**
   * Entry point to the program.
   * @param args file's name in which needed searching.
   */
  public static void main(String[] args) {
    if (args.length == 1) {
      IniFileReader fileReader = new IniFileReader();
      ConsoleReader consoleReader = new ConsoleReader();
      PrintResults printer = new PrintResults();

      String section = consoleReader.readFromConsole(SECTION_WORD);
      String key = consoleReader.readFromConsole(KEY_WORD);
      String[] values = fileReader.readFromFile(args[0], section, key);
      printer.printArray(values);

    } else {
      System.out.println(INCORRECT_ARGUMENT_ERROR_MSG);
    }
  }
}
