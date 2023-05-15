package tg.mediasoft.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.mediasoft.entites.Categorie;
import tg.mediasoft.entites.Produit;
import tg.mediasoft.serviceBeanRemote.CategorieServiceBeanRemote;
import tg.mediasoft.serviceBeanRemote.ProduitServiceBeanRemote;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sama
 */
@ManagedBean
@ViewScoped
public class ProduitManagedBean implements Serializable {

    @EJB
    private ProduitServiceBeanRemote produitServiceBean;

    @EJB
    private CategorieServiceBeanRemote categorieServiceBean;

    private Long produitId;
    private int produitTotal;
    private Produit produit;
    private Categorie categorie;
    private List<Categorie> categories;
    private List<Produit> produits;

    public ProduitManagedBean() {

    }

    @PostConstruct
    public void init() {
        this.produit = new Produit();
        this.categorie = new Categorie();
        this.produits = this.produitServiceBean.getProduit();
        this.produitTotal = this.produits.size();
    }

    public String create() {
        try {
            this.produitServiceBean.create(produit);
            return "/produis/list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String save() {
        try {
            System.out.println("Instence produit =" + this.produit);
            this.produitServiceBean.save(produit);
            return "list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initEdit() {
        if (produitId != null) {
            this.produit = this.produitServiceBean.findBy(produitId);
        } else {
            this.produit = new Produit();
        }
    }

    public String update() {
        try {
            this.produitServiceBean.update(this.produit);
            return "/produis/list?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String supprimer(Produit p) {
        try {
            this.produitServiceBean.supprimer(p);
            return "/produis/add?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produit> getListProduit() {
        return this.produitServiceBean.getProduit();
    }

    public List<Categorie> getListCategorie() {
        this.categories = this.categorieServiceBean.getCategorie();
        return this.categories;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public int getProduitTotal() {
        return produitTotal;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

}
