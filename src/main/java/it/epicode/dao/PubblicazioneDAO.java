package it.epicode.dao;

import it.epicode.entity.Pubblicazione;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PubblicazioneDAO {
    private EntityManager em;
    public PubblicazioneDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.persist(pubblicazione);
        em.getTransaction().commit();
    }
    public Pubblicazione getById(long isbn) {
        return em.find(Pubblicazione.class, isbn);
    }
    public void delete(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.remove(pubblicazione);
        em.getTransaction().commit();
    }
    public void update(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.merge(pubblicazione);
        em.getTransaction().commit();
    }
    public void saveNoTx(Pubblicazione pubblicazione) {
        em.persist(pubblicazione);
    }
    public void deleteNoTx(Pubblicazione pubblicazione) {
        em.remove(pubblicazione);
    }
    public void updateNoTx(Pubblicazione pubblicazione) {
        em.merge(pubblicazione);
    }
    public List<Pubblicazione> findByAnnoPubblicazione(int annoPubblicazione) {
        return em.createNamedQuery("Pubblicazione.findByAnnoPubblicazione", Pubblicazione.class).setParameter("annoPubblicazione", annoPubblicazione).getResultList();
    }
    public List<Pubblicazione> findByAutore(String autore) {
        return em.createNamedQuery("Pubblicazione.findByAutore", Pubblicazione.class).setParameter("autore", autore).getResultList();
    }
    public List<Pubblicazione> findByTitolo(String titolo) {
        return em.createNamedQuery("Pubblicazione.findByTitolo", Pubblicazione.class).setParameter("titolo", titolo).getResultList();
    }

}
