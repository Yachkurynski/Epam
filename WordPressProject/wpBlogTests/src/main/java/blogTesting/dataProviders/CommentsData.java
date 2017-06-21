package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for leaving the comments.
 */
public class CommentsData {

  /**
   * Provides data which are comments for registered users.
   * @return comments.
   */
  @DataProvider(name = "getCommentForRegisteredUsers")
  public Object[][] getCommentForRegisteredUsers() {
    return new Object[][] {{"some ccomment"}, {"#c$%^&*("}, {"123456"}};
  }

  /**
   * Provides data for leaving comments for unregistered users: name, email and comment.
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
