package org.example;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;

import org.example.model.Movie;
import org.example.service.HTMLGenerator;
import org.json.*;
import static org.example.service.ImdbApiClient.clientCall;

public class Main {
    public static void main(String[] args) throws IOException {
        JSONObject JSONResponse = clientCall();
        JSONArray jsonArray = JSONResponse.getJSONArray("items");
        ArrayList<Movie> movies = new ArrayList<>();

        for (Object item: jsonArray
        ) {
            Movie movie = new Movie(item);
           movies.add(movie);
        }

        Collections.sort(movies);
        Collections.reverse(movies);

        for (Object movie:movies
        ) {
            System.out.println(movie);
        }

        HTMLGenerator htmlGenerator = new HTMLGenerator(movies);
        htmlGenerator.generate();
    }
}