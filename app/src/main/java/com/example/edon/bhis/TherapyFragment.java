package com.example.edon.bhis;

import android.content.Context;
import android.net.Uri;
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
import com.example.edon.bhis.Custom.Models.Services;
import com.example.edon.bhis.Custom.Models.Therapy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class TherapyFragment extends Fragment {
    List<Therapy> therapies = new ArrayList<>();
    List<Services> services = new ArrayList<>();

    ListView lvTherapy, lvServices;

    public TherapyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();

        int IdVisit = getActivity().getIntent().getIntExtra("IdVisit", 0);
        String authToken = new SessionHelper(getActivity()).getToken();

        new RequestHelper().Get(new UrlHelper().getUrlTherapy(IdVisit),authToken, getContext(), new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                therapies = new Gson().fromJson(result, new TypeToken<List<Therapy>>() {
                }.getType());

                lvTherapy.setAdapter(new Adapter(therapies));
            }

            @Override
            public void onFailure(String result) {

            }
        });

        new RequestHelper().Get(new UrlHelper().getUrlServices(IdVisit),authToken, getContext(), new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                services = new Gson().fromJson(result, new TypeToken<List<Services>>() {
                }.getType());
                lvServices.setAdapter(new AdapterServices(services));
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
        return inflater.inflate(R.layout.fragment_therapy, container, false);
    }

    private void initView(){
        lvTherapy = getView().findViewById(R.id.lvTherapy);
        lvServices = getView().findViewById(R.id.lvServices);
    }

    class Adapter extends BaseAdapter {

        private List<Therapy> therapyList;

        public  Adapter(List<Therapy> _therapyList){
            this.therapyList = _therapyList;
        }

        @Override
        public int getCount() {
            return therapyList.size();
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
            view = getLayoutInflater().inflate(R.layout.therapy_item, null);

            TextView tvDrugValue = view.findViewById(R.id.tvDrugValue);
            TextView tvQuantityValue = view.findViewById(R.id.tvQuantityValue);
            TextView tvFrequencyValue = view.findViewById(R.id.tvFrequencyValue);
            TextView tvDurationValue = view.findViewById(R.id.tvDurationValue);

            tvDrugValue.setText(therapyList.get(position).getDrug()+" ("+therapyList.get(position).getCode()+")");
            tvQuantityValue.setText(therapyList.get(position).getQuantity().toString());
            tvFrequencyValue.setText(therapyList.get(position).getFrequency().toString());
            tvDurationValue.setText(therapyList.get(position).getDuration());

            return view;
        }
    }

    class AdapterServices extends BaseAdapter {

        private List<Services> servicesList;

        public  AdapterServices(List<Services> _servicesList){
            this.servicesList = _servicesList;
        }

        @Override
        public int getCount() {
            return servicesList.size();
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

            TextView tvServiceValue = view.findViewById(R.id.tvExaminationValue);

            tvServiceValue.setText(servicesList.get(position).getService());

            return view;
        }
    }
}
