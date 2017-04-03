package com.alternative.bank;

import com.alternative.bank.objets.ProduitDetenu;
import com.alternative.bank.objets.TransactionMonetaire;
import com.alternative.bank.portrait.resources.ProduitDetenuResource;
import com.alternative.bank.portrait.resources.TransactionsMonetairesResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by yannic on 26/03/17.
 */
@RestController
@RequestMapping("portrait")
public class PortraitFinancierController {

    private static Logger log = LoggerFactory.getLogger(PortraitFinancierController.class);

    @Autowired
    PortraitFinancierRepository repository;

    @Autowired
    TransactionMonetaireRepository repositoryTrx;

    @RequestMapping(value = "/detention", method = {RequestMethod.GET})
    public ResponseEntity<Resources<ProduitDetenuResource>> getDetention(@Param("usagerId") long usagerId) {

        List<ProduitDetenuResource> produitDetenuResourceList = repository.findAllByUsagerId(usagerId).stream().map(produit -> new ProduitDetenuResource(produit)).collect(Collectors.toList());

        Resources<ProduitDetenuResource> resourceList = new Resources<ProduitDetenuResource>(produitDetenuResourceList);
        resourceList.add(linkTo(methodOn(PortraitFinancierController.class).getDetention(usagerId)).withSelfRel());

        return new ResponseEntity<Resources<ProduitDetenuResource>>(resourceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{produitDetenuId}/transactions", method = {RequestMethod.GET})
    public HttpEntity<PagedResources<TransactionMonetaire>> getTransactions(@PathVariable("produitDetenuId") long produitDetenuId, @PageableDefault Pageable pageable, PagedResourcesAssembler assembler) {

        log.info("pageable = {}" , pageable);

        Page<TransactionMonetaire> transactionMonetaires = repositoryTrx.findByProduitDetenuIdOrderByIdDesc(produitDetenuId, pageable);
        return new ResponseEntity<>(assembler.toResource(transactionMonetaires), HttpStatus.OK);

    }


}
