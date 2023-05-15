/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.serviceBean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.mediasoft.daoBeanRemote.ProduitDaoRemote;
import tg.mediasoft.entites.Produit;
import tg.mediasoft.serviceBeanRemote.ProduitServiceBeanRemote;

/**
 *
 * @author sama
 */
@Stateless
public class ProduitServiceBean implements ProduitServiceBeanRemote, Serializable {

    @EJB
    private ProduitDaoRemote produitDao;

    public ProduitServiceBean() {
 
    }

    @Override
    public void save(Produit p) {
        this.produitDao.create(p);
    }

    @Override
    public void create(Produit p) {
        this.produitDao.create(p);
    }
    
    @Override
    public Produit findBy(Long idProduit){ 
        return this.produitDao.findBy(idProduit);
    }

    @Override
    public Produit update(Produit p) {
        return this.produitDao.update(p);
    }

    @Override
    public void supprimer(Produit p) {
        this.produitDao.supprimer(p);
    }

    @Override
    public List<Produit> getProduit() {
        return this.produitDao.getListProduit();
    }

}
