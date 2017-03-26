package com.alternative.bank.objets;


import javax.persistence.*;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public long getUsager() {
        return usagerId;
    }

    public void setUsager(long usagerId) {
        this.usagerId = usagerId;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }
}
