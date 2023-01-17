package com.java.model;


public class SedexTokenResponse {
    
    private String access_token;
    private String token_type;
    private Integer expires_in;

    public String toString(){
        return "{ access_token : "+access_token +
        "token_type : "+token_type +
        "expires_in : "+expires_in+
        " } ";
        
    }

}
