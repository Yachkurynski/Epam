package blogTesting.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Describes POM for page of adding new posts.
 */
public class AddPostPage {
  private WebDriver driver;

  @FindBy(xpath = "//div[@class = 'wrap']/h2")
  @CacheLookup
  private WebElement pageTitle;

  @FindBy(xpath = "//input[@name = 'post_title']")
  @CacheLookup
  private WebElement postTitleField;

  @FindBy(xpath = "//textarea[@name = 'content' and @class = 'wp-editor-area']")
  @CacheLookup
  private WebElement postTextField;

  @FindBy(xpath = "//input[@type = 'submit' and @name = 'publish']")
  @CacheLookup
  private WebElement publishButton;

  @FindBy(xpath = "//div[@id = 'message']/p[contains(text(), 'published')]")
  private WebElement publishedPostIdentifier;

  @FindBy(xpath = "//a[(contains(@class, 'delete')) and (parent::div[contains(@id, 'delete')])]")
  private WebElement deletePublishedPost;

  /**
   * Initialize instance of page.
   * @param driver web-driver.
   */
  public AddPostPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Creates new post with given title and content.
   * @param title post's title.
   * @param text post's content.
   */
  public void addNewPost(String title, String text) {
    postTitleField.sendKeys(title);
    postTextField.sendKeys(text);
    publishButton.click();
  }

  /**
   * Returns web element which identifies that current post is published.
   * @return identifier of published post.
   */
  public WebElement getPublishedPostIdentifier() {
    return publishedPostIdentifier;
  }

  /**
   * Deletes current post.
   */
  public void deletePublishedPost() {
    deletePublishedPost.click();
  }

  /**
   * Returns title of the page.
   * @return page title.
   */
  public String getPageTitle() {
    return pageTitle.getText();
  }
}
