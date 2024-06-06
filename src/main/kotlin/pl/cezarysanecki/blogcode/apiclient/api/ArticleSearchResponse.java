package pl.cezarysanecki.blogcode.apiclient.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(force = true)
public class ArticleSearchResponse {

  @JsonProperty("results")
  public final List<Result> results = List.of();

  @NoArgsConstructor(force = true)
  public static class Result {

    @JsonProperty("title")
    public final String title;
    @JsonProperty("summary")
    public final String summary;
    @JsonProperty("news_site")
    public final String newsSite;
    @JsonProperty("published_at")
    public final OffsetDateTime publishedAt;
    @JsonProperty("updated_at")
    public final OffsetDateTime updatedAt;
    @JsonProperty("launches")
    public final List<Launch> launches = List.of();
    @JsonProperty("events")
    public final List<Event> events = List.of();

    @NoArgsConstructor(force = true)
    public static class Event {

      @JsonProperty("event_id")
      public final long eventId;

    }

    @NoArgsConstructor(force = true)
    public static class Launch {

      @JsonProperty("launch_id")
      public final UUID launchId;

    }

  }
}
