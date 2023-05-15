/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "produits")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdProduit")
    private Long idProduit;
    
    @Column(name = "Libélle", length = 31)
    private String libelle;
    
    @Column(name = "Prix Unitaire")
    private Double prixUnitaire;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "Catégorie")
    private Categorie categorie;
    
    public Produit(){
        
    }

    public Produit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Date datePeremption, String libelle, Double prixUnitaire
            , Categorie categorie) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
    }
    
    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idProduit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        return Objects.equals(this.idProduit, other.idProduit);
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + idProduit  
                + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire 
                + ", categorie=" + categorie + '}';
    }
    
}
