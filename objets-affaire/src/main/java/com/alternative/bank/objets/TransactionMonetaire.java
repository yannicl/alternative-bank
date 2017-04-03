package com.alternative.bank.objets;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransactionMonetaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private long produitDetenuId;

    @Digits(integer=9, fraction=2)
    private BigDecimal montant;

    @Digits(integer=9, fraction=2)
    private BigDecimal soldeAvantTrx;

    @Digits(integer=9, fraction=2)
    private BigDecimal soldeAprestrx;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getProduitDetenuId() {
        return produitDetenuId;
    }

    public void setProduitDetenuId(long produitDetenuId) {
        this.produitDetenuId = produitDetenuId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getSoldeAvantTrx() {
        return soldeAvantTrx;
    }

    public void setSoldeAvantTrx(BigDecimal soldeAvantTrx) {
        this.soldeAvantTrx = soldeAvantTrx;
    }

    public BigDecimal getSoldeAprestrx() {
        return soldeAprestrx;
    }

    public void setSoldeAprestrx(BigDecimal soldeAprestrx) {
        this.soldeAprestrx = soldeAprestrx;
    }
}
