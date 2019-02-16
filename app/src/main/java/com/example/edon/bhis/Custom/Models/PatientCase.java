package com.example.edon.bhis.Custom.Models;

import java.util.Date;

public class PatientCase {
    public  Integer id;
    public  Boolean closed;
//    public Date insertionDate;
    public  String insertionDateFormated;
    public  String insuranceNumber;
    public  String firstLast;
//    public  Date birthdate;
    public String personalNumber;
    public Integer idPatient;
    public Boolean isCaseManaged;
    public Boolean completedVisits;

    public PatientCase() {
    }

    public PatientCase(Integer id, Boolean closed, String insertionDateFormated, String insuranceNumber, String firstLast,  String personalNumber, Integer idPatient, Boolean isCaseManaged, Boolean completedVisits) {
        this.id = id;
        this.closed = closed;
        this.insertionDateFormated = insertionDateFormated;
//        this.insertionDate = insertionDate;
        this.insuranceNumber = insuranceNumber;
        this.firstLast = firstLast;
//        this.birthdate = birthdate;
        this.personalNumber = personalNumber;
        this.idPatient = idPatient;
        this.isCaseManaged = isCaseManaged;
        this.completedVisits = completedVisits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getClose() {
        return closed;
    }

    public void setClose(Boolean closed) {
        this.closed = closed;
    }

    public  String getInsertionDateFormated(){
        return  insertionDateFormated;
    }
    public  void setInsertionDateFormated(String insertionDateFormated){
        this.insertionDateFormated = insertionDateFormated;
    }
//    public Date getInsertionDate() {
//        return insertionDate;
//    }
//
//    public void setInsertionDate(Date insertionDate) {
//        this.insertionDate = insertionDate;
//    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getFirstLast() {
        return firstLast;
    }

    public void setFirstLast(String firstLast) {
        this.firstLast = firstLast;
    }

//    public Date getBirthDate() {
//        return birthdate;
//    }
//
//    public void setBirthDate(Date birthdate) {
//        this.birthdate = birthdate;
//    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Boolean getCaseManaged() {
        return isCaseManaged;
    }

    public void setCaseManaged(Boolean caseManaged) {
        isCaseManaged = caseManaged;
    }

    public Boolean getCompletedVisits() {
        return completedVisits;
    }

    public void setCompletedVisits(Boolean completedVisits) {
        this.completedVisits = completedVisits;
    }
}
