package com.company.Interface;

import com.company.Entities.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface IOPerson_DAL {
    void writeInfo(ArrayList<Person>people) throws IOException;
    void readInfo(ArrayList<Person>people) throws IOException;
}
