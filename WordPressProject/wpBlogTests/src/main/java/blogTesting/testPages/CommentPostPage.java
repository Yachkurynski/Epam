package blogTesting.testPages;

import blogTesting.testPages.testElements.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes POM for post's page which allows to leave the comment.
 */
public class CommentPostPage {
  private WebDriver driver;
  private SearchBar searchBar;

  @FindBy(xpath = "//header[@class = 'entry-header']/h1[@class = 'entry-title']")
  private WebElement postTitleElement;

  @FindBy(xpath = "//p[contains(@class, 'comment-form')]/input[@name = 'author']")
  @CacheLookup
  private WebElement commentatorNameField;

  @FindBy(xpath = "//p[contains(@class, 'comment-form')]/input[@name = 'email']")
  @CacheLookup
  private WebElement commentatorEmailField;

  @FindBy(xpath = "//p[contains(@class, 'comment-form')]/textarea[@name = 'comment']")
  @CacheLookup
  private WebElement commentField;

  @FindBy(xpath = "//p[contains(@class, 'submit')]/input[@name = 'submit']")
  @CacheLookup
  private WebElement postButton;

  @FindBy(xpath = "//ol[@class = 'commentlist']/li[last()]//section[contains(@class, 'content')]/p")
  private WebElement lastComment;

  /**
   * Initialize instance of post page.
   * @param driver web-driver.
   */
  public CommentPostPage(WebDriver driver) {
    this.driver = driver;
    searchBar = PageFactory.initElements(driver, SearchBar.class);
  }

  /**
   * Allows to leave the comment for unauthorized user.
   * @param name user's name.
   * @param email user's email.
   * @param comment user's comment.
   */
  public void leaveCommentForNotRegisteredUser(String name, String email, String comment) {
    commentatorNameField.sendKeys(name);
    commentatorEmailField.sendKeys(email);
    commentField.sendKeys(comment);
    postButton.click();
  }

  /**
   * Allows to leave the comment for authorized user.
   * @param comment user's comment.
   */
  public void leaveCommentForRegisteredUser(String comment) {
    commentField.sendKeys(comment);
    postButton.click();
  }

  /**
   * Returns content of last comment.
   * @return last comment.
   */
  public String getLastCommentText() {
    return lastComment.getText();
  }

  /**
   * Returns web-element which identifies comment leaving error (for example, incorrect data enter).
   * @return comment leaving error identifier.
   */
  public WebElement getCommentErrorIdentifier() {
    return driver.findElement(By.xpath("//body[@id = 'error-page']"));
  }

  /**
   * Return title of post.
   * @return post's title.
   */
  public String getPostTitle() {
    return postTitleElement.getText();
  }

  /**
   * Finds given text in posts using search bar.
   * @param text text for searching.
   * @return page with search results.
   */
  public SearchPage search(String text) {
    return searchBar.search(text);
  }
}