/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.mediasoft.serviceBeanRemote;

import java.util.List;
import javax.ejb.Remote;
import tg.mediasoft.entites.Categorie;

/**
 *
 * @author sama
 */
@Remote
public interface CategorieServiceBeanRemote {

    public void save(Categorie cat);

    public void create(Categorie cat) ;
    
    public Categorie findBy(Long idCategorie);

    public Categorie update(Categorie cat) ;

    public void supprimer(Categorie cat) ;
    
    List<Categorie> getCategorie();
}
