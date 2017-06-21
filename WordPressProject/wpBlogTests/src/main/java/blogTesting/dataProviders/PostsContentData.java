package blogTesting.dataProviders;

import org.testng.annotations.DataProvider;

/**
 * Data provider for creating new posts.
 */
public class PostsContentData {
  /**
   * Returns data for creating new post. Contains title and post's content which are necessary need.
   * @return array of title and content for new post.
   */
  @DataProvider(name = "getPostData")
  public Object[][] getPostData() {
    return new Object[][] {{"title", "content"}, {"title", ""}, {"", "content"}, {"", ""},
        {"#$%^&", "content"}, {"title", "#$%^&*()"}, {"#$%^&", "%^&*("}};
  }
}
