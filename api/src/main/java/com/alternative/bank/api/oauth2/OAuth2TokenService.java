package com.alternative.bank.api.oauth2;

import feign.Param;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yannic on 21/03/17.
 */
@Service(value = "oAuth2TokenService")
public class OAuth2TokenService {

    private static Logger log = LoggerFactory.getLogger(OAuth2TokenConfig.class);

    @Autowired
    RestTemplate restTemplate;

    private ClientHttpRequestInterceptor basicAuth;

    public void initializeTemplate() {
        basicAuth = new BasicAuthorizationInterceptor("feign", "feignsecret");
        restTemplate.getInterceptors().add(basicAuth);

        final OAuth2AccessToken token = createToken("gui", "guisecret");
        log.info("Token : " + token.getValue());

        restTemplate.getInterceptors().remove(basicAuth);

        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){

            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().add("Authorization", "Bearer " + token);
                return  execution.execute(request, body);
            }
        });
    }

    public OAuth2AccessToken createToken(String username, String password) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("client_id", "feign");
        map.add("client_secret", "feignsecret");
        map.add("username", username);
        map.add("password", password);

        return restTemplate.postForObject("http://feign:feignsecret@oauth2-service/oauth/token", map, OAuth2AccessToken.class);
    }

}
