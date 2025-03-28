package it.epicode.pubblicazione.libro;

import it.epicode.pubblicazione.Pubblicazione;

public class Libro extends Pubblicazione {
    private String author;
    private String genre;

    public Libro(int ISBN, String title, int annoPubblicazione, int numeroPagine, String author, String genre) {
        super(ISBN, title, annoPubblicazione, numeroPagine);
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
