package websiteSerfer.commands;

import websiteSerfer.PageTestProvider;

/**
 * Checks some reference on the page.
 */
public class CheckLinkByRefCommand extends Command {
  private String hRef;

  /**
   * Creates instance of this command.
   * @param hRef link needed to check.
   * @param provider command provider which allows to perform commands.
   */
  public CheckLinkByRefCommand(String hRef, PageTestProvider provider) {
    this.hRef = hRef;
    this.provider = provider;
  }

  /**
   * Start execution of the command.
   */
  @Override
  public void execute(){
    provider.checkLinkByRef(hRef);
  }
}
