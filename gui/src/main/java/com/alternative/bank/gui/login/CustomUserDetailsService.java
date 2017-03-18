package com.alternative.bank.gui.login;

import com.alternative.bank.api.usagers.UsagersApi;
import com.alternative.bank.objets.Usager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yannic on 16/03/17.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    UsagersApi usagersApi;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usager usager = retrieveUserFromStore(s);

        if (usager != null) {
            log.info("Successful login for " + usager.getUsername());
            return new User(usager.getUsername(), usager.getPassword(), createUserAuthority());
        } else {
            log.warn("Login failed for " + s);
            throw new UsernameNotFoundException("invalid user");
        }

    }

    private Set<GrantedAuthority> createUserAuthority(){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        authorities.add(grantedAuthority);

        return authorities;
    }

    private Usager retrieveUserFromStore(String username) {
        return usagersApi.findUsagerByUsername(username);
    }

}
