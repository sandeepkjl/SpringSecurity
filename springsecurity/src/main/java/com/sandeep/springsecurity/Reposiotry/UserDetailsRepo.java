package com.sandeep.springsecurity.Reposiotry;

import com.sandeep.springsecurity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Customer,Long> {

    Customer findCustomerByEmail(String email);
}
