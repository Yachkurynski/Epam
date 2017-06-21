package blogTesting.testPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describes POM for page with all the posts in administrator's profile.
 */
public class PostsListPage {
  private WebDriver driver;

  @FindBy(xpath = "//table[contains(@class, 'posts')]/tbody[@id]/tr")
  private List<WebElement> posts;

  @FindBy(xpath = "//h2[contains(text(), 'Posts')]/a[contains(@class, 'add-new-h2')]")
  @CacheLookup
  private WebElement addPostButton;

  @FindBy(xpath = "//div[@class = 'wrap']/h2")
  @CacheLookup
  private WebElement pageTitle;

  public static class EditPostPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'submitbox']//a[contains(@class, 'submitdelete')]")
    @CacheLookup
    private WebElement deletePostButton;

    @FindBy(xpath = "//span[contains(@id, 'view-post')]/a[@href]")
    @CacheLookup
    private WebElement openPostButton;

    public EditPostPage(WebDriver driver) {
      this.driver = driver;
    }

    public void deletePost() {
      deletePostButton.click();
    }

    public CommentPostPage openPost() {
      openPostButton.click();
      return PageFactory.initElements(driver, CommentPostPage.class);
    }
  }

  /**
   * Initialize page with all the posts.
   * @param driver web-driver.
   */
  public PostsListPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Opens post by given title.
   * @param title needed post title.
   * @return page with needed post.
   */
  public CommentPostPage openPostByTitle(String title) throws InterruptedException {
    CommentPostPage postPage = null;

    for(WebElement post : posts) {
      WebElement postTitle = post.findElement(By.xpath("./td[contains(@class, 'post-title')]"
          + "//a[@class = 'row-title']"));

      System.out.println(title + " --- " + postTitle.getText());
      if(title.equals(postTitle.getText())) {
        postTitle.click();
        EditPostPage editPage = PageFactory.initElements(driver, EditPostPage.class);
        postPage = editPage.openPost();
        break;
      }
    }
    return postPage;
  }

  /**
   * Opens page witch allows to add new post.
   * @return page for adding post.
   */
  public AddPostPage addNewPost() {
    addPostButton.click();
    return PageFactory.initElements(driver, AddPostPage.class);
  }

  /**
   * Returns title of the page.
   * @return page title.
   */
  public String getPageTitle() {
    return pageTitle.getText();
  }

  /**
   * Deletes post by given title.
   * @param title post's title.
   */
  public void deletePostByTitle(String title) {
    for(WebElement post : posts) {
      WebElement postTitle = post.findElement(By.xpath("./td[contains(@class, 'post-title')]"
          + "//a[@class = 'row-title']"));

      System.out.println(postTitle.getText());
      System.out.println(title);

      if(title.equals(postTitle.getText())) {
        postTitle.click();
        EditPostPage editPostPage = PageFactory.initElements(driver, EditPostPage.class);
        editPostPage.deletePost();
        break;
      }
    }
  }
}