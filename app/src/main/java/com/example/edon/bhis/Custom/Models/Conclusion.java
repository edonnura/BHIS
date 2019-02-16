package com.example.edon.bhis.Custom.Models;

public class Conclusion {
    public Integer Id;
    public String Description;
    public String Recommendation;
    public String FurtherTreatment;
    public String ReleaseState;

    public Conclusion() {
    }

    public Conclusion(Integer id, String description, String recommendation, String furtherTreatment, String releaseState) {
        Id = id;
        Description = description;
        Recommendation = recommendation;
        FurtherTreatment = furtherTreatment;
        ReleaseState = releaseState;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRecommendation() {
        return Recommendation;
    }

    public void setRecommendation(String recommendation) {
        Recommendation = recommendation;
    }

    public String getFurtherTreatment() {
        return FurtherTreatment;
    }

    public void setFurtherTreatment(String furtherTreatment) {
        FurtherTreatment = furtherTreatment;
    }

    public String getReleaseState() {
        return ReleaseState;
    }

    public void setReleaseState(String releaseState) {
        ReleaseState = releaseState;
    }
}
