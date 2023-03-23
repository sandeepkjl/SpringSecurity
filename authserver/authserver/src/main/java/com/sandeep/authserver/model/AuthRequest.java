package com.sandeep.authserver.model;

import java.util.List;

public class AuthRequest {

    private String userName;
    private List<String> auhorties;

    public AuthRequest() {
    }

    public AuthRequest(String userName, List<String> auhorties) {
        this.userName = userName;
        this.auhorties = auhorties;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getAuhorties() {
        return auhorties;
    }

    public void setAuhorties(List<String> auhorties) {
        this.auhorties = auhorties;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "userName='" + userName + '\'' +
                ", auhorties=" + auhorties +
                '}';
    }
}
