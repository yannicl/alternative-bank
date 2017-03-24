package com.alternative.bank.api.usagers;

import com.alternative.bank.objets.Usager;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yannic on 21/03/17.
 */
@Service
public class UsagersApiService {

    @Autowired
    RestTemplate restTemplate;

    public Usager findUsagerByUsername(String username) {

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + token);
//        headers.set("Accept", "application/json");
//
//        HttpEntity<?> entity = new HttpEntity<String>(headers);
//
//        String url = null;
//        try {
//            url = "http://usagers-store/usagers/search/findFirstByUsername?username=" + URLEncoder.encode(username, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            HttpEntity<Usager> response = restTemplate.exchange(url, HttpMethod.GET, entity, Usager.class);
//            return response.getBody();
//        } catch (Exception e){
//            return null;
//        }
        try {
            return restTemplate.getForObject("http://usagers-store/usagers/search/findFirstByUsername?username=" + username, Usager.class);
        } catch(HttpClientErrorException ex)  {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                throw ex;
            }
        }


    }

}
