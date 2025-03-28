package it.epicode.pubblicazione;

import jakarta.persistence.EntityManager;

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


}
