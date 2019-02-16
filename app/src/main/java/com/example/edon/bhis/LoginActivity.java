package com.example.edon.bhis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edon.bhis.Custom.Helpers.RequestHelper;
import com.example.edon.bhis.Custom.Helpers.SessionHelper;
import com.example.edon.bhis.Custom.Helpers.UrlHelper;
import com.example.edon.bhis.Custom.Models.TokenResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText etPersonalNumber, etPassword;
    Button btnLogin;
    TokenResult tokenResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonBody = credentialsToJson();
                if(jsonBody!=null){
                    new RequestHelper().Post(new UrlHelper().getUrlLogin(), jsonBody, getApplicationContext(), new RequestHelper.ServerCallback() {
                        @Override
                        public void onSuccess(String result) {
                            tokenResult = new Gson().fromJson(result, new TypeToken<TokenResult>() {
                            }.getType());

                            SessionHelper sessionHelper = new SessionHelper(getApplicationContext());
                            sessionHelper.setToken(tokenResult.getToken());
                            sessionHelper.setId(tokenResult.getId());

                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onFailure(String result) {
                            Toast.makeText(getApplicationContext(), "Autentifikimi deshtoi", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "Problem me konvertimin ne JSON", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(new SessionHelper(getApplicationContext()).getToken()!=null)
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    private String credentialsToJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Username",etPersonalNumber.getText().toString());
            jsonObject.put("Password",etPassword.getText().toString());
            return  jsonObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
    private void initView() {
        etPersonalNumber = findViewById(R.id.etPersonalNumber);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
