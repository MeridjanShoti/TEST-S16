package it.epicode.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Pubblicazione.findByAnnoPubblicazione", query = "SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "Pubblicazione.findByTitolo", query = "SELECT p FROM Pubblicazione p WHERE p.title LIKE :titolo")
//se voglio cercare una parola contenuta nel titolo mi basterà mettere il % prima e dopo la parola da cercare

public abstract class Pubblicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ISBN;
    private String title;
    private int annoPubblicazione;
    private int numeroPagine;


    public Pubblicazione(String title, int annoPubblicazione, int numeroPagine) {
        this.title = title;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public Pubblicazione() {}

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
