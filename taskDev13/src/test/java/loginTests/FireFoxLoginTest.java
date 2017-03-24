package loginTests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 */
public class FireFoxLoginTest {
  WebDriver fireFox;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
    fireFox = new FirefoxDriver();
  }

  @After
  public void tearDown() {
    fireFox.close();
    fireFox.quit();
  }

  @Test
  public void testPositiveLogin() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("tat-dev13");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("23.03.2017");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'b_letters']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeWrongLogin() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("tat-13");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("23.03.2017");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeWrongPassword() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("tat-dev13");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("2333333");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeLoginWithSpecialSymbols() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("@lto^#");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("128ve980");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeLoginWithCyrillicSymbols() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("почта");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("128ve980");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeEmptyLogin() {
    fireFox.navigate().to("http://mail.ru");

    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys("");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("128ve980");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }

  @Test
  public void testNegativeBigLogin() {
    fireFox.navigate().to("http://mail.ru");
    String login = "ItsAVeryBigLoginForCheckingHowDoesTheSystemReactToSuchLogin";
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__login']")).sendKeys(login);
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__password']")).sendKeys("128ve980");
    fireFox.findElement(By.xpath("//div[@id = 'mailbox']//input[@id='mailbox__auth__button']")).click();

    WebElement actual = fireFox.findElement(By.xpath("//div[@id = 'mailbox:authfail']"));

    assertNotNull(actual);
  }
}
