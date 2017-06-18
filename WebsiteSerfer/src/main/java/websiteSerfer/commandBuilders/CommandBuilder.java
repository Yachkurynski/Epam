package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.Command;

/**
 * Parent class for command's builders.
 */
public abstract class CommandBuilder {
  protected CommandBuilder nextCommandBuilder;
  protected String commandName;

  /**
   * Returns command by given command's name.
   *
   * @param commandName given command's name.
   * @param parameters parameters which are need for command performing.
   * @param provider command provider which allows to perform commands.
   * @return command.
   */
  public abstract Command getCommand(String commandName, String parameters,
      PageTestProvider provider);

  /**
   * Parses giving string with parameters which are need for this command.
   * @param parameters string with parameters.
   */
  public abstract void parseParams(String parameters);
}
