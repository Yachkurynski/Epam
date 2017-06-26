package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for leaving the comments for posts.
 */
public class CommentsData {

  /**
   * Provides data for leaving comments for registered users. Contains only comment content.
   * @return text for comments.
   */
  @DataProvider(name = "getCommentForRegisteredUsers")
  public Object[][] getCommentForRegisteredUsers() {
    return new Object[][] {{"some ccomment"}, {"#c$%^&*("}, {"123456"}};
  }

  /**
   * Provides data for leaving comments for unregistered users. There are commentator's name,
   * his(her) email and comment content which are necessary need.
   * @return data for leaving comments.
   */
  @DataProvider(name = "getCommentForNotRegisteredUsers")
  public Object[][] getCommentForNotRegisteredUsers() {
    return new Object[][] {{"","eltorto@mail.ru","some comment"},
        {"name","","some comment"},
        {"name","$%^&","some comment"},
        {"name","eltorto","some comment"},
        {"name","eltorto@mail.ru",""}};
  }
}
