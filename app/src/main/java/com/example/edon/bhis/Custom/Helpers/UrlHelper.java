package com.example.edon.bhis.Custom.Helpers;

public class UrlHelper {
    private String urlMain = "http://192.168.0.17/BHISApi/api/";

    public String getUrlVisits(int idPatient) {
        return urlMain + "history/get?id=" + idPatient;
    }

    public String getUrlOrigin(int idVisit) {
        return urlMain + "history/origin?idvisit=" + idVisit;
    }

    public String getUrlExamination(int idVisit) {
        return urlMain + "history/examination?idvisit=" + idVisit;
    }

    public String getUrlDiagnose(int idVisit) {
        return urlMain + "history/diagnose?idvisit=" + idVisit;
    }

    public String getUrlTherapy(int idVisit) {
        return urlMain + "history/therapy?idvisit=" + idVisit;
    }

    public String getUrlServices(int idVisit) {
        return urlMain + "history/services?idvisit=" + idVisit;
    }

    public String getUrlReferral(int idVisit) {
        return urlMain + "history/referral?idvisit=" + idVisit;
    }

    public String getUrlConclusion(int idVisit) {
        return urlMain + "history/conclusion?idvisit=" + idVisit;
    }

    public String getUrlLogin() {
        return urlMain + "login/token";
    }

    public String getUrlAdvices() {
        return urlMain + "advices/get";
    }
}
