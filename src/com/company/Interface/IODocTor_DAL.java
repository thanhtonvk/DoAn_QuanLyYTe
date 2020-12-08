package com.company.Interface;

import com.company.Entities.DocTor;

import java.util.ArrayList;

public interface IODocTor_DAL {
    void writeFile(ArrayList<DocTor>docTors);
    void readFile(ArrayList<DocTor>docTors);
}
