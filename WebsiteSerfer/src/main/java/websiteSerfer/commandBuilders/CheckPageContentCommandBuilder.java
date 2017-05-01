package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.CheckPageContentCommand;
import websiteSerfer.commands.Command;

/**
 * Builds command which checks page content.
 */
public class CheckPageContentCommandBuilder extends CommandBuilder {
  private String pageContent;

  /**
   * Creates instance of builder. Uses chain of responsibility.
   * @param nextCommandBuilder reference to next builder in the chain.
   */
  public CheckPageContentCommandBuilder(CommandBuilder nextCommandBuilder) {
    this.nextCommandBuilder = nextCommandBuilder;
    this.commandName = "checkPageContains";
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
      return new CheckPageContentCommand(pageContent, provider);
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
    int contentBegin = parameters.indexOf('"') + 1;
    int contentEnd = parameters.lastIndexOf('"');

    pageContent = parameters.substring(contentBegin, contentEnd);
  }
}
