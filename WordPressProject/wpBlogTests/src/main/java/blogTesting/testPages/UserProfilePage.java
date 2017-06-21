package blogTesting.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class UserProfilePage {
  protected WebDriver driver;

  @FindBy(xpath = "//select[@name = 'display_name']/option[@selected = 'selected']")
  protected WebElement userRoleIdentifier;

  public UserProfilePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getUserRoleIdentifier() {
    return userRoleIdentifier;
  }
}
