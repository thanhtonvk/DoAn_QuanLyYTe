package com.company.Entities;

import java.util.ArrayList;
import java.util.Collections;

public class Person {
    private String username;
    private String password;
    private String name;
    private String dateofbirth;
    private String address;
    private String numberofinsurance;
    private ArrayList<String>story;
    private ArrayList<String>sokham;

    public Person(String username, String password, String name, String dateofbirth, String address, String numberofinsunrance, ArrayList<String> story, ArrayList<String> sokham) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.numberofinsurance = numberofinsunrance;
        this.story =story;
        this.sokham =sokham;
    }

    public ArrayList<String> getSokham() {
        return sokham;
    }

    public void setSokham(ArrayList<String> sokham) {
        this.sokham = sokham;
    }

    public Person(String username, String password, String name, String dateofbirth, String address, String numberofinsurance){
        this.username = username;
        this.password = password;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.numberofinsurance = numberofinsurance;
        this.story = new ArrayList<>();
        this.sokham= new ArrayList<>();
    }
    public String writePerson(){
        String sokhambenh = "";
        for(String str : sokham){
            sokhambenh +=str+";";
        }
        String tieusu = "";
        for(String str: story){
            tieusu +=str+";";
        }
        return username+"#"+password+"#"+name+"#"+dateofbirth+"#"+address+"#"+numberofinsurance+"#"+tieusu+"#"+sokhambenh;
    }

    public Person(String username, String password, String name, String dateofbirth, String address, String numberofinsurance, ArrayList<String> story) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.numberofinsurance = numberofinsurance;
        this.story = story;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberofinsurance() {
        return numberofinsurance;
    }

    public void setNumberofinsurance(String numberofinsurance) {
        this.numberofinsurance = numberofinsurance;
    }

    public ArrayList<String> getStory() {
        return story;
    }

    public void setStory(ArrayList<String> story) {
        this.story = story;
    }

}
