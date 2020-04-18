package com.cg.feedback.dto;

public class Credentials {
    
    private String LoginId;
    private String LoginPassword;

    public Credentials(String loginId, String loginPassword) {
        LoginId = loginId;
        LoginPassword = loginPassword;
    }

    public Credentials() {
    }

    public String getLoginId() {
        return LoginId;
    }

    public void setLoginId(String loginId) {
        LoginId = loginId;
    }

    public String getLoginPassword() {
        return LoginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        LoginPassword = loginPassword;
    }
}
