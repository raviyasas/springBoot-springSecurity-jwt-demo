package com.app.springbootjwt.security;

import com.app.springbootjwt.service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerDetailService customerDetailService;

    @Autowired
    public SecurityConfig(CustomerDetailService customerDetailService){
        this.customerDetailService = customerDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/sign-up").permitAll()
                .antMatchers("/api/getUsers").hasRole("USER")
                .antMatchers("/api/getAdminUsers").hasRole("ADMIN")
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(),customerDetailService));
    }
}
