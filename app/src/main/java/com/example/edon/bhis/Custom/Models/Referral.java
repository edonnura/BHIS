package com.example.edon.bhis.Custom.Models;

public class Referral {
    public Integer Id;
    public String OrganisationFrom;
    public String OrganisationTo;
    public String Description;
    public Boolean External;

    public Referral() {
    }

    public Referral(Integer id, String organisationFrom, String organisationTo, String description, Boolean external) {
        Id = id;
        OrganisationFrom = organisationFrom;
        OrganisationTo = organisationTo;
        Description = description;
        External = external;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOrganisationFrom() {
        return OrganisationFrom;
    }

    public void setOrganisationFrom(String organisationFrom) {
        OrganisationFrom = organisationFrom;
    }

    public String getOrganisationTo() {
        return OrganisationTo;
    }

    public void setOrganisationTo(String organisationTo) {
        OrganisationTo = organisationTo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getExternal() {
        return External;
    }

    public void setExternal(Boolean external) {
        External = external;
    }
}
