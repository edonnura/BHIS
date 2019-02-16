package com.example.edon.bhis;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.Examination;
import com.example.edon.bhis.Custom.Models.Origin;
import com.example.edon.bhis.Custom.Models.PatientCase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class OriginFragment extends Fragment {

    TextView tvRegisterNumber,tvPatientOrigin,tvPatientState,tvTreatmentType,tvInstitution,tvTrafficAccident;
    ListView lvExaminations;
    Origin origin;
    List<Examination> examinations = new ArrayList<>();
    public OriginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();

        int IdVisit = getActivity().getIntent().getIntExtra("IdVisit", 0);
        String authToken = new SessionHelper(getActivity()).getToken();

        new RequestHelper().Get(new UrlHelper().getUrlOrigin(IdVisit),authToken, getContext(),  new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                origin = new Gson().fromJson(result,Origin.class);
                tvRegisterNumber.setText(origin.getRegisterNumber());
                tvPatientOrigin.setText(origin.getPatientOrigin());
                tvPatientState.setText(origin.getInitialStateType());
                tvTreatmentType.setText(origin.getTreatmentType());
                tvInstitution.setText(origin.getInstitutionName());
                tvTrafficAccident.setText(origin.getTrafficAccident() ? "Po":"Jo");
            }

            @Override
            public void onFailure(String result) {

            }
        });
        new RequestHelper().Get(new UrlHelper().getUrlExamination(IdVisit),authToken, getContext(),  new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                examinations = new Gson().fromJson(result, new TypeToken<List<Examination>>() {
                }.getType());
                lvExaminations.setAdapter(new Adapter());
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
        return inflater.inflate(R.layout.fragment_origin, container, false);
    }



    private void initView(){
        tvRegisterNumber = getView().findViewById(R.id.tvRegisterNumber);
        tvPatientOrigin = getView().findViewById(R.id.tvPatientOriginValue);
        tvPatientState = getView().findViewById(R.id.tvPatientStateValue);
        tvTreatmentType = getView().findViewById(R.id.tvTreatmentTypeValue);
        tvInstitution = getView().findViewById(R.id.tvInstitutionValue);
        tvTrafficAccident = getView().findViewById(R.id.tvTrafficAccidentValue);
        lvExaminations = getView().findViewById(R.id.lvExamination);
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return examinations.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.examination_item, null);

            TextView tvExaminationValue = view.findViewById(R.id.tvExaminationValue);
            tvExaminationValue.setText(examinations.get(position).getCode()+" - "+examinations.get(position).getExaminationType());

            return view;
        }
    }
}
