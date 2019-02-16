package com.example.edon.bhis.Custom.Models;

public class Origin {
    public  Integer Id;
    public  String AcceptanceDateString;
    public  String RegisterNumber;
    public  Integer IdOrganisation;
    public  Boolean TrafficAccident;
    public  String InstitutionName;
    public  Integer IdPatientOrigin;
    public  String PatientOrigin;
    public  Integer IdTreatmentType;
    public  String TreatmentType;
    public  String Description;
    public  Integer IdInitialStateType;
    public  String InitialStateType;
    public  Integer IdFurtherTreatment;
    public  Integer IdReleaseState;

    public Origin() {
    }

    public Origin(Integer id, String acceptanceDateString, String registerNumber, Integer idOrganisation, Boolean trafficAccident, String institutionName, Integer idPatientOrigin, String patientOrigin, Integer idTreatmentType, String treatmentType, String description, Integer idInitialStateType, String initialStateType, Integer idFurtherTreatment, Integer idReleaseState) {
        Id = id;
        AcceptanceDateString = acceptanceDateString;
        RegisterNumber = registerNumber;
        IdOrganisation = idOrganisation;
        TrafficAccident = trafficAccident;
        InstitutionName = institutionName;
        IdPatientOrigin = idPatientOrigin;
        PatientOrigin = patientOrigin;
        IdTreatmentType = idTreatmentType;
        TreatmentType = treatmentType;
        Description = description;
        IdInitialStateType = idInitialStateType;
        InitialStateType = initialStateType;
        IdFurtherTreatment = idFurtherTreatment;
        IdReleaseState = idReleaseState;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAcceptanceDateString() {
        return AcceptanceDateString;
    }

    public void setAcceptanceDateString(String acceptanceDateString) {
        AcceptanceDateString = acceptanceDateString;
    }

    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public Integer getIdOrganisation() {
        return IdOrganisation;
    }

    public void setIdOrganisation(Integer idOrganisation) {
        IdOrganisation = idOrganisation;
    }

    public Boolean getTrafficAccident() {
        return TrafficAccident;
    }

    public void setTrafficAccident(Boolean trafficAccident) {
        TrafficAccident = trafficAccident;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }

    public Integer getIdPatientOrigin() {
        return IdPatientOrigin;
    }

    public void setIdPatientOrigin(Integer idPatientOrigin) {
        IdPatientOrigin = idPatientOrigin;
    }

    public String getPatientOrigin() {
        return PatientOrigin;
    }

    public void setPatientOrigin(String patientOrigin) {
        PatientOrigin = patientOrigin;
    }

    public Integer getIdTreatmentType() {
        return IdTreatmentType;
    }

    public void setIdTreatmentType(Integer idTreatmentType) {
        IdTreatmentType = idTreatmentType;
    }

    public String getTreatmentType() {
        return TreatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        TreatmentType = treatmentType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getIdInitialStateType() {
        return IdInitialStateType;
    }

    public void setIdInitialStateType(Integer idInitialStateType) {
        IdInitialStateType = idInitialStateType;
    }

    public String getInitialStateType() {
        return InitialStateType;
    }

    public void setInitialStateType(String initialStateType) {
        InitialStateType = initialStateType;
    }

    public Integer getIdFurtherTreatment() {
        return IdFurtherTreatment;
    }

    public void setIdFurtherTreatment(Integer idFurtherTreatment) {
        IdFurtherTreatment = idFurtherTreatment;
    }

    public Integer getIdReleaseState() {
        return IdReleaseState;
    }

    public void setIdReleaseState(Integer idReleaseState) {
        IdReleaseState = idReleaseState;
    }
}
