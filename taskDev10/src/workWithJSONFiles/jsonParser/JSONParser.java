package workWithJSONFiles.jsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import workWithJSONFiles.JSONOperators;

/**
 * Parses JSON-file to Map.
 */
public class JSONParser {
  private static final int ONE_SYMBOL = 1;

  /**
   * Performs parsing data from JSON-file to Map.
   *
   * @param fileName name of JSON-file.
   * @return Map with data.
   */
  public Map<String, Object> parse(String fileName) throws IOException {
    Map<String, Object> localMap = new LinkedHashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String stringToCheck;

      while ((stringToCheck = reader.readLine()) != null) {
        if (stringToCheck.contains(JSONOperators.OBJECT_BEGIN)) {
          localMap = fillTheMap(reader);
        }
      }
    }
    return localMap;
  }

  /**
   * Fills the map as object where field name is key and field value is value.
   *
   * @param reader BufferedReader for file reading.
   * @return Map as object.
   * @throws IllegalArgumentException when current string contains invalid value.
   */
  private Map<String, Object> fillTheMap(BufferedReader reader) throws IOException {
    Map<String, Object> localMap = new LinkedHashMap<>();
    String fileString;

    while (!(fileString = reader.readLine()).contains(JSONOperators.OBJECT_END)) {
      String key = getKey(fileString);
      Object value = getValue(fileString, reader);

      if (key == null || value == null) {
        throw new IllegalArgumentException("Invalid argument in string: " + fileString);
      }
      localMap.put(key, value);
    }
    return localMap;
  }

  /**
   * Reads key from pair key-value.
   *
   * @param fileString string from file with pair key-value.
   * @return string key or null if it's invalid value.
   */
  private String getKey(String fileString) {
    int keyBegin = fileString.indexOf(JSONOperators.QUOTE) + 1;
    int keyEnd = fileString.indexOf(JSONOperators.QUOTE, keyBegin);

    if (keyEnd - keyBegin < ONE_SYMBOL) {
      return null;
    } else {
      return fileString.substring(keyBegin, keyEnd).trim();
    }
  }

  /**
   * Reads value from pair key-value. Depending on the type of value (array, object, or simple
   * value) calls other method to get specific value.
   *
   * @param fileString string with value.
   * @param reader Buffered reader for file reading.
   * @return found value.
   * @throws IllegalArgumentException when value is missed.
   */
  private Object getValue(String fileString, BufferedReader reader) throws IOException {
    String string = fileString.substring(fileString.indexOf(JSONOperators.COLON) + 1).trim();

    if (string.startsWith(JSONOperators.QUOTE)) {
      return getSimpleValue(string);
    } else if (string.startsWith(JSONOperators.ARRAY_BEGIN)) {
      return fillTheList(reader, string);
    } else if (string.length() == 0) {
      string = reader.readLine();

      if (string.contains(JSONOperators.OBJECT_BEGIN)) {
        return fillTheMap(reader);
      } else {
        throw new IllegalArgumentException("Missing value: " + fileString);
      }
    } else {
      return getSimpleValue(string);
    }
  }

  /**
   * Reads simple value from string.
   *
   * @param string source string with value.
   * @return value.
   */
  private Object getSimpleValue(String string) {
    if (string.contains(JSONOperators.QUOTE)) {
      return getKey(string);
    } else {
      if (string.contains(JSONOperators.COMMA)) {
        string = string.substring(0, string.indexOf(JSONOperators.COMMA));
      }

      try {
        return Integer.parseInt(string);
      } catch (NumberFormatException ex) {
        try {
          return Double.parseDouble(string);
        } catch (NumberFormatException exep) {
          return Boolean.parseBoolean(string);
        }
      }
    }
  }

  /**
   * Fills the list as value by values or objects.
   *
   * @param reader Buffered reader for file reading.
   * @param currentString current string with value.
   * @return list with values.
   */
  private List<Object> fillTheList(BufferedReader reader, String currentString) throws IOException {
    List<Object> localList = new ArrayList<>();
    String localString;

    if (currentString.contains(JSONOperators.ARRAY_END)) {
      String[] simpleValues = currentString.split(JSONOperators.COMMA);
      for (String value : simpleValues) {
        localList.add(getSimpleValue(value));
      }
    } else {
      while (!(localString = reader.readLine()).contains(JSONOperators.ARRAY_END)) {
        Map<String, Object> innerMap;

        if (localString.contains(JSONOperators.OBJECT_BEGIN)) {
          innerMap = fillTheMap(reader);
          localList.add(innerMap);
        }
      }
    }
    return localList;
  }
}
