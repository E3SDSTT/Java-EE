/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.entites;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sama
 */
@Entity
@Table(name = "Employer")
public class Employer extends Personne{

    @Column(name = "DateDeNaissance")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;

    public Employer() {
    }

    public Employer(Date dateNaissance, String nom, String prenom) {
        super(nom, prenom);
        this.dateNaissance = dateNaissance;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public int getAge(){
        
        Date date = new Date();
        int year;
        year = date.getYear() - this.dateNaissance.getYear();
        return year;
        
    }

    @Override
    public String toString() {
        return "Employer{" + "dateNaissance=" + dateNaissance + '}';
    }

}
