package workWithJSONFiles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Stores information from JSON-file.
 */
public class JSONFileData {
  private Map<String, Object> jsonObjectMap = new LinkedHashMap<>();

  /**
   * Creates entity which stores information from JSON-file.
   *
   * @param jsonObjectMap map with information from file.
   * @throws NullPointerException when given collection is empty.
   */
  public JSONFileData (Map<String, Object> jsonObjectMap) {
    if (!jsonObjectMap.isEmpty()) {
      this.jsonObjectMap = jsonObjectMap;
    } else {
      throw new NullPointerException("Empty collection for JSON object.");
    }
  }

  public Map<String, Object> getJsonObjectMap() {
    return jsonObjectMap;
  }

}
