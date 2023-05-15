/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.mediasoft.serviceBeanRemote;

import java.util.List;
import javax.ejb.Remote;
import tg.mediasoft.entites.Produit;

/**
 *
 * @author sama
 */
@Remote
public interface ProduitServiceBeanRemote {
    
    public void create(Produit p);
    
    public void save(Produit p);
    
    public Produit findBy(Long idProduit);
            
    public Produit update(Produit p);
    
    public void supprimer(Produit p);
    
    public List<Produit> getProduit();
    
}
