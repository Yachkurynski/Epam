package mailLogin.loginPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Describes main login page on mail.ru
 */
public class LoginPage {
  private WebDriver driver;
  private WebElement loginField;
  private WebElement passwordField;
  private WebElement loginButton;

  /**
   * Creates instance of this page.
   * @param driver given web driver
   */
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns web element which is login input field.
   * @return login input field.
   */
  public WebElement getLoginField() {
    if (loginField == null) {
      loginField = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
    }
    return loginField;
  }

  /**
   * Returns web element which is password input field.
   * @return password input field.
   */
  public WebElement getPasswordField() {
    if (passwordField == null) {
      passwordField = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
    }
    return passwordField;
  }

  /**
   * Returns web element which is authorization (login) button.
   * @return login button.
   */
  public WebElement getLoginButton() {
    if (loginButton == null) {
      loginButton = driver.findElement(By.xpath("//input[@id='mailbox__auth__button']"));
    }
    return loginButton;
  }

  /**
   * Performs filling password and login fields by given parameters and than performs authorization.
   * @param login login for authorization.
   * @param password password for authorization.
   */
  public void logIn(String login, String password) {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    getPasswordField().sendKeys(password);
    getLoginField().sendKeys(login);
    getLoginButton().click();
  }
}
