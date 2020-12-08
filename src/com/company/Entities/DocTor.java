package com.company.Entities;

public class DocTor {
    private String mabs;
    private String tenbs;
    private String tuoi;
    private String khoa;
    private String mabv;

    @Override
    public String toString(){
        return mabs+"#"+tenbs+"#"+tuoi+"#"+khoa+"#"+mabv;
    }
    public String getMabs() {
        return mabs;
    }

    public void setMabs(String mabs) {
        this.mabs = mabs;
    }

    public String getTenbs() {
        return tenbs;
    }

    public void setTenbs(String tenbs) {
        this.tenbs = tenbs;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getMabv() {
        return mabv;
    }

    public void setMabv(String mabv) {
        this.mabv = mabv;
    }

    public DocTor(String mabs, String tenbs, String tuoi, String khoa, String mabv) {
        this.mabs = mabs;
        this.tenbs = tenbs;
        this.tuoi = tuoi;
        this.khoa = khoa;
        this.mabv = mabv;
    }
}
