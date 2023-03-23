package com.sandeep.springsecurity.service;

import com.sandeep.springsecurity.Reposiotry.UserDetailsRepo;
import com.sandeep.springsecurity.model.Customer;
import com.sandeep.springsecurity.model.SecureUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JPAUserDetailsServiceManager implements UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Customer customer = userDetailsRepo.findCustomerByEmail(username);
            UserDetails userDetails = new SecureUser(customer);


            return userDetails;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
}
