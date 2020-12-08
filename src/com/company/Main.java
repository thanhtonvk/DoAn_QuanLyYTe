package com.company;

import com.company.BusinessLogic.DocTor_BLL;
import com.company.BusinessLogic.Hospital_BLL;
import com.company.BusinessLogic.Input;
import com.company.BusinessLogic.Person_BLL;
import com.company.DataAccess.DocTor_DAL;
import com.company.DataAccess.Hospital_DAL;
import com.company.DataAccess.Person_DAL;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;
import com.company.Presentation.DocTor_GUI;
import com.company.Presentation.Hospital_GUI;
import com.company.Presentation.Person_GUI;
import com.company.Presentation.Run;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        Hospital_BLL hospital_bll = new Hospital_BLL();
        Hospital_DAL hospital_dal = new Hospital_DAL();
        Person_GUI person_gui = new Person_GUI();
        Hospital_GUI hospital_gui = new Hospital_GUI();
        DocTor_GUI docTor_gui = new DocTor_GUI();
        Person_BLL person_bll = new Person_BLL();
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Hospital> hospitals = new ArrayList<>();
        ArrayList<DocTor> docTors = new ArrayList<>();
        Person_DAL person_dal = new Person_DAL();
        DocTor_BLL docTor_bll = new DocTor_BLL();
        DocTor_DAL docTor_dal = new DocTor_DAL();
        person_dal.readInfo(people);
        docTor_dal.readFile(docTors);
        hospital_dal.readFile(hospitals);
        Run run = new Run();
        run.run(hospital_bll, hospital_dal, person_gui, hospital_gui, docTor_gui, person_bll, people, hospitals, docTors, person_dal, docTor_bll, docTor_dal);
    }
}