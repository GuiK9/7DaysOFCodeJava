package org.example.service;

import org.example.model.Movie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLGenerator {
    ArrayList<Movie> filmes;
    public HTMLGenerator(ArrayList<Movie> filmes) {
        this.filmes = filmes;
    }

    public void generate() throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("src/main/site/index.html"));

        String head = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                </head>
                <body>
                
                """;
        String closeHTML = """
                </body>
                </html>
                """;


        buffWrite.append(head);
        for (Movie filme: filmes
        ) {
            buffWrite.append(generateMovieCard(filme));
        }

        buffWrite.append(closeHTML);
        buffWrite.close();
    }

    private String generateMovieCard(Movie filme) {
        String movieCard = """
                <div>
                """
                + "<h2> "+ filme.getTitle() + "</h2>"
                + "<image src=\"" + filme.getImgeURL() + "\"></image>"
                + "<p> nota: "+filme.getRating() + " - Ano: " + filme.getYear() + "</p>"
                +
                """ 
                </div>
                """;
        return movieCard;
    }
}