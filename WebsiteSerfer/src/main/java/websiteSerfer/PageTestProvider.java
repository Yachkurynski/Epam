package websiteSerfer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Command provider which allows to perform commands.
 */
public class PageTestProvider {
  private WebDriver driver;

  /**
   * Creates instance of provider.
   * @param driver web-driver.
   */
  public PageTestProvider(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Opens web-page with some timeout.
   * @param url needed web-page.
   * @param timeout timeout.
   */
  public void openPage(String url, long timeout) {
    driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    driver.get(url);
  }

  /**
   * Compares given title with current web-page's title.
   * @param pageTitle expected title.
   */
  public void checkPageTitle(String pageTitle) {
    String title = driver.getTitle();

    if (!title.equals(pageTitle)) {
      throw new NoSuchElementException("Expected title: " + pageTitle + "\n Actual title: " +
          title);
    }
  }

  /**
   * Checks does the current web-page contain some text or not.
   * @param pageContent expected text.
   */
  public void checkPageContent(String pageContent) {
    driver.findElement(By.xpath("//*[contains(text(),'" + pageContent + "')]"));
  }

  /**
   * Checks does the current page contains link with such name or not.
   * @param linkName expected link name.
   */
  public void checkLinkByName(String linkName) {
    driver.findElement(By.xpath("//*[contains(text(),'" + linkName + "')]"));
  }

  /**
   * Checks does the current page contains link with such reference or not.
   * @param hRef expected reference.
   */
  public void checkLinkByRef(String hRef) {
    driver.findElement(By.xpath("//*[contains(href,'" + hRef + "')]"));
  }

  /**
   * Closes current web-driver.
   */
  public void closeSource(){
    driver.quit();
  }
}
