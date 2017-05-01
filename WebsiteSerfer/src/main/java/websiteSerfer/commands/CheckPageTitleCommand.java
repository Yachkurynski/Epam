package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Checks page title.
 */
public class CheckPageTitleCommand extends Command {
  private String pageTitle;

  /**
   * Creates instance of this command.
   * @param pageTitle page title needed to compare.
   * @param provider command provider which allows to perform commands.
   */
  public CheckPageTitleCommand(String pageTitle, PageTestProvider provider) {
    this.pageTitle = pageTitle;
    this.provider = provider;
  }

  /**
   * Start execution of the command.
   */
  @Override
  public void execute() {
    provider.checkPageTitle(pageTitle);
  }
}
