package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Parent class for all the commands.
 */
public abstract class Command {
  protected PageTestProvider provider;

  /**
   * Start execution of the command.
   */
  public abstract void execute();
}
