package com.sevendaysofcode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public abstract class API {

    public static String validateKey(String key) throws Exception {
        if (!key.startsWith("API_KEY=")) {
            throw new Exception("Missing API_KEY argument");
        }

        final String[] splittedKey = key.split("=");
        if (splittedKey.length != 2) {
            throw new Exception("Invalid API_KEY format");
        }

        return splittedKey[1];
    }

    public static String[] getTopMovies(String key) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/" + key;
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return DataParser.getData(response.body());
        } catch (IOException | InterruptedException e) {
            throw new Exception("Error connecting to API");
        }
    }

}
