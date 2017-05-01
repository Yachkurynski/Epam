package websiteSerfer.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import websiteSerfer.TestResult;
import websiteSerfer.TotalResults;

/**
 * Saves results of commands' performing to text file.
 */
public class LoggerToFile extends Logger {
  private String outputFile;

  /**
   * Creates instance of logger.
   * @param results given results of commands' performing.
   * @param outputFile file for results.
   */
  public LoggerToFile(String outputFile, TotalResults results) {
    this.results = results;
    this.outputFile = outputFile;
  }

  /**
   * Saves results to file.
   */
  @Override
  public void saveResults() {
    List<TestResult> testResults = results.getResults();

    try (FileWriter writer = new FileWriter(outputFile)) {
      for (TestResult result : testResults) {
        writer.write(result.toString());
      }
      writer.write("Total tests: " + testResults.size() + "\n");
      writer.write("Passed/Failed: " + results.getAmountTests(true) + "/" +
          results.getAmountTests(false) + "\n");
      writer.write("Total time: " + results.getTotalTime() + "\n");
      writer.write("Average time: " + results.getAverageTime() + "\n");
    } catch (IOException e) {
      System.out.println(e.getLocalizedMessage());
    }
  }
}
