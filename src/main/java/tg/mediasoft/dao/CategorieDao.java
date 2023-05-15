/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tg.mediasoft.daoBeanRemote.categorieDaoRemote;
import tg.mediasoft.entites.Categorie;

/**
 *
 * @author sama
 */
@Stateless
public class CategorieDao implements categorieDaoRemote,Serializable {

    @PersistenceContext
    EntityManager em;
        
    public CategorieDao() {
    }

    @Override
    public void create(Categorie cat) {
        try {
            this.em.persist(cat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Categorie findBy(Long idCategorie) {
        try {
            return this.em.find(Categorie.class, idCategorie);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Categorie update(Categorie cat) {
        try {
            return this.em.merge(cat);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Long idCategorie) {
        try {
            Categorie categorieToDelete = this.findBy(idCategorie);
            this.em.remove(categorieToDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void supprimer(Categorie cat) {
        try {
            delete(cat.getIdCategorie());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorie> getListCategorie() {
        Query query = em.createQuery("SELECT cat FROM Categorie cat");
        return query.getResultList();
    }

    
}
