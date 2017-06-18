package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Checks some link name.
 */
public class CheckLinkByNameCommand extends Command {
  private String linkName;

  /**
   * Creates instance of this command.
   * @param linkName name of link needed to check.
   * @param provider command provider which allows to perform commands.
   */
  public CheckLinkByNameCommand(String linkName, PageTestProvider provider) {
    this.linkName = linkName;
    this.provider = provider;
  }

  /**
   * Start execution of the command.
   */
  @Override
  public void execute() {
    provider.checkLinkByName(linkName);
  }
}
