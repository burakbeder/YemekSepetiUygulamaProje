package com.example.yemeksepetiuygulama.models;

import com.example.yemeksepetiuygulama.models.ProductReportModel;

import java.util.ArrayList;

public class CategoryReportModel2 {


    private int id;

    private String kategori1;


    private ArrayList<ProductReportModel> yemeks;


    public CategoryReportModel2(int id, String kategori1, ArrayList<ProductReportModel> yemeks) {
        this.id = id;
        this.kategori1 = kategori1;
        this.yemeks = yemeks;
    }

    public CategoryReportModel2() {

    }

    @Override
    public String toString() {
        return  kategori1;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategori1() {
        return kategori1;
    }

    public void setKategori1(String kategori1) {
        this.kategori1 = kategori1;
    }

    public ArrayList<ProductReportModel> getYemeks() {
        return yemeks;
    }

    public void setYemeks(ArrayList<ProductReportModel> yemeks) {
        this.yemeks = yemeks;
    }
}
