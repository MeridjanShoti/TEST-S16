package it.epicode.pubblicazione.rivista;

import it.epicode.pubblicazione.Pubblicazione;

public class Rivista extends Pubblicazione {
    private Periodicita periodicita;

    public Rivista(String title, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(title, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "ISBN=" + this.getISBN() +
                ", title='" + this.getTitle() + '\'' +
                ", annoPubblicazione=" + this.getAnnoPubblicazione() +
                ", numeroPagine=" + this.getNumeroPagine() +
                ", periodicita=" + periodicita;
    }
}
