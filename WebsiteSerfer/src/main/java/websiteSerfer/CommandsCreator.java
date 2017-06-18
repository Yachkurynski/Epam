package websiteSerfer;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriverException;
import websiteSerfer.commandBuilders.CommandBuilder;
import websiteSerfer.commands.Command;

/**
 *
 */
public class CommandsCreator {
  private CommandBuilder builder;
  private PageTestProvider provider;

  public CommandsCreator(CommandBuilder builder, PageTestProvider provider) {
    this.builder = builder;
    this.provider = provider;
  }

  public List<Command> createCommands(List<String> instructions) {
    List<Command> commands = new ArrayList<>();
    Command command;

    for (String instruction : instructions) {
      String[] commandWithParameters = instruction.split(" ", 2);

      if (commandWithParameters.length > 1) {
        command = builder.getCommand(commandWithParameters[0], commandWithParameters[1], provider);
        commands.add(command);
      } else {
        commands.add(null);
      }
    }
    return commands;
  }
}
