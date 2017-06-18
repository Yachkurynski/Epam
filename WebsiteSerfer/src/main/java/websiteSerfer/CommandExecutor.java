package websiteSerfer;
import java.util.List;
import org.openqa.selenium.WebDriverException;
import websiteSerfer.commandBuilders.CommandBuilder;
import websiteSerfer.commands.Command;

/**
 * Performs all the commands from given collection of commands.
 */
public class CommandExecutor {
  private PageTestProvider provider;

  /**
   * Creates instance of command performer.
   * @param provider command provider which allows to perform commands.
   */
  public CommandExecutor(PageTestProvider provider) {
    this.provider = provider;
  }

  /**
   * Performs all the given commands.
   * @param commands collection of the commands needed to execute.
   * @return instance of test's results.
   */
  public TotalTestResults executeCommands(List<Command> commands, List<String> instructions) {
    TotalTestResults results = new TotalTestResults();
    boolean status;
    long begin = 0L;
    double time;
    int i = 0;

    for (Command command : commands) {
      String instruction = instructions.get(i++);
      status = false;
      time = 0.0;

      try {
        if (command != null) {
          begin = System.currentTimeMillis();
          command.execute();
          status = true;
          time = (double)(System.currentTimeMillis() - begin) / 1000;
        }
      } catch (WebDriverException | IllegalArgumentException ex) {
        time = (double)(System.currentTimeMillis() - begin) / 1000;
      } finally {
        results.addResult(new TestResult(status, instruction, time));
      }
    }
    provider.closeSource();
    return results;
  }
}
