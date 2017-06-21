package blogTesting.testPages.commentTests;

import static org.testng.Assert.*;

import blogTesting.dataProviders.CommentsData;
import blogTesting.testPages.CommentPostPage;
import blogTesting.testPages.HomePage;
import java.util.concurrent.TimeUnit;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
public class CommentPostPageTestForUnregisteredUser {
  WebDriver driver;
  CommentPostPage postPage;
  HomePage homePage;

  @BeforeClass
  public void classSetUp() {
    System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @BeforeMethod()
  public void setUpForNotRegisteredUsersTests() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    homePage = PageFactory.initElements(driver, HomePage.class);
    postPage = homePage.openPostByTitle("One more post");
  }

  @Test(dataProvider = "getCommentForNotRegisteredUsers", dataProviderClass = CommentsData.class)
  public void testLeaveCommentForNotRegisteredUser(String userName, String email, String comment)
      throws Exception {
    postPage.leaveCommentForNotRegisteredUser(userName, email, comment);
    assertNotNull(postPage.getCommentErrorIdentifier());
  }

  @Test
  public void testLeaveCommentForNotRegisteredUser() throws Exception {
    postPage.leaveCommentForNotRegisteredUser("user", "eltorto@mail.ru", "comment");
    assertEquals(postPage.getLastCommentText(), "comment");
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }
}
