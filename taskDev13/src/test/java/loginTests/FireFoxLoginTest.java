package loginTests;

import static org.junit.Assert.assertNotNull;

import mailLogin.WrongAuthorizationData;
import mailLogin.failedAuthorizationPage.FailedAuthorizationPage;
import mailLogin.failedAuthorizationPage.FailedAuthorizationPageFirefox;
import mailLogin.loginPage.LoginPage;
import mailLogin.mailBoxPage.MailBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test for login for "mail.ru".
 */
public class FireFoxLoginTest {
  private static final String MAIL_RU = "http://mail.ru";
  private WebDriver fireFox;
  private LoginPage loginPage;
  private MailBoxPage mailsPage;
  private FailedAuthorizationPage failPage;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
    fireFox = new FirefoxDriver();
    fireFox.get(MAIL_RU);
    loginPage = new LoginPage(fireFox);
  }

  @AfterMethod
  public void tearDown() {
    fireFox.close();
    fireFox.quit();
  }

  @Test
  public void testPositiveLogin() {
    loginPage.logIn("tat-dev13", "23.03.2017");

    mailsPage = new MailBoxPage(fireFox);
    WebElement actual = mailsPage.getLettersBox();

    assertNotNull(actual);
  }

  @Test (dataProvider = "dataForNegativeAuthorization", dataProviderClass =
      WrongAuthorizationData.class)
  public void testNegativeLogin(String login, String password) {
    loginPage.logIn(login, password);

    failPage = new FailedAuthorizationPageFirefox(fireFox);
    WebElement actual = failPage.getFailIdentifier();

    assertNotNull(actual);
  }

}