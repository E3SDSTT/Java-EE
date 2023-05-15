/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sama
 */
@Entity
@Table(name = "categories")
public class Categorie implements Serializable {
    @Id
    @Column(name = "idCategorie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "Libelle",length = 31)
    private String libelle;
    
    public Categorie() {
        
    }
    
    public Categorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }
    
    public Categorie(String description, String libelle) {
        this.description = description;
        this.libelle = libelle;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idCategorie);
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
        final Categorie other = (Categorie) obj;
        return Objects.equals(this.idCategorie, other.idCategorie);
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + idCategorie + ", description=" + description 
                + ", libelle=" + libelle + '}';
    }
    
    
}
