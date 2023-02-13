package com.nnh.ColeccionEsencial;

import java.util.Date;

public class Partitura {
    private Long id;
    private String autor;
    private String titulo;
    private int nEscuchas;
    private Date fechaPubli;

    public Partitura() {
    }

    public Partitura(Long id, String autor, String titulo, int nEscuchas, Date fechaPubli) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.nEscuchas = nEscuchas;
        this.fechaPubli = fechaPubli;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getnEscuchas() {
        return nEscuchas;
    }

    public void setnEscuchas(int nEscuchas) {
        this.nEscuchas = nEscuchas;
    }

    public Date getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(Date fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    @Override
    public String toString() {
        return "Partitura{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", nEscuchas=" + nEscuchas +
                ", fechaPubli=" + fechaPubli +
                '}';
    }
}
