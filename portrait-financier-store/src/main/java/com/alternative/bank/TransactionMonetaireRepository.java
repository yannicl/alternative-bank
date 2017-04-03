package com.alternative.bank;

import com.alternative.bank.objets.ProduitDetenu;
import com.alternative.bank.objets.TransactionMonetaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by yannic on 26/03/17.
 */
@RepositoryRestController
public interface TransactionMonetaireRepository extends CrudRepository<TransactionMonetaire, Long> {

    Page<TransactionMonetaire> findByProduitDetenuIdOrderByIdDesc(long id, Pageable pageable);
}

