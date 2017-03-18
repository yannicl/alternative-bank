package com.alternative.bank.api.usagers;

import com.alternative.bank.objets.Usager;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by yannic on 17/03/17.
 */
@FeignClient("usagers-store")
public interface UsagersApi {

    @RequestMapping(method = RequestMethod.GET, value = "/usagers/search/findFirstByUsername")
    Usager findUsagerByUsername(@RequestParam("username") String username);

}
