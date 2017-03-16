package com.alternative.bank.objets;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch= FetchType.LAZY)
    private ProduitDetenu produit;

    @Digits(integer=9, fraction=2)
    private BigDecimal montant;

    @Digits(integer=9, fraction=2)
    private BigDecimal soldeAvantTrx;

    @Digits(integer=9, fraction=2)
    private BigDecimal soldeAprestrx;
}
