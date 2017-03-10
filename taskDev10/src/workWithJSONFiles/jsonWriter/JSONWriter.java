package workWithJSONFiles.jsonWriter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import workWithJSONFiles.JSONFileData;
import workWithJSONFiles.JSONOperators;

/**
 * Writes data to file in JSON format.
 */
public class JSONWriter {
  private static final int INDENTATION = 2;
  private static final String STRING_TYPE = "String";
  private static final String ARRAYLIST_TYPE = "ArrayList";
  private static final String LINKEDHASHMAP_TYPE = "LinkedHashMap";
  private static final String INTEGER_TYPE = "Integer";
  private static final String DOUBLE_TYPE = "Double";
  private static final String BOOLEAN_TYPE = "Boolean";

  /**
   * Writes given data to file.
   *
   * @param fileName name of destination file.
   * @param data object which contains map with data.
   */
  public void write(String fileName, JSONFileData data) throws IOException {
    Map<String, Object> dataMap= data.getJsonObjectMap();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      int level = 1;
      writeObject(dataMap, writer, level);
    } catch (FileNotFoundException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }

  /**
   * Writes object value to file.
   *
   * @param dataMap map with data for writing.
   * @param writer bufferedWriter for writing to file.
   * @param level value which defines size of indentation.
   */
  private void writeObject(Map<String, Object> dataMap, BufferedWriter writer, int level)
      throws IOException {
    int iter = 0;

    if (level != 1) {
      writer.write(JSONOperators.LINE_BREAK);
    }
    writeIndentation(level, writer);
    writer.write(JSONOperators.OBJECT_BEGIN + JSONOperators.LINE_BREAK);

    for (String key : dataMap.keySet()) {
      writeKey(key, writer, level + INDENTATION);
      writeValue(dataMap.get(key), writer, level + INDENTATION);
      iter++;
      writeCommas(dataMap.entrySet(), iter, writer);
    }
    writeIndentation(level, writer);
    writer.write(JSONOperators.OBJECT_END);
  }

  /**
   * Writes given key to file in format "key":
   *
   * @param key given key for writing.
   * @param writer bufferedWriter for writing to file.
   * @param level value which defines size of indentation.
   */
  private void writeKey(String key, BufferedWriter writer, int level) throws IOException {
    writeIndentation(level, writer);
    writer.write(JSONOperators.QUOTE + key + JSONOperators.QUOTE + JSONOperators.COLON);
  }

  /**
   * Writes value to file depending on the type of value.
   *
   * @param value value for writing.
   * @param writer bufferedWriter for writing to file.
   * @param level value which defines size of indentation.
   */
  private void writeValue(Object value, BufferedWriter writer, int level) throws IOException {
    String type = value.getClass().getSimpleName();
    selectTypeOfWrite(type, value, writer, level);
  }

  /**
   * Calls the specified method for writing to file depending on type of value.
   *
   * @param type type of given value.
   * @param value given value for writing to file.
   * @param writer bufferedWriter for writing to file.
   * @param level value which defines size of indentation.
   */
  private void selectTypeOfWrite(String type, Object value, BufferedWriter writer, int level)
      throws IOException {
    if (type.equals(STRING_TYPE)) {
      writer.write(JSONOperators.QUOTE + value + JSONOperators.QUOTE);
    }  else if (type.equals(ARRAYLIST_TYPE)) {
      writeArray((ArrayList)value, writer, level);
    } else if (type.equals(LINKEDHASHMAP_TYPE)) {
      writeObject((LinkedHashMap)value, writer, level);
    } else if (type.equals(INTEGER_TYPE) || type.equals(DOUBLE_TYPE) || type.equals(BOOLEAN_TYPE)) {
      writer.write(String.valueOf(value));
    }
  }

  /**
   * Writes the array of values to file.
   *
   * @param valueArray array of values.
   * @param writer bufferedWriter for writing to file.
   * @param level given value for writing to file
   */
  private void writeArray(List<Object> valueArray, BufferedWriter writer, int level)
      throws IOException {
    writer.write(JSONOperators.ARRAY_BEGIN);
    int iteration = 0;

    for (Object value : valueArray) {
      selectTypeOfWrite(value.getClass().getSimpleName(), value, writer, level + INDENTATION);
      iteration++;
      writeCommas(valueArray, iteration, writer);
    }
    writeIndentation(level, writer);
    writer.write(JSONOperators.ARRAY_END);
  }

  /**
   * Writes indentations before string's beginning.
   *
   * @param numberOfSpaces size of indentation.
   * @param writer bufferedWriter for writing to file.
   */
  private void writeIndentation(int numberOfSpaces, BufferedWriter writer) throws IOException {
    for (int i = 0; i < numberOfSpaces; i++) {
      writer.write(JSONOperators.SPACE);
    }
  }

  /**
   * Writes commas and line breaks to the end of string depending on situation or values in
   * collection and its type.
   *
   * @param collection collection with values.
   * @param iter index number of the written item from collection.
   * @param writer bufferedWriter for writing to file.
   */
  private void writeCommas(Collection collection, int iter, BufferedWriter writer)
      throws IOException {
    if (collection.size() != iter) {
      if (collection.getClass().getSimpleName().equals(ARRAYLIST_TYPE)) {
        writer.write(JSONOperators.COMMA);
      } else {
        writer.write(JSONOperators.COMMA + JSONOperators.LINE_BREAK);
      }
    } else {
      writer.write(JSONOperators.LINE_BREAK);
    }
  }
}
