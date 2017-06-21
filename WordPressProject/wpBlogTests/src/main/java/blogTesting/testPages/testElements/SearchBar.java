package blogTesting.testPages.testElements;

import blogTesting.testPages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes search bar web-element on the page. Consist of textfield and submit button.
 */
public class SearchBar {
  private WebDriver driver;

  @FindBy(xpath = "//form[@role = 'search']//input[@type = 'text']")
  @CacheLookup
  private WebElement searchTextField;

  @FindBy(xpath = "//form[@role = 'search']//input[@type = 'submit']")
  @CacheLookup
  private WebElement searchButton;

  /**
   * Initialize instance of search bar.
   * @param driver web-driver.
   */
  public SearchBar(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Finds given text in posts using search bar.
   * @param text text for searching.
   * @return page with search results.
   */
  public SearchPage search(String text) {
    searchTextField.sendKeys(text);
    searchButton.click();
    return PageFactory.initElements(driver, SearchPage.class);
  }
}
