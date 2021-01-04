package com.company.Interface;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;

import java.util.ArrayList;

public interface IDocTor_BLL {
    void addDoctor(ArrayList<DocTor>docTors, ArrayList<Hospital>hospitals);
    void showDoctor(ArrayList<DocTor>docTors);
    void editDoctor(ArrayList<DocTor> docTors, DocTor search);
    void searchDoctor(ArrayList<DocTor>docTors);
    void deleteDoctor(ArrayList<DocTor>docTors,DocTor search);
}
