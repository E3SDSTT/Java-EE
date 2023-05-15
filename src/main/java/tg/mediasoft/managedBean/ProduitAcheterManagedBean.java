/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.mediasoft.managedBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import tg.mediasoft.entites.ProduitAcheter;
import tg.mediasoft.serviceBeanRemote.produitAcheterServiceBeanRemote;

/**
 *
 * @author sama
 */
@ManagedBean
@ViewScoped
public class ProduitAcheterManagedBean {

    @EJB
    private produitAcheterServiceBeanRemote prodAcheterService;

    private Long clientId;
    private double prixTotal = 0.0;
    private ProduitAcheter produitAcheter;
    private List<ProduitAcheter> produitsAchetes;

    @PostConstruct
    public void init() {
        this.produitAcheter = new ProduitAcheter();
    }

    public void initFind() {
        if (this.clientId != null) {
            this.produitsAchetes = this.prodAcheterService.findByIdClient(clientId);
            this.produitAcheter = this.produitsAchetes.get(0);
//            System.out.println(this.produitsAchetes);
        }
    }

    public double prixTotal() {
        for (ProduitAcheter pa : produitsAchetes) {
            prixTotal += pa.getQuantite() * pa.getProduit().getPrixUnitaire();
        }
        return prixTotal;
    }

    public String save() {
        this.prodAcheterService.save(produitAcheter);
        return "/achats/newMarket?faces-redirect=true";
    }

    public List<ProduitAcheter> findByIdClient(Long idClient) {

        return this.prodAcheterService.findByIdClient(idClient);
    }

    public ProduitAcheter getProduitAcheter() {
        return produitAcheter;
    }

    public void setProduitAcheter(ProduitAcheter produitAcheter) {
        this.produitAcheter = produitAcheter;
    }

    public void getListProduitAcheter() {
        this.prodAcheterService.getProduitAcheter();
    }

    public List<ProduitAcheter> getProduitsAchetes() {
        return produitsAchetes;
    }

    public void setProduitsAchetes(List<ProduitAcheter> produitsAchetes) {
        this.produitsAchetes = produitsAchetes;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

}
