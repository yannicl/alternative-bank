package com.alternative.objets;


import javax.persistence.*;
import java.sql.Date;

public class ProduitDetenu {

    @Id
    private long id;

    @ManyToOne(fetch= FetchType.EAGER)
    private Produit produit;

    @ManyToOne(fetch= FetchType.LAZY)
    private Usager usager;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcquisition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }
}
