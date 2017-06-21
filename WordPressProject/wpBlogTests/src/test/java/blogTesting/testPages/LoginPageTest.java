package blogTesting.testPages;

import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_PASSWORD;
import static blogTesting.testPages.siteDataForTests.siteConstantData.SUBSCRIBER_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.SUBSCRIBER_PASSWORD;
import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_SITE_LOGIN_URL;
import static org.testng.Assert.*;

import blogTesting.dataProviders.WrongLoginData;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for login page.
 */
public class LoginPageTest {
  private WebDriver driver;
  private LoginPage loginPage;
  private UserProfilePage userPage;
  private String expectedRole;
  private WebElement errorLoginIdentifier;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(WP_SITE_LOGIN_URL);
    loginPage = PageFactory.initElements(driver, LoginPage.class);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test
  public void testGetLoginForm() throws Exception {
    assertNotNull(loginPage.getLoginForm());
  }

  @Test
  public void testPositiveAdminLogin() throws Exception {
    loginPage.login(ADMIN_LOGIN, ADMIN_PASSWORD);
    userPage = PageFactory.initElements(driver, AdminPage.class);
    expectedRole = userPage.getUserRoleIdentifier().getText();

    assertEquals(expectedRole, "admin");
  }

  @Test
  public void testPositiveSubscriberLogin() throws Exception {
    loginPage.login(SUBSCRIBER_LOGIN, SUBSCRIBER_PASSWORD);
    userPage = PageFactory.initElements(driver, UserProfilePage.class);
    expectedRole = userPage.getUserRoleIdentifier().getText();

    assertEquals(expectedRole, "subscriber");
  }

  @Test(dataProvider = "getWrongAdminLoginData", dataProviderClass = WrongLoginData.class)
  public void testNegativeAdminLogin(String login, String password) throws Exception {
    loginPage.login(login, password);
    errorLoginIdentifier = loginPage.getLoginErrorIdentifier();

    assertNotNull(errorLoginIdentifier);
  }

  @Test(dataProvider = "getWrongSubscriberLoginData", dataProviderClass = WrongLoginData.class)
  public void testNegativeSubscriberLogin(String login, String password) throws Exception {
    loginPage.login(login, password);
    errorLoginIdentifier = loginPage.getLoginErrorIdentifier();

    assertNotNull(errorLoginIdentifier);
  }
}