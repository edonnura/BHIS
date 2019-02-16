package com.example.edon.bhis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.Advices;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdvicesDetailActivity extends AppCompatActivity {

    List<Advices> advices = new ArrayList<>();
    ImageView ivImage;
    TextView tvTitle,tvPublisher,tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices_detail);

        initView();

        Intent intent = getIntent();
        final Integer IdAdvice = intent.getIntExtra("IdAdvice",0);

        if(IdAdvice.intValue()>0){
            SessionHelper sessionHelper = new SessionHelper(getApplicationContext());
            new RequestHelper().Get(new UrlHelper().getUrlAdvices(), sessionHelper.getToken(), AdvicesDetailActivity.this, new RequestHelper.ServerCallback() {
                @Override
                public void onSuccess(String result) {
                    advices = new Gson().fromJson(result, new TypeToken<List<Advices>>() {
                    }.getType());

                    for(Advices advice: advices){
                        if(advice.getId().intValue()==IdAdvice){
                            Picasso.get().load(advice.getImageUrl()).into(ivImage);
                            tvTitle.setText(advice.getTitle());
                            setTitle(advice.getTitle());
                            tvPublisher.setText(advice.getPublisher());
                            tvContent.setText(advice.getContent());
                            break;
                        }
                    }
                }

                @Override
                public void onFailure(String result) {

                }
            });
        }
    }

    private void initView(){
        ivImage = findViewById(R.id.ivDetailsImageUrl);
        tvTitle = findViewById(R.id.tvDetailsTitle);
        tvPublisher = findViewById(R.id.tvDetailsPublisher);
        tvContent = findViewById(R.id.tvDetailsContent);

    }
}
