/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "produits")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProduit;
    @Column(name = "Libelle")

    private String libelle;
    @Column(name = "PrixUnitaire")
    private Double prixUnitaire;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "DatePeremption")
    private LocalDate datePeremption;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "Categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<ProduitAcheter> prodAcheter;

    public Produit() {
    }

    public Produit(Long idProduit, String libelle, Double prixUnitaire,
            int quantite, LocalDate datePeremption, Categorie categorie,
            List<ProduitAcheter> prodAcheter) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
        this.prodAcheter = prodAcheter;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<ProduitAcheter> getProdAcheter() {
        return prodAcheter;
    }

    public void setProdAcheter(List<ProduitAcheter> prodAcheter) {
        this.prodAcheter = prodAcheter;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idProduit);
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
        return "Produit{" + "idProduit=" + idProduit + ", libelle=" + libelle
                + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite
                + ", datePeremption=" + datePeremption + ", categorie="
                + categorie + ", prodAcheter=" + prodAcheter + '}';
    }
}
