package com.alternative.bank.gui.login;

import com.alternative.bank.api.oauth2.OAuth2TokenService;
import com.alternative.bank.api.usagers.UsagersApiService;
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

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yannic on 16/03/17.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    UsagersApiService usagersApiService;

    @Autowired
    OAuth2TokenService oAuth2TokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // check username against rules (regex)

        Usager usager = usagersApiService.findUsagerByUsername(username);

        if (usager != null) {
            log.info("Successful login for " + usager.getUsername());
            return new User(usager.getUsername(), usager.getPassword(), createUserAuthority());
        } else {
            log.warn("Login failed for " + username);
            throw new UsernameNotFoundException("invalid user");
        }

    }

    private Set<GrantedAuthority> createUserAuthority(){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        authorities.add(grantedAuthority);

        return authorities;
    }


}
