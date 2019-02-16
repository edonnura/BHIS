package com.example.edon.bhis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.Conclusion;
import com.example.edon.bhis.Custom.Models.Referral;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConclusionFragment extends Fragment {

    Referral referral;
    Conclusion conclusion;
    TextView tvOutsideReferral,tvOrganisationFrom,tvOrganisationTo,tvDescription,tvFurtherTreatment,tvReleaseState,tvConclusion,tvRecommendation;
    public ConclusionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        int IdVisit = getActivity().getIntent().getIntExtra("IdVisit", 0);
        String authToken = new SessionHelper(getActivity()).getToken();
        new RequestHelper().Get(new UrlHelper().getUrlReferral(IdVisit),authToken, getContext(), new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                referral = new Gson().fromJson(result, new TypeToken<Referral>(){}.getType());
                if(referral!=null){
                    tvOutsideReferral.setText(referral.getExternal() ? "Po" : "Jo");
                    tvOrganisationFrom.setText(referral.getOrganisationFrom());
                    tvOrganisationTo.setText(referral.getOrganisationTo());
                    tvDescription.setText(referral.getDescription());
                }
            }
            @Override
            public void onFailure(String result) {

            }
        });
        new RequestHelper().Get(new UrlHelper().getUrlConclusion(IdVisit),authToken, getContext(), new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                conclusion = new Gson().fromJson(result, new TypeToken<Conclusion>(){}.getType());
                if(conclusion!=null){
                    tvFurtherTreatment.setText(conclusion.getFurtherTreatment());
                    tvReleaseState.setText(conclusion.getReleaseState());
                    tvConclusion.setText(conclusion.getDescription());
                    tvRecommendation.setText(conclusion.getDescription());
                }
            }
            @Override
            public void onFailure(String result) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conclusion, container, false);
    }

    private void initView(){
        tvOutsideReferral = getView().findViewById(R.id.tvOutsideReferralValue);
        tvOrganisationFrom = getView().findViewById(R.id.tvReferralInstitutionFromValue);
        tvOrganisationTo = getView().findViewById(R.id.tvReferralInstitutionToValue);
        tvDescription = getView().findViewById(R.id.tvReferralDescriptionValue);
        tvFurtherTreatment = getView().findViewById(R.id.tvFurtherTreatmentValue);
        tvReleaseState = getView().findViewById(R.id.tvReleaseStateValue);
        tvConclusion = getView().findViewById(R.id.tvConclusionValue);
        tvRecommendation = getView().findViewById(R.id.tvRecommendationValue);
    }

}
