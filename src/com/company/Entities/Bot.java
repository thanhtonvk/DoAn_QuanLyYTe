package com.company.Entities;

public class Bot {
    private String cauhoi, dapan;

    public Bot(String cauhoi, String dapan) {
        this.cauhoi = cauhoi;
        this.dapan = dapan;
    }

    public Bot() {

    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }
}
