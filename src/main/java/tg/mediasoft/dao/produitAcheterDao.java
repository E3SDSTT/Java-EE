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
import javax.persistence.TypedQuery;
import tg.mediasoft.daoBeanRemote.produitAcheterDaoRemote;
import tg.mediasoft.entites.Client;
import tg.mediasoft.entites.ProduitAcheter;

/**
 *
 * @author sama
 */
@Stateless
public class produitAcheterDao implements produitAcheterDaoRemote {

    @PersistenceContext
    EntityManager em;
    
    Client client = new Client();
    
    @Override
    public void save(ProduitAcheter pa) {
        this.em.persist(pa);
    }
    
    @Override
    public List<ProduitAcheter> findByIdClient(Long idClient){
        TypedQuery<ProduitAcheter> query = em.createQuery(
        "SELECT pa FROM ProduitAcheter pa "
                + "JOIN FETCH pa.produit "
                + "JOIN FETCH pa.client "
                + "WHERE pa.client.id = :idClient",
        ProduitAcheter.class);
        query.setParameter("idClient", idClient);
        return query.getResultList();
    }
    
    @Override
    public List<ProduitAcheter>  getListProduitAcheter(){
        Query query = this.em.createQuery("SELECT pa FROM ProduitAcheter pa");
        return query.getResultList();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
