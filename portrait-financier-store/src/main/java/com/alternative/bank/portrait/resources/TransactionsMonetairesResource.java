package com.alternative.bank.portrait.resources;

import com.alternative.bank.objets.ProduitDetenu;
import com.alternative.bank.objets.TransactionMonetaire;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yannic on 02/04/17.
 */
public class TransactionsMonetairesResource extends ResourceSupport {

    private List<TransactionMonetaire> liste;

    public TransactionsMonetairesResource(List<TransactionMonetaire> liste) {
        setListe(liste);
    }

    public List<TransactionMonetaire> getListe() {
        return liste;
    }

    public void setListe(List<TransactionMonetaire> liste) {
        this.liste = liste;
    }
}
