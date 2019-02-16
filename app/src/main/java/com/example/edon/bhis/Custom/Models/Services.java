package com.example.edon.bhis.Custom.Models;

public class Services {
    public Integer Id;
    public String Service;

    public Services() {
    }

    public Services(Integer id, String service) {
        Id = id;
        Service = service;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }
}
