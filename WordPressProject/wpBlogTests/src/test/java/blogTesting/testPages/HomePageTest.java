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
 * Tests for home page.
 */
public class HomePageTest {
  private String searchPageFoundTitle;
  private String searchPageNotFoundTitle;
  private WebDriver driver;
  private HomePage homePage;
  private SearchPage searchPage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
    searchPageFoundTitle = "SEARCH RESULTS FOR:";
    searchPageNotFoundTitle = "Nothing Found";
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    homePage = PageFactory.initElements(driver, HomePage.class);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test
  public void testPositiveOpenPostByTitle() throws Exception {
    String postTitle = "One more post";
    CommentPostPage postPage = homePage.openPostByTitle(postTitle);
    assertEquals(postPage.getPostTitle(), postTitle);
  }

  @Test
  public void testNegativeOpenPostByTitle() throws Exception {
    String postTitle = "This post not exists";
    CommentPostPage postPage = homePage.openPostByTitle(postTitle);
    assertNull(postPage);
  }

  @Test
  public void testPositiveSearch() throws Exception {
    String stringToSearch = "post";
    searchPage = homePage.search(stringToSearch);
    String pageTitle = searchPage.getSearchPageTitle();
    assertEquals(pageTitle, searchPageFoundTitle + " " + stringToSearch.toUpperCase());
  }

  @Test
  public void testNegativeSearch() throws Exception {
    searchPage = homePage.search("thisTextWillNotFound");
    String pageTitle = searchPage.getSearchPageTitle();
    assertEquals(pageTitle, searchPageNotFoundTitle);
  }
}