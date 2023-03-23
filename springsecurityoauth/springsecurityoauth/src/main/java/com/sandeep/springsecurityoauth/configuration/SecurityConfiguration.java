package com.sandeep.springsecurityoauth.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    //-------------------------------------------------------------------------------------------------------------------------------
    //Authorization....

    /**
     * /user , /account , /loan - Secured.
     * /contact - Not Secured
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.csrf().disable().authorizeRequests().antMatchers("/user").authenticated()//if user has user role then only able to access otherwise 403.
                .antMatchers("/account").authenticated()
                .antMatchers("/loan").authenticated()
                .antMatchers("/contact").permitAll()
                .and().oauth2ResourceServer().jwt().jwtAuthenticationConverter((jwtAuthenticationConverter));
    }
}
