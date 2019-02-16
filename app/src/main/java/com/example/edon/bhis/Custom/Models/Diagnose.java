package com.example.edon.bhis.Custom.Models;

public class Diagnose {
    public Integer Id;
    public Integer IdICDType;
    public Boolean IsPrimary;
    public Boolean IsRelease;
    public String Diagnosis;
    public String Code;
    public Boolean IsComplication;

    public Diagnose() {
    }

    public Diagnose(Integer id, Integer idICDType, Boolean isPrimary, Boolean isRelease, String diagnosis, String code, Boolean isComplication) {
        Id = id;
        IdICDType = idICDType;
        IsPrimary = isPrimary;
        IsRelease = isRelease;
        Diagnosis = diagnosis;
        Code = code;
        IsComplication = isComplication;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdICDType() {
        return IdICDType;
    }

    public void setIdICDType(Integer idICDType) {
        IdICDType = idICDType;
    }

    public Boolean getPrimary() {
        return IsPrimary;
    }

    public void setPrimary(Boolean primary) {
        IsPrimary = primary;
    }

    public Boolean getRelease() {
        return IsRelease;
    }

    public void setRelease(Boolean release) {
        IsRelease = release;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Boolean getComplication() {
        return IsComplication;
    }

    public void setComplication(Boolean complication) {
        IsComplication = complication;
    }
}
