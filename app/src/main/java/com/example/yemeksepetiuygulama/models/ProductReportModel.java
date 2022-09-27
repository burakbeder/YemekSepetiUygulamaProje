package com.example.yemeksepetiuygulama.models;

public class ProductReportModel {


    private int id;
    private String ad;
    private int fiyat;
    private int kategoriId;
    private String kategoriAd;

    public ProductReportModel(int id, String ad, int fiyat, int kategoriId, String kategoriAd) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.kategoriId = kategoriId;
        this.kategoriAd = kategoriAd;
    }

    @Override
    public String toString() {
        return ad + " : " + fiyat +"TL  ";
    }

    public ProductReportModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAd() {
        return kategoriAd;
    }

    public void setKategoriAd(String kategoriAd) {
        this.kategoriAd = kategoriAd;
    }
}
