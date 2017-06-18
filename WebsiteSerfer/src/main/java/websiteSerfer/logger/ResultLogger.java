package websiteSerfer.logger;

import websiteSerfer.TotalTestResults;

/**
 * Parent class for results' loggers.
 */
public abstract class ResultLogger {
  protected TotalTestResults results;

  /**
   * Saves results of commands' performing.
   */
  public abstract void saveResults();
}
