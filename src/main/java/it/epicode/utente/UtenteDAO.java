package it.epicode.utente;

import jakarta.persistence.EntityManager;

public class UtenteDAO {
    private EntityManager em;
    public UtenteDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }
    public Utente getById(long id) {
        return em.find(Utente.class, id);
    }
    public void delete(Utente utente) {
        em.getTransaction().begin();
        em.remove(utente);
        em.getTransaction().commit();
    }
    public void update(Utente utente) {
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
    }
    public void saveNoTx(Utente utente) {
        em.persist(utente);
    }
    public void deleteNoTx(Utente utente) {
        em.remove(utente);
    }
    public void updateNoTx(Utente utente) {
        em.merge(utente);
    }
}
