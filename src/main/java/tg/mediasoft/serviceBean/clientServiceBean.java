/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.serviceBean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.mediasoft.daoBeanRemote.clientDaoRemote;
import tg.mediasoft.entites.Client;
import tg.mediasoft.serviceBeanRemote.ClientServiceBeanRemote;

/**
 *
 * @author sama
 */
@Stateless
public class clientServiceBean implements ClientServiceBeanRemote {
    
    @EJB
    private clientDaoRemote clientDao;

    @Override
    public void save(Client c) {
        this.clientDao.save(c);
    }

    @Override
    public Client findBy(Long idClient) {
        return this.clientDao.findBy(idClient);
    }

    @Override
    public Client update(Client c) {
        return this.clientDao.update(c);
    }

    @Override
    public void delete(Client c) {
        this.clientDao.delete(c);
        
    }

    @Override
    public List<Client> getClient() {
        return this.clientDao.getListClient();
    }
    
}
