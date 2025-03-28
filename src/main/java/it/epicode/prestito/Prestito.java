package it.epicode.prestito;

import it.epicode.pubblicazione.Pubblicazione;
import it.epicode.utente.Utente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "Prestito.prestitoByTessera", query = "SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera")
@NamedQuery(name = "Prestito.prestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva < :oggi")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Pubblicazione elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;


    public Prestito(Utente utente, Pubblicazione elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Pubblicazione getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Pubblicazione elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataInizioPrestito = dataRestituzionePrevista.minusDays(30);
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
