/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tg.mediasoft.daoBeanRemote.employeDaoRemote;
import tg.mediasoft.entites.Employer;

/**
 *
 * @author sama
 */
@Stateless
public class employeDao implements employeDaoRemote{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Employer e) {
        this.em.persist(e);
    }

    @Override
    public Employer findBy(Long idEmploye) {
        return this.em.find(Employer.class, idEmploye);
    }

    @Override
    public Employer update(Employer e) {
        return this.em.merge(e);
    }
    
    @Override
    public void supprimer(Long idEmployer){
        Employer employerToDelete = this.findBy(idEmployer);
        this.em.remove(employerToDelete);
    }

    @Override
    public void delete(Employer e) {
        supprimer(e.getId());
    }

    @Override
    public List<Employer> getListEmploye() {
        Query query = em.createQuery("SELECT e FROM Employer e");
        return query.getResultList();
    }
    
}
