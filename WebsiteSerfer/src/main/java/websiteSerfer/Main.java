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
import websiteSerfer.instructionReader.InstructionFileReader;
import websiteSerfer.instructionReader.InstructionReader;
import websiteSerfer.logger.Logger;
import websiteSerfer.logger.LoggerToFile;

/**
 * Reads instructions from text file, performs them and finally save results to other text file.
 */
public class Main {

  /**
   * Entry point to the program.
   * @param args are not used.
   */
  public static void main(String[] args) {
    String fileName = "instructions.txt";
    WebDriver driver = new ChromeDriver();
    PageTestProvider provider = new PageTestProvider(driver);
    InstructionReader reader = new InstructionFileReader(fileName);
    List<String> instructions = reader.readInstructions();

    CommandBuilder builder = new OpenCommandBuilder(new CheckLinkByNameCommandBuilder(
       new CheckLinkByRefCommandBuilder(new CheckPageContentCommandBuilder(
            new CheckPageTitleCommandBuilder(null)))));

    CommandPerformer performer = new CommandPerformer(provider, builder);
    TotalResults results = performer.performCommand(instructions);
    Logger logger = new LoggerToFile("results.txt", results);

    logger.saveResults();
  }
}
