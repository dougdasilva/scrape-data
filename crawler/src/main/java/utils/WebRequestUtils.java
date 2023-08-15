package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebRequestUtils {

    protected static HttpClient client;

    protected static HttpResponse<String> response;

    protected static HttpRequest request;

    protected static String sessionUrl;

    public static HttpResponse<String> get() {
        try {
            client = HttpClient.newBuilder().build();
            request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create(sessionUrl))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Failed request", e);
        }
    }

    public static HttpResponse<String> post(String payload) {
        try {
            client = HttpClient.newBuilder().build();
            request = HttpRequest
                    .newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .uri(URI.create("https://http.cat/"))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Failed request", e);
        }
    }
}
