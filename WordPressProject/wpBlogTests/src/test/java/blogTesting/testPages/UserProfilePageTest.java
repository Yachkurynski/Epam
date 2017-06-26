package blogTesting.testPages;

import static blogTesting.testPages.siteDataForTests.siteConstantData.SUBSCRIBER_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.SUBSCRIBER_PASSWORD;
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
 *
 */
public class UserProfilePageTest {
  private WebDriver driver;
  private UserProfilePage userPage;
  private String expectedRole;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
    expectedRole = "subscriber";
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(WP_SITE_LOGIN_URL);

    (PageFactory.initElements(driver, LoginPage.class)).login(SUBSCRIBER_LOGIN, SUBSCRIBER_PASSWORD);
    userPage = PageFactory.initElements(driver, UserProfilePage.class);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test
  public void testGetUserRoleIdentifier() throws Exception {
    String role = userPage.getUserRoleIdentifier().getText();
    assertEquals(role, expectedRole);
  }
}