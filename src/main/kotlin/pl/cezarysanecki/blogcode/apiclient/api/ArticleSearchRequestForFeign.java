package pl.cezarysanecki.blogcode.apiclient.api;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleSearchRequestForFeign {

  public final int limit;
  public final String title_contains;

  public static ArticleSearchRequestForFeign defaultLimit(String titleWord) {
    return new ArticleSearchRequestForFeign(10, titleWord);
  }

}
