package com.alternative.bank.api.oauth2;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by yannic on 23/03/17.
 */
@Configuration
public class RestTemplateConfig {

    @LoadBalanced
    @Bean
    RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}
