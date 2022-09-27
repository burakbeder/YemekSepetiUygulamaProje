package com.example.yemeksepetiuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yemeksepetiuygulama.models.ProductReportModel;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {






    Button btn_PdList;
    ListView lv_PdList;
    final CategoryDataService categoryDataService =new CategoryDataService(ProductsActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        btn_PdList=findViewById(R.id.btn_PdList);
        lv_PdList=findViewById(R.id.lv_PdList);

        Intent intent = getIntent();
        int data = intent.getIntExtra("Key",0);


/* */
        categoryDataService.getAllProductList(new CategoryDataService.GetProductListResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(ProductsActivity.this, "Hata", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(List<ProductReportModel> productReportModels) {

                ArrayAdapter arrayAdapter = new ArrayAdapter(ProductsActivity.this, android.R.layout.simple_list_item_1, productReportModels);
                lv_PdList.setAdapter(arrayAdapter);

                lv_PdList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String text = (String) lv_CtList.getItemAtPosition(position);
                     //   Intent intent = getIntent();
                     //int data = intent.getIntExtra("Key",0);
                        int toplam=0;
                    Toast.makeText(ProductsActivity.this, lv_PdList.getItemIdAtPosition((int) id)+". Sıradaki "
                            +lv_PdList.getItemAtPosition(position)+" Sepete Eklendi "+data+". Kategori", Toast.LENGTH_SHORT).show();
                           // String str= (String) lv_PdList.getItemAtPosition(position);
                        final int clickedItem = (int) lv_PdList.getItemIdAtPosition((int) id);
                        //  String secilenSehir = (String) lv_CtList.getItemAtPosition(position);
                        // Intent intentBrowser = new Intent(CategoriesActivity.this,MainActivity.class);
                        //intentBrowser.putExtra("lokasyon",secilenSehir);,

                         Intent intentOrder = new Intent(ProductsActivity.this, OrderActivity.class);
                        intentOrder.putExtra("Key",clickedItem);
                       startActivity(intentOrder);

                     //  startActivity(new Intent(ProductsActivity.this,OrderActivity.class));
                    }
                });
            }

        }) ;




    }









}

