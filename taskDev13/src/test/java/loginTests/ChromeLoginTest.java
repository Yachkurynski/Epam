package loginTests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Tests for login for "mail.ru".
 */
public class ChromeLoginTest {
  WebDriver chrome;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
    chrome = new ChromeDriver();
  }

  @After
  public void tearDown() {
    chrome.close();
    chrome.quit();
  }

  @Test
  public void testPositiveLogin() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("tat-dev13");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@id = 'b_letters']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeWrongLogin() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("tat-13");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeWrongPassword() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("tat-dev13");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23...2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeLoginWithSpecialSymbols() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("t@t-d#v!%");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeLoginWithCyrillicSymbols() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("почта");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeEmptyLogin() {
    chrome.get("http://mail.ru");

    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys("");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeBigLogin() {
    chrome.get("http://mail.ru");
    String login = "ItsAVeryBigLoginForCheckingHowDoesTheSystemReactToSuchLongLogin";
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']"))
        .sendKeys(login);
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']"))
        .sendKeys("23.03.2017");
    chrome.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']"))
        .click();

    WebElement actual = chrome.findElement(By.xpath("//div[@class='b-login__errors']"));

    assertNotNull(actual);
  }
}
