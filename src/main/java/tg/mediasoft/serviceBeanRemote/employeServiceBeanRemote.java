/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.mediasoft.serviceBeanRemote;

import java.util.List;
import javax.ejb.Remote;
import tg.mediasoft.entites.Employer;

/**
 *
 * @author sama
 */
@Remote
public interface employeServiceBeanRemote {
    
    public void save(Employer e);
    
    public Employer findBy(Long idEmployer);
    
    public Employer update(Employer e);
    
    public void delete(Employer e);
    
    public List<Employer> getEmpler();
    
}
