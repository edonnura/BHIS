package com.example.edon.bhis.Custom.Models;

import android.content.Intent;

public class Therapy {
    public Integer Id;
    public Integer IdVisit;
    public String Code;
    public String Drug;
    public Integer IdDrug;
    public Integer Quantity;
    public Integer Frequency;
    public String FrequencyType;
    public String Duration;

    public Therapy() {
    }

    public Therapy(Integer id, Integer idVisit, String code, String drug, Integer idDrug, Integer quantity, Integer frequency, String frequencyType, String duration) {
        Id = id;
        IdVisit = idVisit;
        Code = code;
        Drug = drug;
        IdDrug = idDrug;
        Quantity = quantity;
        Frequency = frequency;
        FrequencyType = frequencyType;
        Duration = duration;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdVisit() {
        return IdVisit;
    }

    public void setIdVisit(Integer idVisit) {
        IdVisit = idVisit;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDrug() {
        return Drug;
    }

    public void setDrug(String drug) {
        Drug = drug;
    }

    public Integer getIdDrug() {
        return IdDrug;
    }

    public void setIdDrug(Integer idDrug) {
        IdDrug = idDrug;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getFrequency() {
        return Frequency;
    }

    public void setFrequency(Integer frequency) {
        Frequency = frequency;
    }

    public String getFrequencyType() {
        return FrequencyType;
    }

    public void setFrequencyType(String frequencyType) {
        FrequencyType = frequencyType;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
