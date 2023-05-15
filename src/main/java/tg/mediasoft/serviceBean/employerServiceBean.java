/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.serviceBean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tg.mediasoft.daoBeanRemote.employeDaoRemote;
import tg.mediasoft.entites.Employer;
import tg.mediasoft.serviceBeanRemote.employeServiceBeanRemote;

/**
 *
 * @author sama
 */
@Stateless
public class employerServiceBean implements employeServiceBeanRemote {

    @EJB
    private employeDaoRemote employerDAO;

    @Override
    public void save(Employer e) {
        this.employerDAO.save(e);
    }

    @Override
    public Employer findBy(Long idEmployer) {
        return this.employerDAO.findBy(idEmployer);
    }

    @Override
    public Employer update(Employer e) {
        return this.employerDAO.update(e);
    }

    @Override
    public void delete(Employer e) {
        this.employerDAO.delete(e);
    }

    @Override
    public List<Employer> getEmpler() {
        return this.employerDAO.getListEmploye();
    }

}
