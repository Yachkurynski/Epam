package blogTesting.testPages;

import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_LOGIN;
import static blogTesting.testPages.siteDataForTests.siteConstantData.ADMIN_PASSWORD;
import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_ADD_POST_PAGE_URL;
import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_SITE_LOGIN_URL;
import static org.testng.Assert.*;

import blogTesting.dataProviders.PostsContentData;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for page which allows to add new posts.
 */
public class AddPostPageTest {
  private WebDriver driver;
  private AddPostPage addPostPage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(WP_SITE_LOGIN_URL);

    (PageFactory.initElements(driver, LoginPage.class)).login(ADMIN_LOGIN, ADMIN_PASSWORD);
    driver.get(WP_ADD_POST_PAGE_URL);
    addPostPage = PageFactory.initElements(driver, AddPostPage.class);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    addPostPage.deletePublishedPost();
    driver.close();
    driver.quit();
  }

  @Test(dataProvider = "getPostData", dataProviderClass = PostsContentData.class)
  public void testAddNewPost(String title, String content) throws Exception {
    addPostPage.addNewPost(title, content);
    WebElement publishedPostIdentifier = addPostPage.getPublishedPostIdentifier();
    assertNotNull(publishedPostIdentifier);
  }
}