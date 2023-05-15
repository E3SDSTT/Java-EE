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
import tg.mediasoft.daoBeanRemote.ProduitDaoRemote;
import tg.mediasoft.entites.Produit;

/**
 *
 * @author sama
 */
@Stateless
public class ProduitDao implements ProduitDaoRemote {

    @PersistenceContext
    EntityManager em;

    public ProduitDao() {

    }

    @Override
    public void create(Produit p) {
        try {
            this.em.persist(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Produit findBy(Long idProduit) {
        try {
            return this.em.find(Produit.class, idProduit);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Produit update(Produit p) {
        try {
            return this.em.merge(p);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Long idProduit) {
        try {
            Produit productToDelete = this.findBy(idProduit);
            this.em.remove(productToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void supprimer(Produit p) {
        try {
            delete(p.getIdProduit());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> getListProduit() {
        Query query = em.createQuery("SELECT p FROM Produit p");
        return query.getResultList();
    }
}
