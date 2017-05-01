package websiteSerfer.logger;

import websiteSerfer.TotalResults;

/**
 * Parent class for results' loggers.
 */
public abstract class Logger {
  protected TotalResults results;

  /**
   * Saves results of commands' performing.
   */
  public abstract void saveResults();
}
