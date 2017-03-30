package mailLogin.failedAuthorizationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Describes page which appears after failed authorization on mail in GoogleChrome.
 */
public class FailedAuthorizationPageChrome extends FailedAuthorizationPage {

  /**
   * Creates instance which describes page.
   * @param driver given web driver.
   */
  public FailedAuthorizationPageChrome (WebDriver driver) {
    super(driver);
  }

  /**
   * Returns web element which is identifier of failed authorization.
   * @return identifier of failed authorization.
   */
  public WebElement getFailIdentifier() {
    if (this.failIdentifier == null) {
      this.failIdentifier = this.driver.findElement(By.xpath("//div[@class='b-login__errors']"));
    }
    return this.failIdentifier;
  }
}
