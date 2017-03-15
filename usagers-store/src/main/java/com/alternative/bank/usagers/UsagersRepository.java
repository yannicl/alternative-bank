package com.alternative.bank.usagers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by yannic on 14/03/17.
 */
@RepositoryRestController
public interface UsagersRepository extends CrudRepository<Usager, Long> {

    Usager findFirstByUsername(@Param("username") String username);

}
