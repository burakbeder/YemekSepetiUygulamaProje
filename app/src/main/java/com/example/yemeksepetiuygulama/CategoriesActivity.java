package com.example.yemeksepetiuygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksepetiuygulama.models.CategoryReportModel2;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    Button btn_CtList;
    ListView lv_CtList;

    final CategoryDataService categoryDataService =new CategoryDataService(CategoriesActivity.this);
    static  int userClick;
    int getDetailsUserClick(){
        return userClick;
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_categories);
            btn_CtList=findViewById(R.id.btn_CtList);
            lv_CtList=findViewById(R.id.lv_CtList);

            categoryDataService.getAllCategoryList(new CategoryDataService.GetCategoryListResponseListener() {
                @Override
                public void onError(String message) {
                }
                @Override
                public void onResponse(List<CategoryReportModel2> categoryReportModels) {

                    ArrayAdapter arrayAdapter = new ArrayAdapter(CategoriesActivity.this, android.R.layout.simple_list_item_1, categoryReportModels);
                    lv_CtList.setAdapter(arrayAdapter);

                    lv_CtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //String text = (String) lv_CtList.getItemAtPosition(position);
                            Toast.makeText(CategoriesActivity.this, lv_CtList.getItemAtPosition(position)+" tiklandi", Toast.LENGTH_SHORT).show();

                          final int clickedItem = (int) lv_CtList.getItemIdAtPosition((int) id);
                          userClick=clickedItem;

                           Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
                           intent.putExtra("Key",clickedItem);
                           startActivity(intent);


                        }

                    });
                }

            }) ;
            /*
                   Gson gson = new Gson();
                   Type type = new TypeToken<ArrayList<CategoryReportModel>>() {}.getType();
                   ArrayList<CategoryReportModel> jsonObjects = new Gson().fromJson(, type);
*/


        }





       // lv_CtList.setClickable(true);






}
