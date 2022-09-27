package com.example.yemeksepetiuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.yemeksepetiuygulama.models.CustomersReportModel;
import com.example.yemeksepetiuygulama.others.HttpsTrustManager;
import com.example.yemeksepetiuygulama.others.MySingleton;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText et_Password,et_Email;
    TextView tv_login;
    Context context;

  //  public LoginActivity(Context context) {
        //this.context = context;}
    public static final String QUERY_FOR = "https://10.0.2.2:7220/api/Customers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        btn_login=findViewById(R.id.btn_login);
        et_Password=findViewById(R.id.et_Password);
        et_Email=findViewById(R.id.et_Email);
        tv_login=findViewById(R.id.tv_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HttpsTrustManager.allowAllSSL();
                ArrayList<CustomersReportModel> customersReportModels =new ArrayList<>();
                String url =QUERY_FOR;

                StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                //        startActivity(new Intent(LoginActivity.this,CategoriesActivity.class));
                        final String mstring=et_Email.getText().toString();
                        String  pstr= et_Password.getText().toString();

                        Gson gson =new Gson();
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            List<String> passwordList=new ArrayList<>();
                            List<String> stringList=new ArrayList<>();
                         for (int i = 0; i < jsonArray.length(); i++) {
                               JSONObject from_api = (JSONObject) jsonArray.get(i);

                             final String passwordControlStr= String.valueOf(from_api.getInt("sifre"));
                               final String mailControlStr=from_api.getString("email");
                             //     stringList.set(i, mailControlStr);
                              stringList.add(i,mailControlStr);
                              passwordList.add(i,passwordControlStr);
                        }
                            boolean found = false;
                            for (int i = 0; i < stringList.size(); i++) {
                                if ( stringList.get(i).equals(mstring)&& passwordList.get(i).equals(pstr) ) {
                                    Toast.makeText(LoginActivity.this, " Giriş Başarılı Hoşgeldiniz ", Toast.LENGTH_SHORT).show();


                                    startActivity(new Intent(LoginActivity.this, CategoriesActivity.class));
                                    //hakanari@gmail.com -	1234
                                    //burakbeder96@gmail.com - 	7650
                                    //canersancak@gmail.com	-  4321
                                    //aysegu@gmail.com	-  1234
                                    //cyy@mail.com	-  9875
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                Toast.makeText(LoginActivity.this,"Giriş Hatalı Tekrar Deneyin",Toast.LENGTH_LONG).show();

                        }
                    }

                         catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
               MySingleton.getInstance(LoginActivity.this).addToRequestQueue(request);
            }
        });

    }
}