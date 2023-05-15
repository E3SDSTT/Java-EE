/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.mediasoft.entites.Employer;
import tg.mediasoft.serviceBeanRemote.employeServiceBeanRemote;

/**
 *
 * @author sama
 */
@ManagedBean
@ViewScoped
public class employerManagedBean implements Serializable {

    private Employer employer;
    private Long employerId;

    @EJB
    private employeServiceBeanRemote employerService;

    @PostConstruct
    public void init() {
        this.employer = new Employer();
        System.out.println("init");
    }

    public String save() {
        this.employerService.save(employer);
        return "/employes/list?faces-redirect=true";
    }

//    public void getId(Long id){
//        this.employerId = this.employerService.findBy(id).getId();
//    }
    public void initEdit() {
        if (employerId != null) {
            this.employer = this.employerService.findBy(employerId);
        } else {
            this.employer = new Employer();
        }
    }

    public String delete(Employer e) {
        this.employerService.delete(e);
        return "/employes/list?faces-redirect=true";
    }

    public String update() {
        this.employerService.update(employer);
        return "/employes/list?faces-redirect=true";
    }

    public List<Employer> getListEmploye() {
        return this.employerService.getEmpler();
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

}
