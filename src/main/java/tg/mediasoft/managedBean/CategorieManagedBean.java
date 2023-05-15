/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.mediasoft.entites.Categorie;
import tg.mediasoft.serviceBeanRemote.CategorieServiceBeanRemote;

/**
 *
 * @author sama
 */
@ManagedBean
@ViewScoped
public class CategorieManagedBean implements Serializable {

    private Long categorieId;
    private int categorieTotal;
    private Categorie categorie;
    private List<Categorie> categories;

    @EJB
    private CategorieServiceBeanRemote categorieServiceBean;

    public CategorieManagedBean() {

    }

    @PostConstruct
    public void init() {
        this.categories = categorieServiceBean.getCategorie();
        this.categorieTotal = this.categories.size();
        this.categorie = new Categorie();

    }

    public String create() {
        try {
            this.categorieServiceBean.create(categorie);
            return "/categories/add?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String save() {
        try {
            this.categorieServiceBean.save(categorie);
            return "/categories/list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initEdit() {
        if (categorieId != null) {
            this.categorie = this.categorieServiceBean.findBy(categorieId);
        } else {
            this.categorie = new Categorie();
        }
    }

    public String update() {
        try {
            this.categorieServiceBean.update(this.categorie);
            return "/categories/list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String supprimer(Categorie cat) {
        try {
            this.categorieServiceBean.supprimer(cat);
            return "/categories/list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Categorie> getListCategorie() {
        return this.categorieServiceBean.getCategorie();
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getCategorieTotal() {
        return categorieTotal;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

}
