package blogTesting.testPages;

import blogTesting.testPages.testElements.SearchBar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes POM for home page of site.
 */
public class HomePage {
  private WebDriver driver;
  private SearchBar searchBar;

  @FindBy(xpath = "//div[@role = 'main' and parent::div[@class = 'site-content']]"
      + "/article[contains(@id, 'post')]")
  private List<WebElement> posts;

  @FindBy(xpath = "//a[@title = 'Home' and parent::li[@class = 'current_page_item']]")
  @CacheLookup
  private WebElement homePageIdentifier;

  /**
   * Initialize home page.
   * @param driver web-driver.
   */
  public HomePage(WebDriver driver) {
    this.driver = driver;
    searchBar = PageFactory.initElements(driver, SearchBar.class);
  }

  /**
   * Open post by given title.
   * @param title needed post's title.
   * @return post's page.
   */
  public CommentPostPage openPostByTitle(String title) {
    CommentPostPage postPage = null;

    for(WebElement post : posts) {
      WebElement titleElement = post.findElement(By.xpath("//h1[@class = 'entry-title']/a[@href]"));

      if(title.equals(titleElement.getText())) {
        titleElement.click();
        postPage = PageFactory.initElements(driver, CommentPostPage.class);
        break;
      }
    }
    return postPage;
  }

  /**
   * Returns web-element which identifies home page.
   * @return home page identifier.
   */
  public WebElement getHomePageIdentifier() {
    return homePageIdentifier;
  }

  /**
   * Finds given text in all the posts using search bar.
   * @param text text for searching.
   * @return page with search results.
   */
  public SearchPage search(String text) {
    return searchBar.search(text);
  }
}