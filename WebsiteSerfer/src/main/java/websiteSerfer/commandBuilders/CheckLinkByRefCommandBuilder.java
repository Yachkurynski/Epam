package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.CheckLinkByRefCommand;
import websiteSerfer.commands.Command;

/**
 * Builds CheckLinkByRef-command.
 */
public class CheckLinkByRefCommandBuilder extends CommandBuilder {
  private String hRef;

  /**
   * Creates instance of builder. Uses chain of responsibility.
   * @param nextCommandBuilder reference to next builder in the chain.
   */
  public CheckLinkByRefCommandBuilder(CommandBuilder nextCommandBuilder) {
    this.nextCommandBuilder = nextCommandBuilder;
    this.commandName = "checkLinkPresentByHref";
  }

  /**
   * Returns command by given command's name.
   *
   * @param commandName given command's name.
   * @param parameters parameters which are need for command performing.
   * @param provider command provider which allows to perform commands.
   * @return command.
   */
  @Override
  public Command getCommand(String commandName, String parameters, PageTestProvider provider) {
    if (this.commandName.equals(commandName)) {
      parseParams(parameters);
      return new CheckLinkByRefCommand(hRef, provider);
    } else if (nextCommandBuilder != null) {
      return nextCommandBuilder.getCommand(commandName, parameters, provider);
    } else {
      throw new IllegalArgumentException("Unknown command: " + commandName);
    }
  }

  /**
   * Parses giving string with parameters which are need for this command.
   * @param parameters string with parameters.
   */
  @Override
  public void parseParams(String parameters) {
    int refBegin = parameters.indexOf('"') + 1;
    int refEnd = parameters.indexOf('"', refBegin);

    hRef = parameters.substring(refBegin, refEnd);
  }
}
