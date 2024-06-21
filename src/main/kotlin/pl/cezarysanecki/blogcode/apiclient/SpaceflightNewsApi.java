package pl.cezarysanecki.blogcode.apiclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@Slf4j
@RequiredArgsConstructor
public class SpaceflightNewsApi {

  private final ArticleProvider articleProvider;

  public ArticleSearchResponse searchArticles(ArticleSearchRequest request) {
    ArticleSearchResponse response = articleProvider.searchArticles(request);
    log.info("number of articles is {}", response.results.size());
    return response;
  }

}
