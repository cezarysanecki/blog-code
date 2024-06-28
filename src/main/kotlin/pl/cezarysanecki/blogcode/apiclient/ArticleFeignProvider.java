package pl.cezarysanecki.blogcode.apiclient;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequestForFeign;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@FeignClient("spaceflightnews-articles")
interface ArticleFeignProvider {

  @RequestLine("GET /articles")
  @Headers("Content-Type: application/json")
  ArticleSearchResponse searchArticles(@QueryMap ArticleSearchRequestForFeign request);

}
