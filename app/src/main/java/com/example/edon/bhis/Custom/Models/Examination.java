package com.example.edon.bhis.Custom.Models;

public class Examination {
    private   Integer Id;
    private Integer IdICDType;
    private   String ExaminationType;
    private   String Code;

    public Examination() {
    }

    public Examination(Integer id, Integer idICDType, String examinationType, String code) {
        Id = id;
        IdICDType = idICDType;
        ExaminationType = examinationType;
        Code = code;
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

    public String getExaminationType() {
        return ExaminationType;
    }

    public void setExaminationType(String examinationType) {
        ExaminationType = examinationType;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
