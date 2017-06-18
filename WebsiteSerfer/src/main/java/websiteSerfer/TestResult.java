package websiteSerfer;


/**
 * Contains results of one test.
 */
public class TestResult {
  private boolean status;
  private String instruction;
  private double time;

  public TestResult(boolean status, String instruction, double time) {
    this.status = status;
    this.instruction = instruction;
    this.time = time;
  }

  @Override
  public String toString() {
    String strStatus;

    if (status) {
      strStatus = "+";
    } else {
      strStatus = "!";
    }
    return strStatus + " [" + instruction + "] " + time + "\n";
  }

  public boolean isStatus() {
    return status;
  }

  public double getTime() {
    return time;
  }
}
