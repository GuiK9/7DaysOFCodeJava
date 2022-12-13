package org.example;

import java.io.IOException;

import java.util.ArrayList;

import org.example.model.Movie;
import org.example.service.HTMLGenerator;
import org.json.*;
import static org.example.service.ImdbApiClient.clientCall;

public class Main {
    public static void main(String[] args) throws IOException {
        JSONObject JSONResponse = clientCall();
        JSONArray jsonArray = JSONResponse.getJSONArray("items");
        ArrayList<Movie> filmes = new ArrayList<>();

        for (Object item: jsonArray
        ) {
            Movie filme = new Movie(item);
           filmes.add(filme);
        }

        HTMLGenerator htmlGenerator = new HTMLGenerator(filmes);
        htmlGenerator.generate();
    }
}