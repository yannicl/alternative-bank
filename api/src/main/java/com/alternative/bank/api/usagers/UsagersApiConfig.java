package com.alternative.bank.api.usagers;

import com.alternative.bank.api.ribbon.OAuth2TokenClientConfig;
import com.alternative.bank.api.ribbon.UsagersApiClientConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yannic on 22/03/17.
 */
@Configuration
@RibbonClient(name = "usagers-store", configuration = UsagersApiClientConfig.class)
public class UsagersApiConfig {

}
