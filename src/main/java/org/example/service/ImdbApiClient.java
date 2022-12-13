package org.example.service;

import org.example.model.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public  class ImdbApiClient {
    public static JSONObject clientCall(){
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://imdb-api" +
                ".com/en/API/Top250Movies/k_bxc76mes")).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray jsonArray = jsonResponse.getJSONArray("items");
        ArrayList<Movie> filmes = new ArrayList<>();

        return jsonResponse;

    }
}
