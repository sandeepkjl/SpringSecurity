package com.sandeep.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/user")
    public ResponseEntity<String> getUserDetails(){
        return new ResponseEntity<>("user api is in progress..", HttpStatus.OK);
    }

    @GetMapping("/loan")
    public ResponseEntity<String> getLoanDetails(){
        return new ResponseEntity<>("loan api is in progress..", HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<String> getAccountDetails(){
        return new ResponseEntity<>("account api is in progress..", HttpStatus.OK);
    }

    @GetMapping("/contact")
    public ResponseEntity<String> getContactDetails(){
        return new ResponseEntity<>("contact api is in progress..", HttpStatus.OK);
    }
}
