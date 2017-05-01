package websiteSerfer;

import java.util.List;
import org.openqa.selenium.WebDriverException;
import websiteSerfer.commandBuilders.CommandBuilder;
import websiteSerfer.commands.Command;

/**
 * Performs all the commands from given collection of commands.
 */
public class CommandPerformer {
  private PageTestProvider provider;
  private CommandBuilder builder;

  /**
   * Creates instance of command performer.
   * @param provider command provider which allows to perform commands.
   * @param builder command builder.
   */
  public CommandPerformer(PageTestProvider provider, CommandBuilder builder) {
    this.provider = provider;
    this.builder = builder;
  }

  /**
   * Performs all the given commands.
   * @param instructions collection of the commands needed to perform.
   * @return instance of test's results.
   */
  public TotalResults performCommand(List<String> instructions) {
    TotalResults results = new TotalResults();
    boolean status = true;
    long begin = 0L;
    double time = 0.0;

    for (String instruction : instructions) {
      String[] commands = instruction.split(" ", 2);

      try {
        if (commands.length > 1) {
          Command command = builder.getCommand(commands[0], commands[1], provider);
          begin = System.currentTimeMillis();
          command.execute();
          status = true;
          time = (double)(System.currentTimeMillis() - begin) / 1000;
        } else {
          status = false;
          time = 0.0;
        }
      } catch (WebDriverException | IllegalArgumentException ex) {
        status = false;
        time = (double)(System.currentTimeMillis() - begin) / 1000;
      } finally {
        results.addResult(new TestResult(status, instruction, time));
      }
    }
    provider.closeSource();
    return results;
  }
}
