/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "client")
public class Client extends Personne {

    @Column(name = "TrancheAge", length = 30)
    private String trancheAge;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<ProduitAcheter> prodAcheter;

    public Client() {
        
    }

    public Client(String trancheAge, String ville, String pays, List<ProduitAcheter> prodAcheter) {
        this.trancheAge = trancheAge;
        this.prodAcheter = prodAcheter;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public List<ProduitAcheter> getProdAcheter() {
        return prodAcheter;
    }

    public void setProdAcheter(List<ProduitAcheter> prodAcheter) {
        this.prodAcheter = prodAcheter;
    }

    @Override
    public String toString() {
        return "Client{" + "trancheAge=" + trancheAge
                + ", prodAcheter=" + prodAcheter + '}';
    }

}
