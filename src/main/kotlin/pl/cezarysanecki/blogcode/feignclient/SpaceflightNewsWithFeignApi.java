package pl.cezarysanecki.blogcode.feignclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchResponse;

@Slf4j
@RequiredArgsConstructor
public class SpaceflightNewsWithFeignApi {

  private final ArticlesProvider articlesProvider;

  public ArticleSearchResponse searchArticles(ArticleSearchRequest request) {
    ArticleSearchResponse response = articlesProvider.searchArticles(request);
    log.info("Found {} articles for request {}", response.results.size(), request);
    return response;
  }

}
