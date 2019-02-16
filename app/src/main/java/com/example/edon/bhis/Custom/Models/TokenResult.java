package com.example.edon.bhis.Custom.Models;

public class TokenResult {
    public Integer id;
    public String token;

    public TokenResult() {
    }

    public TokenResult(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
