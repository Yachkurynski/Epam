package workWithJSONFiles;

import java.util.Map;

/**
 * Store information from JSON config file .
 */
public class JSONConfigFile {
  private static final String INPUT_PATH = "input";
  private static final String OUTPUT_PATH = "output";
  private String destinationPath;
  private String sourcePath;

  /**
   * Writes paths of input and output files from map to fields of the class.
   * @param pathMap map with paths of input and output files.
   */
  public JSONConfigFile(Map<String, Object> pathMap) {
    destinationPath = (String)pathMap.get(OUTPUT_PATH);
    sourcePath = (String)pathMap.get(INPUT_PATH);
  }

  public String getSourcePath() {
    return sourcePath;
  }

  public String getDestinationPath() {
    return destinationPath;
  }
}
