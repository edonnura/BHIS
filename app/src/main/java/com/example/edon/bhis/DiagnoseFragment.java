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
import com.example.edon.bhis.Custom.Models.Diagnose;
import com.example.edon.bhis.Custom.Models.Examination;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class DiagnoseFragment extends Fragment {

    List<Diagnose> diagnoses = new ArrayList<>();
    List<Diagnose> accompanionDiagnose = new ArrayList<>();
    List<Diagnose> complicationDiagnose = new ArrayList<>();
    List<Diagnose> releaseAccompanionDiagnose = new ArrayList<>();
    List<Diagnose> releaseComplicationDiagnose = new ArrayList<>();
    String primaryDiagnose = "", releasePrimaryDiagnose = "";

    TextView tvPrimaryDiagnose, tvReleasePrimaryDiagnose;
    ListView lvAccompanionDiagnose, lvComplicationDiagnose, lvReleaseAccompanionDiagnose, lvReleaseComplicationDiagnose;

    public DiagnoseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        int IdVisit = getActivity().getIntent().getIntExtra("IdVisit", 0);
        String authToken = new SessionHelper(getActivity()).getToken();
        new RequestHelper().Get(new UrlHelper().getUrlDiagnose(IdVisit),authToken, getContext(), new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                diagnoses = new Gson().fromJson(result, new TypeToken<List<Diagnose>>() {
                }.getType());
                for (Diagnose diagnose:diagnoses) {
                    if(diagnose.getComplication() && diagnose.getRelease())
                        complicationDiagnose.add(diagnose);
                    if(diagnose.getComplication() && !diagnose.getRelease())
                        releaseComplicationDiagnose.add(diagnose);
                    if(!diagnose.getPrimary() && !diagnose.getComplication() && !diagnose.getRelease())
                        accompanionDiagnose.add(diagnose);
                    if(!diagnose.getPrimary() && !diagnose.getComplication() && diagnose.getRelease())
                        releaseAccompanionDiagnose.add(diagnose);
                    if(diagnose.getPrimary() && !diagnose.getRelease())
                        primaryDiagnose = diagnose.getCode()+" - "+diagnose.getDiagnosis();
                    if(diagnose.getPrimary() && diagnose.getRelease())
                        releasePrimaryDiagnose = diagnose.getCode()+" - "+diagnose.getDiagnosis();

                    tvPrimaryDiagnose.setText(primaryDiagnose);
                    tvReleasePrimaryDiagnose.setText(releasePrimaryDiagnose);

                    lvAccompanionDiagnose.setAdapter(new Adapter(accompanionDiagnose));
                    lvComplicationDiagnose.setAdapter(new Adapter(complicationDiagnose));
                    lvReleaseAccompanionDiagnose.setAdapter(new Adapter(releaseAccompanionDiagnose));
                    lvReleaseComplicationDiagnose.setAdapter(new Adapter(releaseComplicationDiagnose));


                }
            }

            @Override
            public void onFailure(String result) {

            }
        });
    }

    private void initView(){
        tvPrimaryDiagnose = getView().findViewById(R.id.tvPrimaryDiagnoseValue);
        tvReleasePrimaryDiagnose = getView().findViewById(R.id.tvReleasePrimaryDiagnoseValue);
        lvAccompanionDiagnose = getView().findViewById(R.id.lvAccompanyDiagnoseValue);
        lvComplicationDiagnose = getView().findViewById(R.id.lvComplicationDiagnoseValue);
        lvReleaseAccompanionDiagnose = getView().findViewById(R.id.lvReleaseAccompanyDiagnoseValue);
        lvReleaseComplicationDiagnose = getView().findViewById(R.id.lvReleaseComplicationDiagnoseValue);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diagnose, container, false);
    }


    class Adapter extends BaseAdapter {

        private List<Diagnose> diagnoseList;

        public  Adapter(List<Diagnose> _diagnoseList){
            this.diagnoseList = _diagnoseList;
        }

        @Override
        public int getCount() {
            return diagnoseList.size();
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
            tvExaminationValue.setText(diagnoseList.get(position).getCode()+" - "+diagnoseList.get(position).getDiagnosis());

            return view;
        }
    }
}
