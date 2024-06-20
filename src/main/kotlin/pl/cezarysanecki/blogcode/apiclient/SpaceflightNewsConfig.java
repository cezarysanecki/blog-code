package pl.cezarysanecki.blogcode.apiclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class SpaceflightNewsConfig {

  private final RestTemplate restTemplate;

  SpaceflightNewsConfig() {
    this.restTemplate = new RestTemplate();
  }

  @Bean
  SpaceflightNewsApi spaceflightNewsApi(@Value("${spaceflightnews.article.url}") String url) {
    ArticleProvider articleProvider = new ArticleProvider(
        restTemplate,
        url);
    return new SpaceflightNewsApi(articleProvider);
  }

}
