package pl.cezarysanecki.blogcode.feignclient.test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.cezarysanecki.blogcode.feignclient.SpaceflightNewsApi;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.feignclient.api.ArticleSearchResponse;

@Component
@RequiredArgsConstructor
public class SpaceflightNewsRunner implements CommandLineRunner {

  private final SpaceflightNewsApi spaceflightNewsApi;

  @Override
  public void run(String... args) {
    ArticleSearchResponse response = spaceflightNewsApi.searchArticles(ArticleSearchRequest.ofDefaultLimit("rocket"));

    response.results.forEach(result -> {
      System.out.println(result.title + " [" + result.newsSite + "] - launches: " + result.launches.size() + " and events: " + result.events.size());
    });
  }

}
