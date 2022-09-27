package com.example.yemeksepetiuygulama.models;

public class CustomersReportModel {
    private int id;
    private String ad;
    private String soyad;
    private String email;
    private int sifre;

    public CustomersReportModel(int id, String ad, String soyad, String email, int sifre) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
    }

    public CustomersReportModel() {
    }

    @Override
    public String toString() {
        return "CustomersReportModel{" +
                "email='" + email + '\'' +
                ", sifre=" + sifre +
                '}';
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

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }
}
