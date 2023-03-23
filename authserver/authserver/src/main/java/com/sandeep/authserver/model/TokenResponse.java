package com.sandeep.authserver.model;

public class TokenResponse {

    String jwt;

    public TokenResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
