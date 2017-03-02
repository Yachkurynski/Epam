package fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Search value by key in section from the given file.
 */
public class IniFileReader {
  private static final String VALUES_SEPARATOR = ",";
  private static final String BEGIN_OF_SECTION_NAME = "[";
  private static final String END_OF_SECTION_NAME = "]";
  private static final String EQUAL_SYMBOL = "=";

  /**
   * Reads sought values from file.
   *
   * @param fileName given file.
   * @param section section in which stored needed key and values.
   * @param key key by which needed values are stored.
   * @return array of needed values.
   */
  public String[] readFromFile(String fileName, String section, String key) {
    String value = "";

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      value = getNeededValue(reader, section, key);
    } catch (FileNotFoundException ex) {
      System.out.println(ex.getLocalizedMessage());
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return value.split(VALUES_SEPARATOR);
  }

  /**
   * Search needed section and value in it.
   *
   * @param reader file reader.
   * @param section name of needed section.
   * @param key name of key by which needed value is stored.
   * @return needed value.
   */
  private String getNeededValue(BufferedReader reader, String section, String key)
      throws IOException {
    String line;
    String value = "";

    while ((line = reader.readLine()) != null) {
      if (line.startsWith(BEGIN_OF_SECTION_NAME) && isNeededSection(section, line)) {
        value = getValueFromSection(reader, key);
      }
    }
    return value;
  }

  /**
   * Search needed value by key.
   *
   * @param reader file reader.
   * @param key name of key by which needed value is stored.
   * @return needed value.
   */
  private String getValueFromSection(BufferedReader reader, String key) throws IOException {
    String readKey;
    String value = "";

    while (!((readKey = reader.readLine()).startsWith(BEGIN_OF_SECTION_NAME))) {
      if (readKey.startsWith(key)) {
        value = readKey.substring(readKey.indexOf(EQUAL_SYMBOL) + 1).trim();
      }
    }
    return value;
  }

  /**
   * Checks that it's a sought section.
   *
   * @param section name of needed section.
   * @param line name of section for check.
   * @return true if it's needed section.
   */
  private boolean isNeededSection(String section, String line) {
    return section.equals(line.substring(1, line.lastIndexOf(END_OF_SECTION_NAME)));
  }
}