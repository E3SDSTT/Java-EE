/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "produitsAcheter")
public class ProduitAcheter implements Serializable {

    @EmbeddedId
    private ProduitAcheterPK prodAchPK;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DateAchat")
    private Date dateAchat;

    @Column(name = "Quantite")
    private int quantite;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @MapsId("clientId")
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @MapsId("produitId")
    @JoinColumn(name = "idProduit")
    private Produit produit;

    public ProduitAcheter() {

    }

    public ProduitAcheter(ProduitAcheterPK prodAchPK, Date dateAchat,
            int quantite, Client client, Produit produit) {
        this.prodAchPK = prodAchPK;
        this.dateAchat = dateAchat;
        this.quantite = quantite;
        this.client = client;
        this.produit = produit;
    }

    public ProduitAcheterPK getProdAchPK() {
        return prodAchPK;
    }

    public void setProdAchPK(ProduitAcheterPK prodAchPK) {
        this.prodAchPK = prodAchPK;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.prodAchPK);
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
        final ProduitAcheter other = (ProduitAcheter) obj;
        return Objects.equals(this.prodAchPK, other.prodAchPK);
    }

    @Override
    public String toString() {
        return "ProduitAcheter{" + "prodAchPK=" + prodAchPK + ", dateAchat="
                + dateAchat + ", quantite=" + quantite +'}';
    }

}
