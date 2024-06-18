package pl.cezarysanecki.blogcode.feignclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchResponse;

@SpringBootTest(classes = SpaceflightNewsWithFeignConfig.class)
class SpaceflightNewsWithFeignApiTest {

  @Autowired
  SpaceflightNewsWithFeignApi spaceflightNewsWithFeignApi;

  @Test
  void runApi() {
    ArticleSearchResponse response = spaceflightNewsWithFeignApi.searchArticles(ArticleSearchRequest.ofDefaultLimit("rocket"));

    response.results.forEach(result ->
        System.out.println(
            result.title + " [" + result.newsSite + "] - launches: " + result.launches.size() + " and events: " + result.events.size()));
  }

}
