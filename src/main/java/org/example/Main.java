package org.example;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import org.example.model.Filme;
import org.example.service.HTMLGenerator;
import org.json.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_bxc76mes")).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray jsonArray = jsonResponse.getJSONArray("items");
        ArrayList<Filme> filmes = new ArrayList<>();

        for (Object item: jsonArray
        ) {
            Filme filme = new Filme(item);
           filmes.add(filme);
        }

        HTMLGenerator htmlGenerator = new HTMLGenerator(filmes);
        htmlGenerator.generate();
    }
}