package pl.cezarysanecki.blogcode.apiclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequestForFeign;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = SpaceflightNewsConfig.class)
class SpaceflightNewsApiTest {

  @Autowired
  SpaceflightNewsApi spaceflightNewsApi;

  @Test
  void fetchArticlesUsingRestTemplate() {
    // given
    String interestingTitleWord = "rocket";

    // when
    ArticleSearchResponse response = spaceflightNewsApi.searchArticlesUsingRestTemplate(ArticleSearchRequest.defaultLimit(interestingTitleWord));

    // log
    response.results
        .forEach(result -> log.info("RestTemplate - article: {} with launches: {}", result.title, result.launches.size()));

    // then
    assertThat(response.results)
        .allSatisfy(result -> assertThat(result.title).containsIgnoringCase(interestingTitleWord));
  }

  @Test
  void fetchArticlesUsingFeign() {
    // given
    String interestingTitleWord = "rocket";

    // when
    ArticleSearchResponse response = spaceflightNewsApi.searchArticlesUsingFeign(ArticleSearchRequestForFeign.defaultLimit(interestingTitleWord));

    // log
    response.results
        .forEach(result -> log.info("Feign - article: {} with launches: {}", result.title, result.launches.size()));

    // then
    assertThat(response.results)
        .allSatisfy(result -> assertThat(result.title).containsIgnoringCase(interestingTitleWord));
  }

}
