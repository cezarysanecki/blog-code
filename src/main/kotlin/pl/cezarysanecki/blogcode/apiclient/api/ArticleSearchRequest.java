package pl.cezarysanecki.blogcode.apiclient.api;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleSearchRequest {

  public final int limit;
  public final String titleWord;

  public static ArticleSearchRequest defaultLimit(String titleWord) {
    return new ArticleSearchRequest(10, titleWord);
  }

}
