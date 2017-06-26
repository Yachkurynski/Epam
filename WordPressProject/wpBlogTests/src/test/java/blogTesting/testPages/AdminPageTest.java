package blogTesting.testPages;

import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_PASSWORD;
import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_SITE_LOGIN_URL;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for admin's page.
 */
public class AdminPageTest {
  private WebDriver driver;
  private AdminPage adminPage;
  private String expectedRole;
  private String expectedTitle;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
    expectedRole = "admin";
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(WP_SITE_LOGIN_URL);

    (PageFactory.initElements(driver, LoginPage.class)).login(ADMIN_LOGIN, ADMIN_PASSWORD);
    adminPage = PageFactory.initElements(driver, AdminPage.class);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test
  public void testOpenPostsListPage() throws Exception {
    expectedTitle = "Posts Add New";

    PostsListPage postsPage = adminPage.openPostsListPage();
    String title = postsPage.getPageTitle();
    assertEquals(title, expectedTitle);
  }

  @Test
  public void testOpenUsersListPage() throws Exception {
    expectedTitle = "Users Add New";

    UsersListPage usersPage = adminPage.openUsersListPage();
    String title = usersPage.getPageTitle();
    assertEquals(title, expectedTitle);
  }

  @Test
  public void testGetUserRoleIdentifier() throws Exception {
    String role = adminPage.getUserRoleIdentifier().getText();
    assertEquals(role, expectedRole);
  }
}