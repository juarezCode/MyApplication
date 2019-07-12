package com.juarez.myapplication.model;

public class Key {
    private String apikey;
    private String userkey;
    private String username;
    private String token;

    public Key(String apikey, String userkey, String username) {
        this.apikey = apikey;
        this.userkey = userkey;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
