package calendar;

import java.io.*;

/**
 * Reads data from console.
 */
public class ConsoleReader {

  /**
   * Reads format of date from console.
   *
   * @return array of format descriptors.
   * @throws IOException when array is empty.
   */
  public String[] readFromConsole() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] dateFormat = {};

    try {
      System.out.println("Enter date format: ");
      dateFormat = reader.readLine().split("[:/ ]+");

      if (dateFormat.length == 0) {
        throw new IOException();
      }
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    return dateFormat;
  }
}
