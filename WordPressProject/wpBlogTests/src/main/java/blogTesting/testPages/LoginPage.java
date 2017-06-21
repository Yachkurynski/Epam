package blogTesting.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Describes POM for login page.
 */
public class LoginPage {
  private WebDriver driver;

  @FindBy(xpath = "//label[@for = 'user_login']/input[@name = 'log']")
  @CacheLookup
  private WebElement userNameField;

  @FindBy(xpath = "//label[@for = 'user_pass']/input[@name = 'pwd']")
  @CacheLookup
  private WebElement passwordField;

  @FindBy(xpath = "//input[@type = 'submit' and contains(@class, 'button')]")
  @CacheLookup
  private WebElement loginButton;

  @FindBy(xpath = "//form[@name = 'loginform']")
  @CacheLookup
  private WebElement loginForm;

  @FindBy(xpath = "//div[contains(@id, 'error')]/")
  private WebElement loginErrorIdentifier;

  /**
   * Initialize instance of login page.
   * @param driver web-driver
   */
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns form for login on the page.
   * @return login form.
   */
  public WebElement getLoginForm() {
    return loginForm;
  }

  /**
   * Returns wrong login identifier which appears after unsuccessful attempt.
   * @return web-element which identifies wrong login.
   */
  public WebElement getLoginErrorIdentifier() {
    return loginErrorIdentifier;
  }

  /**
   * Performs login to the site.
   * @param userName user's name.
   * @param password user's password.
   */
  public void login(String userName, String password) {
    userNameField.sendKeys(userName);
    passwordField.sendKeys(password);
    loginButton.click();
  }
}
