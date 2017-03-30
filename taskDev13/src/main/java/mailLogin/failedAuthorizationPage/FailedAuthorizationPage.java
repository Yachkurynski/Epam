package mailLogin.failedAuthorizationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Parent class for failed authorization pages in all browsers.
 */
public abstract class FailedAuthorizationPage {
  protected WebDriver driver;
  protected WebElement failIdentifier;

  /**
   * Creates instance which describes page.
   * @param driver given web driver.
   */
  public FailedAuthorizationPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns web element which is identifier of failed authorization.
   * @return identifier of failed authorization.
   */
  public abstract WebElement getFailIdentifier();
}
