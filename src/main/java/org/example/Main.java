package org.example;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import org.example.model.Filme;
import org.example.service.HTMLGenerator;
import org.json.*;



// {"id":"tt0111161","rank":"1","title":"The Shawshank Redemption","fullTitle":"The Shawshank Redemption (1994)","year":"1994","image":"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg","crew":"Frank Darabont (dir.), Tim Robbins, Morgan Freeman","imDbRating":"9.2","imDbRatingCount":"2668662"}
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_bxc76mes")).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray items = jsonResponse.getJSONArray("items");
        ArrayList<Filme> filmes = new ArrayList<>();



        for (Object item: items
        ) {
            JSONObject jsonObject = new JSONObject(item.toString());
           String JSONtitulo = jsonObject.getString("title");
           String JSONrank = jsonObject.getString("rank");
           String JSONimageURL = jsonObject.getString("image");
           String JSONano = jsonObject.getString("year");
           String JSONnota = jsonObject.getString("imDbRating");
           Filme filme = new Filme(JSONtitulo, JSONrank, JSONimageURL, JSONnota, JSONano);
           filmes.add(filme);
        }

        HTMLGenerator htmlGenerator = new HTMLGenerator(filmes);
        htmlGenerator.generate();

        for (Object filme:filmes
        ) {
            System.out.println(filme);
        }



    }
}