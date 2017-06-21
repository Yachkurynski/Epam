package blogTesting.testPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public class SearchPage {
  private WebDriver driver;

  @FindBy(xpath = "//header[contains(@class, 'header')]/h1[contains(@class, 'title')]")
  private WebElement searchPageIdentifier;

  @FindBy(xpath = "//div[@role = 'main']/article[contains(@id, 'post')]")
  private List<WebElement> foundPosts;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getSearchPageTitle() {
    return searchPageIdentifier.getText();
  }

  public List<WebElement> getFoundPosts() {
    return foundPosts;
  }
}
