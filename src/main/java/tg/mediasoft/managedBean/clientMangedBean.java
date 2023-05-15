/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.mediasoft.entites.Client;
import tg.mediasoft.serviceBeanRemote.ClientServiceBeanRemote;

/**
 *
 * @author sama
 */
@ManagedBean
@ViewScoped
public class clientMangedBean implements Serializable{
    
    @EJB
    private ClientServiceBeanRemote clientserviceBean;
    
    private Long cliendId;
    private Client client;
    private List<Client> clients;
    private List<String> trancheAges;
    
    @PostConstruct
    public void init(){
        this.client = new Client();
        
        this.trancheAges = new ArrayList<>();
        this.trancheAges.add("5 - 15 ans");
        this.trancheAges.add("16 - 30 ans");
        this.trancheAges.add("21 - 40");
        this.trancheAges.add("41 - 50 ans");
        this.trancheAges.add("51 - 70 ans");
        this.trancheAges.add("71 et plus");
    }
    
    public String save(){
        this.clientserviceBean.save(client);
        return "/clients/list?faces-redirect=true";
    }
    
    public void initEdit(){
        if(cliendId!=null){
            this.client = this.clientserviceBean.findBy(cliendId);
        }else{
            this.client = new Client();
        }
    }
    
    public String update(){
        this.clientserviceBean.update(this.client);
        return "/clients/list?faces-redirect=true"; 
    }
    
    public String delete(Client c){
        this.clientserviceBean.delete(c);
        return "/clients/list?faces-redirect=true"; 
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientServiceBeanRemote getClentserviceBean() {
        return clientserviceBean;
    }

    public void setClentserviceBean(ClientServiceBeanRemote clentserviceBean) {
        this.clientserviceBean = clentserviceBean;
    }

    public List<Client> getListClient(){
        return this.clientserviceBean.getClient();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> getTrancheAges() {
        return trancheAges;
    }

    public void setTrancheAges(List<String> trancheAges) {
        this.trancheAges = trancheAges;
    }

    public Long getCliendId() {
        return cliendId;
    }

    public void setCliendId(Long cliendId) {
        this.cliendId = cliendId;
    }
    
}
