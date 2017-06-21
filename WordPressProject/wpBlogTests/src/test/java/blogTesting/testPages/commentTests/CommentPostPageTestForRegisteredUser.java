package blogTesting.testPages.commentTests;

import static org.testng.Assert.*;

import blogTesting.dataProviders.CommentsData;
import blogTesting.testPages.CommentPostPage;
import blogTesting.testPages.HomePage;
import blogTesting.testPages.LoginPage;
import java.util.concurrent.TimeUnit;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for leaving the comments by registered users.
 */
public class CommentPostPageTestForRegisteredUser {
  private WebDriver driver;
  private CommentPostPage postPage;
  private HomePage homePage;
  private LoginPage loginPage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod()
  public void setUpForRegisteredUsersTests() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/wp-admin");
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    loginPage.login("admin", "testsForWp");
    driver.get("http://localhost:8080/");
    homePage = PageFactory.initElements(driver, HomePage.class);
    postPage = homePage.openPostByTitle("One more post");
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

  @Test(dataProvider = "getCommentForRegisteredUsers", dataProviderClass = CommentsData.class)
  public void testLeaveCommentForRegisteredUser(String comment) throws Exception {
    postPage.leaveCommentForRegisteredUser(comment);
    assertEquals(postPage.getLastCommentText(), comment);
  }

  @Test
  public void testNegativeLeavingCommentForRegisteredUsers() throws Exception {
    postPage.leaveCommentForRegisteredUser("");
    assertNotNull(postPage.getCommentErrorIdentifier());
  }
}