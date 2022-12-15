package org.example.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public  class ImdbApiClient implements APIClient {
    public static JSONObject clientCall(){
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://imdb-api" +
                ".com/en/API/Top250Movies/" + Dotenv.load().get("IMDB_KEY"))).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return new JSONObject(response.body());
    }
}
