package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.CheckLinkByNameCommand;
import websiteSerfer.commands.Command;

/**
 * Builds CheckLinkByName-command.
 */
public class CheckLinkByNameCommandBuilder extends CommandBuilder {
  private String linkName;

  /**
   * Creates instance of builder. Uses chain of responsibility.
   * @param nextCommandBuilder reference to next builder in the chain.
   */
  public CheckLinkByNameCommandBuilder(CommandBuilder nextCommandBuilder) {
    this.nextCommandBuilder = nextCommandBuilder;
    this.commandName = "checkLinkPresentByName";
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
      return new CheckLinkByNameCommand(linkName, provider);
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
    int nameBegin = parameters.indexOf('"') + 1;
    int nameEnd = parameters.indexOf('"', nameBegin);

    linkName = parameters.substring(nameBegin, nameEnd);
  }
}
