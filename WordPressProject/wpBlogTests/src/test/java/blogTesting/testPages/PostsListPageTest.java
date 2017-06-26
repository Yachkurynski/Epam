package blogTesting.testPages;

import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_PASSWORD;
import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_SITE_LOGIN_URL;
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

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(WP_SITE_LOGIN_URL);

    (PageFactory.initElements(driver, LoginPage.class)).login(ADMIN_LOGIN, ADMIN_PASSWORD);
    postsPage = (PageFactory.initElements(driver, AdminPage.class)).openPostsListPage();
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