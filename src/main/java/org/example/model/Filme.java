package org.example.model;

public class Filme {
    private String titulo;
    private String rank;
    private String ImgeURL;

    public Filme(String titulo, String rank, String imgeURL) {
        this.titulo = titulo;
        this.rank = rank;
        this.ImgeURL = imgeURL;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRank() {
        return rank;
    }

    public String getImgeURL() {
        return ImgeURL;
    }

    @Override
    public String toString() {
        return this.titulo + this.rank;
    }
}
