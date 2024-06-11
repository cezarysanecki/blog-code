package pl.cezarysanecki.blogcode.feignclient;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchResponse;

@FeignClient("spaceflightnews-articles")
interface ArticlesProvider {

  @RequestLine("GET /articles")
  @Headers("Content-Type: application/json")
  ArticleSearchResponse searchArticles(@QueryMap ArticleSearchRequest request);

}
