package com.sandeep.secureapp3.config;

import com.sandeep.secureapp3.filter.JWTValidateFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().addFilterAfter(new JWTValidateFilter(), BasicAuthenticationFilter.class).authorizeRequests()
                .antMatchers("/user").authenticated()
                .antMatchers("/account").authenticated()
                .antMatchers("/loan").authenticated()
                .antMatchers("/contact").authenticated().and().httpBasic();
    }
}
