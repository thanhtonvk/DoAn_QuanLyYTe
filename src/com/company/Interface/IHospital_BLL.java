package com.company.Interface;

import com.company.BusinessLogic.DocTor_BLL;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;

import javax.print.Doc;
import java.util.ArrayList;

public interface IHospital_BLL {
    void addHospital(ArrayList<Hospital>hospitals);
    void showHospital(ArrayList<Hospital> hospitals,DocTor_BLL docTor_bll,ArrayList<DocTor>docTors);
    void editHospital(ArrayList<Hospital> hospitals,Hospital hospital);
    void deleteHospital(ArrayList<Hospital> hospitals,Hospital hospital);
    void showDoctor(ArrayList<DocTor>docTors, DocTor_BLL docTor_bll,Hospital hospital);
}
