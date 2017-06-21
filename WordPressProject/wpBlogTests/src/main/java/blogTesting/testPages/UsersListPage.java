package blogTesting.testPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class UsersListPage {
  WebDriver driver;

  @FindBy(xpath = "//div[@class = 'wrap']/h2")
  @CacheLookup
  private WebElement pageTitle;

  @FindBy(xpath = "//tbody[@id = 'the-list']/tr[contains(@id, 'user')]")
  private List<WebElement> users;

  public UsersListPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getPageTitle() {
    return pageTitle.getText().trim();
  }

  public List<WebElement> getUsers() {
    return users;
  }
}
