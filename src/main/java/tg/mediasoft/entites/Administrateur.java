/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "administrateur")
public class Administrateur extends Personne{
    
    private boolean privilleges;

    public Administrateur() {
    }
    
    public Administrateur(boolean privilleges) {
        this.privilleges = privilleges;
    }

    public boolean isPrivilleges() {
        return privilleges;
    }

    public void setPrivilleges(boolean privilleges) {
        this.privilleges = privilleges;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "privilleges=" + privilleges + '}';
    }
    
}
