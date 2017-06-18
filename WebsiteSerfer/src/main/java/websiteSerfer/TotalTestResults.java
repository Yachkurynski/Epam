package websiteSerfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains total results of all the tests.
 */
public class TotalTestResults {
  private List<TestResult> results;

  /**
   * Creates instance of total result.
   */
  public TotalTestResults() {
    results = new ArrayList<>();
  }

  /**
   * Add one result to list of results.
   * @param result given test result.
   */
  public void addResult(TestResult result) {
    results.add(result);
  }

  /**
   * Returns amount of test depending on given parameter (true - passed or false - failed).
   * @param status which test are need.
   * @return amount of tests.
   */
  public int getAmountTests(boolean status) {
    int amount = 0;

    for (TestResult result : results) {
      if (result.isStatus() == status) {
        amount++;
      }
    }
    return amount;
  }

  /**
   * Returns total time which spent on all tests.
   * @return total time.
   */
  public double getTotalTime() {
    double totalTime = 0.0;

    for (TestResult result : results) {
      totalTime += result.getTime();
    }
    return totalTime;
  }

  /**
   * Returns average time of all tests.
   * @return average time.
   */
  public double getAverageTime() {
    double totalTime = getTotalTime();
    return totalTime / results.size();
  }

  public List<TestResult> getResults() {
    return results;
  }
}
