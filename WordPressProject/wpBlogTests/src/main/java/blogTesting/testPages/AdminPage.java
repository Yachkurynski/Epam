package blogTesting.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes POM for admin's page.
 */
public class AdminPage extends UserProfilePage {
  private static final String PROFILE_URL = "http://localhost:8080/wp-admin/profile";

  @FindBy(xpath = "//li[contains(@class, 'menu-icon-post')]/a[@href]")
  @CacheLookup
  private WebElement postsPageButton;

  @FindBy(xpath = "//li[contains(@class, 'menu-icon-users')]/a[@href]")
  @CacheLookup
  private WebElement profilePageButton;

  /**
   * Initialize instance of admin's page.
   * @param driver web-driver.
   * @param profileURL profile's page.
   */
  public AdminPage(WebDriver driver) {
    super(driver);
    driver.get(PROFILE_URL);
  }

  /**
   * Opens page with all the posts.
   * @return instance of page with posts.
   */
  public PostsListPage openPostsListPage() {
    postsPageButton.click();
    return PageFactory.initElements(driver, PostsListPage.class);
  }

  /**
   * Opens page with all the users.
   * @return instance of page with users.
   */
  public UsersListPage openUsersListPage() {
    profilePageButton.click();
    return PageFactory.initElements(driver, UsersListPage.class);
  }

  /**
   * Returns admin's identifier.
   * @return web-element which is admin's identifier.
   */
  @Override
  public WebElement getUserRoleIdentifier() {
    driver.get("http://localhost:8080/wp-admin/profile");
    return super.getUserRoleIdentifier();
  }
}
