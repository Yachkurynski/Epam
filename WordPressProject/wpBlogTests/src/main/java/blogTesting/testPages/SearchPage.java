package blogTesting.testPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes POM for page with search results.
 */
public class SearchPage {
  private WebDriver driver;

  @FindBy(xpath = "//header[contains(@class, 'header')]/h1[contains(@class, 'title')]")
  private WebElement searchPageIdentifier;

  @FindBy(xpath = "//div[@role = 'main']/article[contains(@id, 'post')]")
  private List<WebElement> foundPosts;

  /**
   * Initialize instance of page.
   * @param driver web-driver.
   */
  public SearchPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Returns title of current page.
   * @return page title.
   */
  public String getSearchPageTitle() {
    return searchPageIdentifier.getText();
  }

  /**
   * Returns collection of posts.
   * @return list with posts.
   */
  public List<WebElement> getFoundPosts() {
    return foundPosts;
  }

  /**
   * Open post by given title.
   * @param title needed post's title.
   * @return post's page.
   */
  public CommentPostPage openPostByTitle(String title) {
    CommentPostPage postPage = null;

    for(WebElement post : foundPosts) {
      WebElement titleElement = post.findElement(By.xpath("//h1[@class = 'entry-title']/a[@href]"));

      if(title.equals(titleElement.getText())) {
        titleElement.click();
        postPage = PageFactory.initElements(driver, CommentPostPage.class);
        break;
      }
    }
    return postPage;
  }
}
