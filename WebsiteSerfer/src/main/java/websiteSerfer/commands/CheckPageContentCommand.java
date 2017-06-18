package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Checks page content.
 */
public class CheckPageContentCommand extends Command {
  private String pageContent;

  /**
   * Creates instance of this command.
   * @param pageContent some text needed to check.
   * @param provider command provider which allows to perform commands.
   */
  public CheckPageContentCommand(String pageContent, PageTestProvider provider) {
    this.pageContent = pageContent;
    this.provider = provider;
  }

  /**
   * Start execution of the command.
   */
  @Override
  public void execute() {
    provider.checkPageContent(pageContent);
  }
}
