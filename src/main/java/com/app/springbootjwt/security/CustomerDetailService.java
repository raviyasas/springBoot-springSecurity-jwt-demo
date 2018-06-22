package com.app.springbootjwt.security;

import com.app.springbootjwt.model.ApplicationUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserByUsername(username);
        return new User(applicationUser.getUsername(),applicationUser.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public ApplicationUser applicationUserByUsername(String username){
        return new ApplicationUser("admin","admin");
    }
}
