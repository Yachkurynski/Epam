package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.CheckPageTitleCommand;
import websiteSerfer.commands.Command;

/**
 * Build command which checks page title.
 */
public class CheckPageTitleCommandBuilder extends CommandBuilder {
  private String pageTitle;

  /**
   * Creates instance of builder. Uses chain of responsibility.
   * @param nextCommandBuilder reference to next builder in the chain.
   */
  public CheckPageTitleCommandBuilder(CommandBuilder nextCommandBuilder) {
    this.nextCommandBuilder = nextCommandBuilder;
    this.commandName = "checkPageTitle";
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
      return new CheckPageTitleCommand(pageTitle, provider);
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
    int titleBegin = parameters.indexOf('"') + 1;
    int titleEnd = parameters.indexOf('"', titleBegin);

    pageTitle = parameters.substring(titleBegin, titleEnd);
  }
}
