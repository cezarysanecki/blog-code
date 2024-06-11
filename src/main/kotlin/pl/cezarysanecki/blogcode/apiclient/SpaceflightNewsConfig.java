package pl.cezarysanecki.blogcode.apiclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
class SpaceflightNewsConfig {

  private final RestTemplate restTemplate;

  SpaceflightNewsConfig() {
    restTemplate = new RestTemplate();
  }

  @Bean
  SpaceflightNewsApi spaceflightNewsApi(@Value("${api-client.spaceflight-news-base-url}") String baseUrl) {
    ArticlesProvider articlesProvider = new ArticlesProvider(restTemplate, baseUrl);
    return new SpaceflightNewsApi(articlesProvider);
  }

}
