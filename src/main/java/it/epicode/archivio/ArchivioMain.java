package it.epicode.archivio;

import it.epicode.dao.PrestitoDAO;
import it.epicode.dao.PubblicazioneDAO;
import it.epicode.entity.*;
import it.epicode.dao.UtenteDAO;
import it.epicode.enumeration.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class ArchivioMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();
        PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        utenteDAO.save(new Utente("Mario", "Rossi", LocalDate.of(2000, 1, 1)));
        utenteDAO.save(new Utente("Giuseppe", "Verdi", LocalDate.of(1990, 1, 1)));
        utenteDAO.save(new Utente("Stefano", "Bianchi", LocalDate.of(1980, 1, 1)));
        Pubblicazione libro1 = new Libro("Il Signore degli Anelli", 1954, 1000, "JRR Tolkien", "Fantasy");
        Pubblicazione libro2 = new Libro("Il Signore dei signori", 1967, 666, "Gigi Tolchio", "Scientifico");
        Pubblicazione libro3 = new Libro("Gli anelli del signore", 1989, 420, "Giangianni Tolkini", "Thriller");
        Pubblicazione libro4 = new Libro("Lo svarione degli anelli", 1999, 69, "Talchiano JRR", "Erotico");
        Pubblicazione libro5 = new Libro("Il Signore degli Agnelli ", 2024, 6000000, "Pippo Franco", "Romantico");
        Pubblicazione libro6 = new Libro("Yuri Chechi biografia", 2025, 999, "Gerry Scotty", "Horror");
        Pubblicazione rivista1 = new Rivista("Pesca al cefalo", 1999, 69, Periodicita.SETTIMANALE);
        Pubblicazione rivista2 = new Rivista("Motoseghe che passione", 2005, 69, Periodicita.MENSILE);
        Pubblicazione rivista3 = new Rivista("Camioni in sosta", 2025, 69, Periodicita.SEMESTRALE);
        Pubblicazione rivista4 = new Rivista("Puntocroce per zitelle", 2024, 69, Periodicita.MENSILE);
        List<Pubblicazione> pubblicazioni = List.of(libro1, libro2, libro3, libro4, libro5, libro6, rivista1, rivista2, rivista3, rivista4);
        em.getTransaction().begin();
        pubblicazioneDAO.saveNoTx(libro1);
        pubblicazioni.forEach(pubblicazioneDAO::saveNoTx);

        Prestito prestito1 = new Prestito(utenteDAO.getById(1), libro1, LocalDate.of(2025, 03, 22), LocalDate.of(2025, 03, 26));
        Prestito prestito2 = new Prestito(utenteDAO.getById(2), libro2, LocalDate.of(2025, 03, 20), LocalDate.of(2025, 03, 28));
        Prestito prestito3 = new Prestito(utenteDAO.getById(3), libro3, LocalDate.of(2025, 01, 23), null);
        Prestito prestito4 = new Prestito(utenteDAO.getById(1), libro4, LocalDate.of(2025, 01, 29), null);
        Prestito prestito5 = new Prestito(utenteDAO.getById(2), libro5, LocalDate.of(2025, 03, 27), null);
        Prestito prestito6 = new Prestito(utenteDAO.getById(3), libro6, LocalDate.of(2025, 01, 5), LocalDate.of(2025, 02, 21));

        List<Prestito> prestiti = List.of(prestito1, prestito2, prestito3, prestito4, prestito5, prestito6);
        prestiti.forEach(prestitoDAO::saveNoTx);

        em.getTransaction().commit();


    }
}
