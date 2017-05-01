package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Command for opening web-page.
 */
public class OpenCommand extends Command {
  private String url;
  private long timeout;

  /**
   * Creates instance of this command.
   *
   * @param url url-address of the page needed to open.
   * @param timeout timeout for opening page.
   * @param provider command provider which allows to perform commands.
   */
  public OpenCommand(String url, long timeout, PageTestProvider provider) {
    this.url = url;
    this.timeout = timeout;
    this.provider = provider;
  }

  /**
   * Start execution of the command.
   */
  @Override
  public void execute() {
    provider.openPage(url, timeout);
  }
}
