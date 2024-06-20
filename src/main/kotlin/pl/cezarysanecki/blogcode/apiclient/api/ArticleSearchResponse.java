package pl.cezarysanecki.blogcode.apiclient.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor(force = true)
public class ArticleSearchResponse {

  @JsonProperty("results")
  public final List<Result> results;

  @NoArgsConstructor(force = true)
  public static class Result {

    @JsonProperty("title")
    public final String title;
    @JsonProperty("url")
    public final String url;
    @JsonProperty("summary")
    public final String summary;
    @JsonProperty("published_at")
    public final OffsetDateTime publishedAt;
    @JsonProperty("updated_at")
    public final OffsetDateTime updatedAt;
    @JsonProperty("launches")
    public final List<Launch> launches;
    @JsonProperty("events")
    public final List<Event> events;

    @NoArgsConstructor(force = true)
    public static class Event {

      @JsonProperty("event_id")
      public final int eventId;
      @JsonProperty("provider")
      public final String provider;

    }

    @NoArgsConstructor(force = true)
    public static class Launch {

      @JsonProperty("launch_id")
      public final String launchId;
      @JsonProperty("provider")
      public final String provider;

    }

  }

}
