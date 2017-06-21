package blogTesting.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Describes POM for user's profile page.
 */
public class UserProfilePage {
  protected WebDriver driver;

  @FindBy(xpath = "//select[@name = 'display_name']/option[@selected = 'selected']")
  protected WebElement userRoleIdentifier;

  /**
   * Initialize instance of page.
   * @param driver web-driver.
   */
  public UserProfilePage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns user's identifier.
   * @return web-element which identifies user.
   */
  public WebElement getUserRoleIdentifier() {
    return userRoleIdentifier;
  }
}
