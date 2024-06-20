package pl.cezarysanecki.blogcode.apiclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@Slf4j
@SpringBootTest(classes = SpaceflightNewsConfig.class)
class SpaceflightNewsApiTest {

  @Autowired
  SpaceflightNewsApi spaceflightNewsApi;

  @Test
  void testApi() {
    ArticleSearchResponse response = spaceflightNewsApi.searchArticles(ArticleSearchRequest.defaultLimit("rocket"));

    response.results
        .forEach(result -> log.info("article: {} with launches: {}", result.title, result.launches.size()));
  }

}
