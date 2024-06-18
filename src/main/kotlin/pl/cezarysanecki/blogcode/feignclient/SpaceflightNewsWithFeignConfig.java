package pl.cezarysanecki.blogcode.feignclient;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
class SpaceflightNewsWithFeignConfig {

  @Bean
  SpaceflightNewsWithFeignApi spaceflightNewsWithFeignApi(@Value("${api-client.spaceflight-news-base-url}") String baseUrl) {
    ArticlesProvider articlesProvider = Feign.builder()
        .encoder(new JacksonEncoder(List.of(new JavaTimeModule())))
        .decoder(new JacksonDecoder(List.of(new JavaTimeModule())))
        .logger(new Slf4jLogger(ArticlesProvider.class))
        .logLevel(Logger.Level.FULL)
        .target(ArticlesProvider.class, baseUrl);
    return new SpaceflightNewsWithFeignApi(articlesProvider);
  }

}
