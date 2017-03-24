package com.alternative.bank.api.oauth2;

import com.alternative.bank.api.ribbon.OAuth2TokenClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RibbonClient(name = "oauth2-service", configuration = OAuth2TokenClientConfig.class)
public class OAuth2TokenConfig {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
