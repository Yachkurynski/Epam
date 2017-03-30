package workWithJSONFiles;

import com.sun.javaws.exceptions.InvalidArgumentException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import workWithJSONFiles.jsonParser.JSONParser;
import workWithJSONFiles.jsonWriter.JSONWriter;

/**
 * Parses JSON-file and write this information to other JSON-file.
 */
public class Main {
  private static final String CONFIG_FILE_NAME = "config.json";

  /**
   * Entry point to the program.
   * @param args are not used.
   */
  public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    JSONWriter writer = new JSONWriter();

    try {
      JSONConfigFile config = new JSONConfigFile(parser.parse(CONFIG_FILE_NAME));
      JSONFileData jsonData = new JSONFileData(parser.parse(config.getSourcePath()));

      writer.write(config.getDestinationPath(), jsonData);
    } catch (NullPointerException e) {
      System.out.println(e.getLocalizedMessage());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getLocalizedMessage());
    } catch (IOException e) {
      System.out.println(e.getLocalizedMessage());
    }
  }

}
