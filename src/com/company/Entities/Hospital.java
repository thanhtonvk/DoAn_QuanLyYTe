package com.company.Entities;

public class Hospital {
    private String mabv;
    private String tenbv;
    private String diachi;

    @Override
    public String toString(){
        return mabv+"#"+tenbv+"#"+diachi;
    }
    public String getMabv() {
        return mabv;
    }

    public void setMabv(String mabv) {
        this.mabv = mabv;
    }

    public String getTenbv() {
        return tenbv;
    }

    public void setTenbv(String tenbv) {
        this.tenbv = tenbv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Hospital(String mabv, String tenbv, String diachi) {
        this.mabv = mabv;
        this.tenbv = tenbv;
        this.diachi = diachi;
    }
}
