package websiteSerfer;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import websiteSerfer.commandBuilders.CheckLinkByNameCommandBuilder;
import websiteSerfer.commandBuilders.CheckLinkByRefCommandBuilder;
import websiteSerfer.commandBuilders.CheckPageContentCommandBuilder;
import websiteSerfer.commandBuilders.CheckPageTitleCommandBuilder;
import websiteSerfer.commandBuilders.CommandBuilder;
import websiteSerfer.commandBuilders.OpenCommandBuilder;
import websiteSerfer.commands.Command;
import websiteSerfer.instructionReader.InstructionFileReader;
import websiteSerfer.instructionReader.InstructionReader;
import websiteSerfer.logger.ResultLogger;
import websiteSerfer.logger.ResultLoggerToFile;

/**
 * Reads instructions from text file, performs them and finally save results to other text file.
 */
public class Main {
  private static final String INSTRUCTIONS_FILE = "instructions.txt";
  private static final String RESULTS_FILE = "results.txt";

  /**
   * Entry point to the program.
   * @param args are not used.
   */
  public static void main(String[] args) {
    CommandBuilder builder = new OpenCommandBuilder(new CheckLinkByNameCommandBuilder(
        new CheckLinkByRefCommandBuilder(new CheckPageContentCommandBuilder(
            new CheckPageTitleCommandBuilder(null)))));

    WebDriver driver = new ChromeDriver();
    PageTestProvider provider = new PageTestProvider(driver);
    InstructionReader reader = new InstructionFileReader(INSTRUCTIONS_FILE);
    List<String> instructions = reader.readInstructions();

    CommandsCreator creator = new CommandsCreator(builder, provider);
    List<Command> commands = creator.createCommands(instructions);

    CommandExecutor performer = new CommandExecutor(provider);
    TotalTestResults results = performer.executeCommands(commands, instructions);

    ResultLogger resultLogger = new ResultLoggerToFile(RESULTS_FILE, results);
    resultLogger.saveResults();
  }
}