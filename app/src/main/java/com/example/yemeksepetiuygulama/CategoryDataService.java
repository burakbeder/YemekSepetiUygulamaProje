package com.example.yemeksepetiuygulama;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.yemeksepetiuygulama.models.CategoryReportModel2;
import com.example.yemeksepetiuygulama.models.ProductReportModel;
import com.example.yemeksepetiuygulama.others.HttpsTrustManager;
import com.example.yemeksepetiuygulama.others.MySingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryDataService  {

    public static final String QUERY_FOR_CATEGORY_LIST = "https://10.0.2.2:7220/api/Categories";
    Context context;


    public CategoryDataService(Context context) {
        this.context = context;
    }



    public interface GetCategoryListResponseListener{
        void onError(String message);
        void onResponse(List<CategoryReportModel2> categoryReportModels);
    }

    public void getAllCategoryList(GetCategoryListResponseListener getCategoryListResponseListener){
        HttpsTrustManager.allowAllSSL();
        List<CategoryReportModel2> categoryReportModels =new ArrayList<>();
        String url =QUERY_FOR_CATEGORY_LIST;
        StringRequest request=new StringRequest(Request.Method.GET, url,  new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {

                //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                try {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<CategoryReportModel2>>() {
                    }.getType();
                    List<CategoryReportModel2> list = gson.fromJson(String.valueOf(response), listType);



              //      JSONArray kategori =response; response.getJSONArray("yemeks");

                    JSONArray jsonArray=new JSONArray(response);
                  //  JSONObject kategori=jsonArray.getJSONObject("kategori1");
                    for (int i = 0; i < jsonArray.length(); i++) {





                        JSONObject first_day_from_api = (JSONObject) jsonArray.get(i);


                      CategoryReportModel2 one_day= gson.fromJson(String.valueOf(first_day_from_api), CategoryReportModel2.class);


                        categoryReportModels.add(one_day);
                    }
                    getCategoryListResponseListener.onResponse(categoryReportModels);

                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

    }


    public interface GetProductListResponseListener{
        void onError(String message);
        void onResponse(List<ProductReportModel> productReportModels);
    }

    public void getAllProductList(GetProductListResponseListener getProductListResponseListener){
        HttpsTrustManager.allowAllSSL();

        ArrayList<ProductReportModel> productReportModels =new ArrayList<>();
        String url =QUERY_FOR_CATEGORY_LIST;

        StringRequest request =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson =new Gson();
                try {
                    JSONArray jsonArray=new JSONArray(response);
                   int clickk = CategoriesActivity.userClick;
                  //  int click=0;
                    JSONObject first_day_from_api = (JSONObject) jsonArray.get(clickk);
                    JSONArray yemekler=first_day_from_api.getJSONArray("yemeks");


                    for (int i = 0; i < yemekler.length() ; i++) {
                        JSONObject yemekobj= yemekler.getJSONObject(i);
                        ProductReportModel post=gson.fromJson(String.valueOf(yemekobj),ProductReportModel.class);
                        productReportModels.add(post);

                    }

                    getProductListResponseListener.onResponse(productReportModels);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }


        });
        MySingleton.getInstance(context).addToRequestQueue(request);


    }









}
