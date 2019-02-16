package com.example.edon.bhis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.Advices;
import com.example.edon.bhis.Custom.Models.PatientCase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdvicesActivity extends AppCompatActivity {

    ListView lvAdvices;
    List<Advices> advices = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices);
        setTitle("Keshilla Mjekesore");
        lvAdvices = findViewById(R.id.lvAdvices);
        SessionHelper sessionHelper = new SessionHelper(getApplicationContext());

        new RequestHelper().Get(new UrlHelper().getUrlAdvices(), sessionHelper.getToken(), AdvicesActivity.this, new RequestHelper.ServerCallback() {
            @Override
            public void onSuccess(String result) {
                advices = new Gson().fromJson(result, new TypeToken<List<Advices>>() {
                }.getType());

                lvAdvices.setAdapter(new Adapter());
            }

            @Override
            public void onFailure(String result) {

            }
        });

        lvAdvices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AdvicesActivity.this,AdvicesDetailActivity.class);
                intent.putExtra("IdAdvice",advices.get(position).getId());
                startActivity(intent);
            }
        });
    }

    class  Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return advices.size();
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
            convertView = getLayoutInflater().inflate(R.layout.advices_item,null);

            TextView tvTitle = convertView.findViewById(R.id.tvTitle);
            TextView tvPublisher = convertView.findViewById(R.id.tvPublisher);
            ImageView ivImage = convertView.findViewById(R.id.ivImageUrl);
            Picasso.get().load(advices.get(position).getImageUrl()).into(ivImage);
            tvTitle.setText(advices.get(position).getTitle());
            tvPublisher.setText(advices.get(position).getPublisher());
            return convertView;
        }
    }
}
