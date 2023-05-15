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
import tg.mediasoft.daoBeanRemote.clientDaoRemote;
import tg.mediasoft.entites.Client;

/**
 *
 * @author sama
 */
@Stateless
public class clientDao implements clientDaoRemote{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Client c) {
        this.em.persist(c);
    }

    @Override
    public Client findBy(Long idClient) {
        return this.em.find(Client.class, idClient);
    }

    @Override
    public Client update(Client c) {
        return this.em.merge(c);
    }
    
    @Override
    public void supprimer(Long idClient){
        Client clienToDelete =this.findBy(idClient);
        this.em.remove(clienToDelete);
    }

    @Override
    public void delete(Client c) {
        supprimer(c.getId());
    }

    @Override
    public List<Client> getListClient() {
        Query query = em.createQuery("SELECT c FROM Client c");
        return query.getResultList();
    }
    
}
