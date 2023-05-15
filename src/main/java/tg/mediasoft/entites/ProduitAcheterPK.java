/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author sama
 */
@Embeddable
public class ProduitAcheterPK implements Serializable{
    
    private Long produitId;
    private Long clientId;

    public ProduitAcheterPK() {
    }

    public ProduitAcheterPK(Long produitId, Long clientId) {
        this.produitId = produitId;
        this.clientId = clientId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.produitId);
        hash = 71 * hash + Objects.hashCode(this.clientId);
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
        final ProduitAcheterPK other = (ProduitAcheterPK) obj;
        if (!Objects.equals(this.produitId, other.produitId)) {
            return false;
        }
        return Objects.equals(this.clientId, other.clientId);
    }
    
}
