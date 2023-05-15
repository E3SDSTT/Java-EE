/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.mediasoft.daoBeanRemote;

import java.util.List;
import javax.ejb.Remote;
import tg.mediasoft.entites.Client;

/**
 *
 * @author sama
 */
@Remote
public interface clientDaoRemote {
    
    public void save(Client c);
    
    public Client findBy(Long idClient);
    
    public Client update(Client c);
    
    public void supprimer(Long idClient);
    
    public void delete(Client c);
    
    public List<Client> getListClient();
    
}
