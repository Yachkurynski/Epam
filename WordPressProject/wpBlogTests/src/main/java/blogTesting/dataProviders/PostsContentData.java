package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for creating new posts.
 */
public class PostsContentData {
  /**
   * Returns data with title and post's content for new posts.
   * @return array of posts' titles and content.
   */
  @DataProvider(name = "getPostData")
  public Object[][] getPostData() {
    return new Object[][] {{"title", "content"}, {"title", ""}, {"", "content"}, {"", ""},
        {"#$%^&", "content"}, {"title", "#$%^&*()"}, {"#$%^&", "%^&*("}};
  }
}
