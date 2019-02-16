package com.example.edon.bhis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.PatientCase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class VisitsActivity extends AppCompatActivity {

    ListView lvHistory;
    List<PatientCase> patientCases = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);

        setTitle("Vizitat sipas dates");
        lvHistory = findViewById(R.id.lvHistory);
        SessionHelper sessionHelper = new SessionHelper(getApplicationContext());

        new RequestHelper().Get(new UrlHelper().getUrlVisits(sessionHelper.getId()), sessionHelper.getToken(), VisitsActivity.this, new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                patientCases = new Gson().fromJson(result, new TypeToken<List<PatientCase>>() {
                }.getType());

                lvHistory.setAdapter(new Adapter());
            }

            @Override
            public void onFailure(String result) {

            }
        });

        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                //intent.putExtra("IdVisit",patientCases.get(position).getId());
                startActivity(new Intent(VisitsActivity.this,DetailsActivity.class)
                        .putExtra("IdVisit",patientCases.get(position).getId()));
            }
        });

    }


    class  Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return patientCases.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.history_item,null);

            TextView tvDate = convertView.findViewById(R.id.tvHistoryDate);
            tvDate.setText(patientCases.get(position).getInsertionDateFormated());
            return convertView;
        }
    }
}
