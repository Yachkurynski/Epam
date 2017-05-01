package loginTests;

import static org.junit.Assert.assertNotNull;

import mailLogin.WrongAuthorizationData;
import mailLogin.failedAuthorizationPage.FailedAuthorizationPage;
import mailLogin.failedAuthorizationPage.FailedAuthorizationPageChrome;
import mailLogin.loginPage.LoginPage;
import mailLogin.mailBoxPage.MailBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for login for "mail.ru".
 */
public class ChromeLoginTest {
  private static final String MAIL_RU = "http://mail.ru";
  private WebDriver chrome;
  private LoginPage loginPage;
  private FailedAuthorizationPage failPage;
  private MailBoxPage mailsPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
    chrome = new ChromeDriver();
    chrome.get(MAIL_RU);
    loginPage = new LoginPage(chrome);
  }

  @AfterMethod
  public void tearDown() {
    chrome.close();
    chrome.quit();
  }

  @Test
  public void testPositiveLogin() {
    String login = "tat-dev13";
    String password = "23.03.2017";
    loginPage.logIn(login, password);

    mailsPage = new MailBoxPage(chrome);
    WebElement actual = mailsPage.getLettersBox();

    assertNotNull(actual);
  }

  @Test(dataProvider = "dataForNegativeAuthorization", dataProviderClass =
      WrongAuthorizationData.class)
  public void testNegativeLogin(String login, String password) {
    loginPage.logIn(login, password);

    failPage = new FailedAuthorizationPageChrome(chrome);
    WebElement actual = failPage.getFailIdentifier();

    assertNotNull(actual);
  }
}