package pl.cezarysanecki.blogcode.apiclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

@SpringBootTest(classes = SpaceflightNewsConfig.class)
class SpaceflightNewsApiTest {

  @Autowired
  SpaceflightNewsApi spaceflightNewsApi;

  @Test
  void runApi() {
    ArticleSearchResponse response = spaceflightNewsApi.searchArticles(ArticleSearchRequest.ofDefaultLimit("rocket"));

    response.results.forEach(result ->
        System.out.println(
            result.title + " [" + result.newsSite + "] - launches: " + result.launches.size() + " and events: " + result.events.size()));
  }

}
