package blogTesting.testPages.commentTests;

import static blogTesting.testPages.siteDataForTests.siteConstantData.WP_SITE_URL;
import static org.testng.Assert.*;

import blogTesting.dataProviders.CommentsData;
import blogTesting.testPages.CommentPostPage;
import blogTesting.testPages.HomePage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for leaving the comments by unregistered users.
 */
public class CommentPostPageTestForUnregisteredUser {
  private WebDriver driver;
  private CommentPostPage postPage;
  private HomePage homePage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod()
  public void setUpForNotRegisteredUsersTests() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(WP_SITE_URL);

    homePage = PageFactory.initElements(driver, HomePage.class);
    postPage = homePage.openPostByTitle("One more post");
  }

  @Test(dataProvider = "getCommentForNotRegisteredUsers", dataProviderClass = CommentsData.class)
  public void testNegativeLeaveCommentForNotRegisteredUser(String userName, String email, String comment)
      throws Exception {
    postPage.leaveCommentForNotRegisteredUser(userName, email, comment);
    assertNotNull(postPage.getCommentErrorIdentifier());
  }

  @Test
  public void testPositiveLeaveCommentForNotRegisteredUser() throws Exception {
    String commentText = "comment";
    postPage.leaveCommentForNotRegisteredUser("user", "eltorto@mail.ru", commentText);
    assertEquals(postPage.getLastCommentText(), commentText);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }
}
