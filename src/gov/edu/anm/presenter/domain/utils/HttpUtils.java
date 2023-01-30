package gov.edu.anm.presenter.domain.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

public class HttpUtils {
    private static final int TIMEOUT = 10;

    public static HttpRequest createGetRequestWithBearerAuth(URI uri, String token) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header("Authorization", "Bearer " + token)
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public static HttpRequest createPostRequest(URI uri, Object body, ObjectMapper mapper)
            throws JsonProcessingException {
        return HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)))
                .header("content-type", "application/json")
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public static HttpRequest createPostRequestWithBearerAuth(URI uri, Object body, String token, ObjectMapper mapper)
            throws JsonProcessingException {
        return HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)))
                .header("content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public static HttpRequest createPutRequestWithBearerAuth(URI uri, Object body, String token, ObjectMapper mapper)
            throws JsonProcessingException {
        return HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(body)))
                .header("content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }

    public static HttpRequest createDeleteRequestWithBearerAuth(URI uri, String token) {
        return HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .header("Authorization", "Bearer " + token)
                .timeout(Duration.ofSeconds(TIMEOUT))
                .build();
    }
}
