package it.epicode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
@Entity
@NamedQuery(name = "Pubblicazione.findByAutore", query = "SELECT p FROM Pubblicazione p WHERE p.author = :autore")
public class Libro extends Pubblicazione {
    private String author;
    private String genre;

    public Libro(String title, int annoPubblicazione, int numeroPagine, String author, String genre) {
        super(title, annoPubblicazione, numeroPagine);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "ISBN=" + this.getISBN() +
                ", title='" + this.getTitle() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", genre='" + this.getGenre() + '\'' +
                ", annoPubblicazione=" + this.getAnnoPubblicazione() +
                ", numeroPagine=" + this.getNumeroPagine();
    }
}
