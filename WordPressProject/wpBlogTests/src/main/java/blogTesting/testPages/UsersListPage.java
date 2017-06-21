package blogTesting.testPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Describes POM for page if administrator's profile which contains all the users.
 */
public class UsersListPage {
  WebDriver driver;

  @FindBy(xpath = "//div[@class = 'wrap']/h2")
  @CacheLookup
  private WebElement pageTitle;

  @FindBy(xpath = "//tbody[@id = 'the-list']/tr[contains(@id, 'user')]")
  private List<WebElement> users;

  /**
   * Initialize instance of page.
   * @param driver web-driver.
   */
  public UsersListPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns title of this page.
   * @return page title.
   */
  public String getPageTitle() {
    return pageTitle.getText().trim();
  }

  /**
   * Returns collection with all the users.
   * @return list of users.
   */
  public List<WebElement> getUsers() {
    return users;
  }
}
