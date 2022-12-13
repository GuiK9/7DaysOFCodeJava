package org.example.model;

import org.json.JSONObject;

public class Movie {
    private String titulo;
    private String rank;
    private String ImgeURL;
    private String nota;
    private String ano;

    public Movie(String titulo, String rank, String imgeURL, String nota, String ano) {
        this.titulo = titulo;
        this.rank = rank;
        ImgeURL = imgeURL;
        this.nota = nota;
        this.ano = ano;
    }

    public Movie(Object JSONObject) {
        JSONObject jsonObject = new JSONObject(JSONObject.toString());
        String JSONtitulo = jsonObject.getString("title");
        String JSONrank = jsonObject.getString("rank");
        String JSONimageURL = jsonObject.getString("image");
        String JSONano = jsonObject.getString("year");
        String JSONnota = jsonObject.getString("imDbRating");
        this.titulo = JSONtitulo;
        this.rank = JSONrank;
        ImgeURL = JSONimageURL;
        this.nota = JSONnota;
        this.ano = JSONano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRank() {
        return rank;
    }

    public String getNota() {
        return nota;
    }

    public String getAno() {
        return ano;
    }

    public String getImgeURL() {
        return ImgeURL;
    }
    @Override
    public String toString() {
        return this.titulo + this.rank;
    }
}
