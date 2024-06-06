package pl.cezarysanecki.blogcode.apiclient.api;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArticleSearchRequest {

  public final int limit;
  public final String titleSubstring;

  public static ArticleSearchRequest ofDefaultLimit(String titleSubstring) {
    return new ArticleSearchRequest(10, titleSubstring);
  }

  @Override
  public String toString() {
    return "ArticleSearchRequest - limit = " + limit + ", titleSubstring = '" + titleSubstring + '\'';
  }
}
