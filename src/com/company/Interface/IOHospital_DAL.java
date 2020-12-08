package com.company.Interface;
import com.company.Entities.Hospital;

import java.util.ArrayList;

public interface IOHospital_DAL {
    void writeFile(ArrayList<Hospital> docTors);
    void readFile(ArrayList<Hospital>docTors);
}
