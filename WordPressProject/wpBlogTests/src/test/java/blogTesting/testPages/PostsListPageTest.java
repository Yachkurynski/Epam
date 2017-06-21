package blogTesting.testPages;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for page with all the post in administrator's profile.
 */
public class PostsListPageTest {
  private String postTitle;
  private WebDriver driver;
  private PostsListPage postsPage;
  private LoginPage loginPage;
  private AdminPage adminPage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/wp-admin");
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.login("admin", "testsForWp");
    adminPage = PageFactory.initElements(driver, AdminPage.class);
    postsPage = adminPage.openPostsListPage();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test
  public void testPositiveOpenPostByTitle() throws Exception {
    postTitle = "One more post";
    CommentPostPage postPage = postsPage.openPostByTitle(postTitle);
    assertEquals(postPage.getPostTitle(), postTitle);
  }

  @Test
  public void testNegativeOpenPostByTitle() throws Exception {
    postTitle = "Second post";
    CommentPostPage postPage = postsPage.openPostByTitle(postTitle);
    assertNull(postPage);
  }

  @Test
  public void testAddNewPost() throws Exception {
    AddPostPage addPostPage = postsPage.addNewPost();
    assertEquals(addPostPage.getPageTitle(), "Add New Post");
  }

  @Test
  public void testGetPageTitle() throws Exception {
    String actualTitle = postsPage.getPageTitle();
    String expectedTitle = "Posts Add New";
    assertEquals(expectedTitle, actualTitle);
  }

  @Test
  public void testDeletePost() throws Exception {
    postsPage.deletePostByTitle("MyFirstPostOnWP");
    CommentPostPage post = postsPage.openPostByTitle("MyFirstPostOnWP");
    assertNull(post);
  }
}