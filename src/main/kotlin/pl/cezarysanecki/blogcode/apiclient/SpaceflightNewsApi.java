package pl.cezarysanecki.blogcode.apiclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@Slf4j
@RequiredArgsConstructor
public class SpaceflightNewsApi {

  private final ArticlesProvider articlesProvider;

  public ArticleSearchResponse searchArticles(ArticleSearchRequest request) {
    ArticleSearchResponse response = articlesProvider.searchArticles(request);
    log.info("Found {} articles for request {}", response.results.size(), request);
    return response;
  }

}
