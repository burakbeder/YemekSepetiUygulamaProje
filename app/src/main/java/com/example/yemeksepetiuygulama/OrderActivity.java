package com.example.yemeksepetiuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    TextView tv_Tutar;
    TextView tv_yemek;
    Button bt_Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tv_Tutar=(TextView) findViewById(R.id.tv_Tutar);
        tv_yemek=findViewById(R.id.tv_Yemek);
        bt_Add=findViewById(R.id.bt_Add);


        Intent intentOrder = getIntent();
        int data = intentOrder.getIntExtra("Key",0);
        //String data = intent.getStringExtra("Key");
      //  tv_Tutar.setText(data) ;




    }
}