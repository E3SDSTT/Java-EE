/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.serviceBean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.mediasoft.daoBeanRemote.categorieDaoRemote;
import tg.mediasoft.entites.Categorie;
import tg.mediasoft.serviceBeanRemote.CategorieServiceBeanRemote;

/**
 *
 * @author sama
 */
@Stateless
public class CategorieServiceBean implements CategorieServiceBeanRemote, Serializable{

    @EJB
    private categorieDaoRemote categorieDao;
    
    public CategorieServiceBean() {
        
    }

    @Override
    public void save(Categorie cat){
        this.categorieDao.create(cat);
    }

    @Override
    public void create(Categorie cat) {
        this.categorieDao.create(cat);
    }

    @Override
    public Categorie update(Categorie cat) {
        return this.categorieDao.update(cat);
    }

    @Override
    public void supprimer(Categorie cat) {
        this.categorieDao.supprimer(cat);
    }
    
    @Override
    public List<Categorie> getCategorie(){
        return this.categorieDao.getListCategorie();
    }

    @Override
    public Categorie findBy(Long idCategorie) {
        return this.categorieDao.findBy(idCategorie);
    }
}
