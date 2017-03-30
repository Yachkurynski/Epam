package mailLogin.mailBoxPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Describes page with letters after successful authorization.
 */
public class MailBoxPage {
  private WebDriver driver;
  private WebElement lettersBox;

  /**
   * Creates instance of page.
   * @param driver web driver
   */
  public MailBoxPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns web element which is box with letters.
   * @return box with letters.
   */
  public WebElement getLettersBox() {
    if (lettersBox == null) {
      lettersBox = driver.findElement(By.xpath("//div[@id = 'b-letters']"));
    }
    return lettersBox;
  }
}
