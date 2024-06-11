package pl.cezarysanecki.blogcode.apiclient.test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.cezarysanecki.blogcode.apiclient.SpaceflightNewsApi;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchRequest;
import pl.cezarysanecki.blogcode.apiclient.api.ArticleSearchResponse;

//@Component
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
