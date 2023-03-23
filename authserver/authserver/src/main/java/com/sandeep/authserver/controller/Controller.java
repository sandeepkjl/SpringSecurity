package com.sandeep.authserver.controller;


import com.sandeep.authserver.model.AuthRequest;
import com.sandeep.authserver.model.TokenResponse;
import com.sandeep.authserver.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    JWTService service;

    @GetMapping("/authenticate")
    public ResponseEntity<TokenResponse> generateToken(@RequestBody AuthRequest request){
        return ResponseEntity.ok(service.createJWTToken(request));
    }
}
