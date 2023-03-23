package com.sandeep.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Authentication of user
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("sandeep").password("12345").roles("user")
                .and()
                .withUser("admin").password("54321").roles("admin").
                and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    //instead of above defined user we can use user and userdetails interface.

    //three type of authorization we can do.
    //1. inMemory, 2. Jdbcbased, 3. LDAP based, 4. custom type (we can create custom manager by implementing userDetailsService interface.)

    //1. in memeory auth
   /*@Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

       UserDetails user1 = User.withUsername("sandeep").password("12345").roles("user").build();
        UserDetails user2 = User.withUsername("admin").password("54321").roles("admin").build();

        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);

        auth.userDetailsService(userDetailsManager);
    }*/
//----------------- Type 2 ------------------------------------
    //  TYPE 2. JDBC Authentication.

    //we can create user like above one. but for jdbc based we should use db.
    // i used mysql db , and sql template provided by spring security for user are in resource sql folder.
    // we create db and user info in database and provide db related properties in application.properties and we should add
    // datasource only like below one.

   /* @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/
    //it is by default use loadUserByUserName(String username) method. you can inside JdbcUserDetailsManager class and debug

    //----------------OR----------

    /*@Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        auth.userDetailsService(jdbcUserDetailsManager);
    }*/


    // TYPE 3: - LDAP (we are not implementing it).

//---------------------TYPE 4--------------------------------
    //TYPE 4:- custom authentication manager. JPA based.

    /*@Autowired
    UserDetailsService jpaUserDetailsServiceManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(jpaUserDetailsServiceManager);
    }*/


//-------------------------------------------------------------------------------------------------------------------------------
    //Authorization....

    /**
     * /user , /account , /loan - Secured.
     * /contact - Not Secured
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user").authenticated()//if user has user role then only able to access otherwise 403.
                .antMatchers("/account").hasRole("admin")
                .antMatchers("/loan").authenticated()
                .antMatchers("/contact").permitAll()
                .and().formLogin().and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
