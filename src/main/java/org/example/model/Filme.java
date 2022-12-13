package org.example.model;

import java.util.Date;

public class Filme {
    private String titulo;
    private String rank;
    private String ImgeURL;

    private String nota;
    private String ano;

    public Filme(String titulo, String rank, String imgeURL, String nota, String ano) {
        this.titulo = titulo;
        this.rank = rank;
        ImgeURL = imgeURL;
        this.nota = nota;
        this.ano = ano;
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
