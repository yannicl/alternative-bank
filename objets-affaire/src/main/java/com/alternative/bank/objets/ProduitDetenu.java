package com.alternative.bank.objets;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ProduitDetenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codeProduit;

    private long usagerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcquisition;

    private BigDecimal solde;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public long getUsagerId() {
        return usagerId;
    }

    public void setUsagerId(long usagerId) {
        this.usagerId = usagerId;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }
}
