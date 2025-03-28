package it.epicode.dao;

import it.epicode.entity.Prestito;
import it.epicode.entity.Pubblicazione;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private EntityManager em;
    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
    }
    public Prestito getById(long id) {
        return em.find(Prestito.class, id);
    }
    public void delete(Prestito prestito) {
        em.getTransaction().begin();
        em.remove(prestito);
        em.getTransaction().commit();
    }
    public void update(Prestito prestito) {
        em.getTransaction().begin();
        em.merge(prestito);
        em.getTransaction().commit();
    }
    public void saveNoTx(Prestito prestito) {
        em.persist(prestito);
    }
    public void deleteNoTx(Prestito prestito) {
        em.remove(prestito);
    }
    public void updateNoTx(Prestito prestito) {
        em.merge(prestito);
    }
    public List<Pubblicazione> getAllByIdTesseraUtente(long numeroTessera) {
        return em.createNamedQuery("Prestito.prestitoByTessera", Pubblicazione.class).setParameter("numeroTessera", numeroTessera).getResultList();
    }
    public List<Prestito> getAllPrestitiScaduti() {
        LocalDate dataFutura = LocalDate.now().plusDays(50);
        return em.createNamedQuery("Prestito.prestitoScaduto", Prestito.class).setParameter("oggi", dataFutura).getResultList();
    }
}
