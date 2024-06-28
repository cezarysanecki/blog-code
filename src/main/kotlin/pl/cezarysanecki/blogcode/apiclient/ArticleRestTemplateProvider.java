package pl.cezarysanecki.blogcode.apiclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

import java.net.URI;

@RequiredArgsConstructor
class ArticleRestTemplateProvider {

  private final RestTemplate restTemplate;
  private final String baseUrl;

  ArticleSearchResponse searchArticles(ArticleSearchRequest request) {
    UriComponents uriComponents = UriComponentsBuilder.newInstance()
        .uri(URI.create(baseUrl))
        .path("/articles")
        .queryParam("limit", request.limit)
        .queryParam("title_contains", request.titleWord)
        .build();
    return restTemplate.getForObject(uriComponents.toUri(), ArticleSearchResponse.class);
  }

}
