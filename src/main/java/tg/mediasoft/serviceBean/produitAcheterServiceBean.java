/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.serviceBean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.mediasoft.daoBeanRemote.produitAcheterDaoRemote;
import tg.mediasoft.entites.ProduitAcheter;
import tg.mediasoft.serviceBeanRemote.produitAcheterServiceBeanRemote;

/**
 *
 * @author sama
 */
@Stateless
public class produitAcheterServiceBean implements produitAcheterServiceBeanRemote{

    @EJB
    private produitAcheterDaoRemote produitAcheterDao;
    
    @Override
    public void save(ProduitAcheter pa) {
        this.produitAcheterDao.save(pa);
    }
    
    @Override
    public List<ProduitAcheter> findByIdClient(Long idClient){
        return this.produitAcheterDao.findByIdClient(idClient);
    }
    
    @Override
    public List<ProduitAcheter> getProduitAcheter() {
        return this.produitAcheterDao.getListProduitAcheter();
    }
    
}
