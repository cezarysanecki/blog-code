package pl.cezarysanecki.blogcode.apiclient;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
class SpaceflightNewsConfig {

  private final RestTemplate restTemplate;

  SpaceflightNewsConfig() {
    this.restTemplate = new RestTemplate();
  }

  @Bean
  SpaceflightNewsApi spaceflightNewsApi(@Value("${spaceflightnews.article.url}") String url) {
    ArticleRestTemplateProvider articleRestTemplateProvider = new ArticleRestTemplateProvider(
        restTemplate, url);
    ArticleFeignProvider articleFeignProvider = Feign.builder()
        .encoder(new JacksonEncoder(List.of(new JavaTimeModule())))
        .decoder(new JacksonDecoder(List.of(new JavaTimeModule())))
        .logger(new Slf4jLogger(ArticleFeignProvider.class))
        .logLevel(Logger.Level.FULL)
        .target(ArticleFeignProvider.class, url);

    return new SpaceflightNewsApi(
        articleRestTemplateProvider,
        articleFeignProvider);
  }

}
