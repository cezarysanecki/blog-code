package pl.cezarysanecki.blogcode.apiclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequestForFeign;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@Slf4j
@RequiredArgsConstructor
public class SpaceflightNewsApi {

  private final ArticleRestTemplateProvider articleRestTemplateProvider;
  private final ArticleFeignProvider articleFeignProvider;

  public ArticleSearchResponse searchArticlesUsingRestTemplate(ArticleSearchRequest request) {
    ArticleSearchResponse response = articleRestTemplateProvider.searchArticles(request);
    log.info("number of articles is {}", response.results.size());
    return response;
  }

  public ArticleSearchResponse searchArticlesUsingFeign(ArticleSearchRequestForFeign request) {
    ArticleSearchResponse response = articleFeignProvider.searchArticles(request);
    log.info("number of articles is {}", response.results.size());
    return response;
  }

}
