package com.alternative.bank.gui.login;

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



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if ("user1".equals(s)) {
            // passwd is passwd1 in md5
            return new User("user1", "79e262a81dd19d40ae008f74eb59edce", createUserAuthority());
        } else {
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
