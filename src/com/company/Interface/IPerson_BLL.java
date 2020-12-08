package com.company.Interface;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;

import java.util.ArrayList;

public interface IPerson_BLL {
    void signUp(ArrayList<Person> people);
    Person signIn(ArrayList<Person>people);
    void datLichKham(ArrayList<Hospital>hospitals, ArrayList<DocTor>docTors, Person person);
    void khaiBaoYTe(Person person);
    void soKham(Person person);
    void quizStory(Person person);
    void editProfile(Person person);
    void proFile(Person person);
}
