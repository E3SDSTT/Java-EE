/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.mediasoft.serviceBeanRemote;

import java.util.List;
import javax.ejb.Remote;
import tg.mediasoft.entites.ProduitAcheter;

/**
 *
 * @author sama
 */
@Remote
public interface produitAcheterServiceBeanRemote {
    
    public void save(ProduitAcheter pa);
    
    public List<ProduitAcheter> findByIdClient(Long idClient);
    
    public List<ProduitAcheter> getProduitAcheter();
    
}
