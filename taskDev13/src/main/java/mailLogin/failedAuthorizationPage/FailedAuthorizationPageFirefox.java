package mailLogin.failedAuthorizationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Describes page which appears after failed authorization on mail in Firefox.
 */
public class FailedAuthorizationPageFirefox extends FailedAuthorizationPage {

  /**
   * Creates instance which describes page.
   * @param driver given web driver.
   */
  public FailedAuthorizationPageFirefox(WebDriver driver) {
    super(driver);
  }

  /**
   * Returns web element which is identifier of failed authorization.
   * @return identifier of failed authorization.
   */
  public WebElement getFailIdentifier() {
    if (this.failIdentifier == null) {
      failIdentifier = this.driver.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));
    }
    return failIdentifier;
  }
}
