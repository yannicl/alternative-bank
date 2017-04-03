package com.alternative.bank.portrait.resources;

import com.alternative.bank.PortraitFinancierController;
import com.alternative.bank.objets.ProduitDetenu;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by yannic on 02/04/17.
 */
public class ProduitDetenuResource extends ResourceSupport {

    public ProduitDetenuResource(ProduitDetenu produitDetenu) {
        setCodeProduit(produitDetenu.getCodeProduit());
        setDateAcquisition(produitDetenu.getDateAcquisition());
        setSolde(produitDetenu.getSolde());
        add(linkTo(methodOn(PortraitFinancierController.class).getTransactions(produitDetenu.getId(), null, null)).withRel("trx.search"));
    }

    private String codeProduit;

    private Date dateAcquisition;

    private BigDecimal solde;

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
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
