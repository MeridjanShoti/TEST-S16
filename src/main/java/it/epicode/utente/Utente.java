package it.epicode.utente;

import it.epicode.prestito.Prestito;
import it.epicode.pubblicazione.Pubblicazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    @OneToMany (mappedBy = "utente")
    private Prestito prestito;

    public Utente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }
    public Utente() {
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
