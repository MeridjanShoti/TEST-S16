package it.epicode.pubblicazione;

public abstract class Pubblicazione {
    private int ISBN;
    private String title;
    private int annoPubblicazione;
    private int numeroPagine;

    public Pubblicazione(int ISBN, String title, int annoPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.title = title;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return  "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine;
    }
}
