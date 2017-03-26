package com.alternative.bank;

import com.alternative.bank.objets.ProduitDetenu;
import com.alternative.bank.objets.Usager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by yannic on 26/03/17.
 */
@RepositoryRestController
public interface PortraitFinancierRepository extends CrudRepository<ProduitDetenu, Long> {

    List<ProduitDetenu> findAllByUsagerId(@Param("usagerId") long usagerId);

}
