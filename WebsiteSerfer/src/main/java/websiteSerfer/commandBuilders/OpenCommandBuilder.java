package websiteSerfer.commandBuilders;

import websiteSerfer.PageTestProvider;
import websiteSerfer.commands.Command;
import websiteSerfer.commands.OpenCommand;

/**
 * Builds command which must open given url-address.
 */
public class OpenCommandBuilder extends CommandBuilder {
  private String url;
  private long timeout;

  /**
   * Creates instance of builder. Uses chain of responsibility.
   * @param nextCommandBuilder reference to next builder in the chain.
   */
  public OpenCommandBuilder(CommandBuilder nextCommandBuilder) {
    this.nextCommandBuilder = nextCommandBuilder;
    this.commandName = "open";
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
    if(this.commandName.equals(commandName)) {
      parseParams(parameters);
      return new OpenCommand(url, timeout, provider);
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
    int urlBegin = parameters.indexOf('"') + 1;
    int urlEnd = parameters.indexOf('"', urlBegin);
    int timeoutBegin = parameters.indexOf('"', urlEnd + 1) + 1;
    int timeoutEnd = parameters.lastIndexOf('"');

    url = parameters.substring(urlBegin, urlEnd);
    timeout = Long.parseLong(parameters.substring(timeoutBegin,timeoutEnd));
  }

  public String getUrl() {
    return url;
  }

  public long getTimeout() {
    return timeout;
  }
}
