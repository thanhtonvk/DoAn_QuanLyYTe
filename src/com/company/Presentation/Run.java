package com.company.Presentation;

import com.company.BusinessLogic.DocTor_BLL;
import com.company.BusinessLogic.Hospital_BLL;
import com.company.BusinessLogic.Input;
import com.company.BusinessLogic.Person_BLL;
import com.company.DataAccess.DocTor_DAL;
import com.company.DataAccess.Hospital_DAL;
import com.company.DataAccess.Person_DAL;
import com.company.Entities.Bot;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Run {
    private void Menu(){
        System.out.println("                            ╔══════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                      QUẢN LÝ Y TẾ                        ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║ ➀NGƯỜI DÙNG       ║ ➁BỆNH VIỆN       ║   ➂BÁC SĨ        ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        ➃THOÁT                            ║");
        System.out.println("                            ╚══════════════════════════════════════════════════════════╝");
    }
    public void run(Hospital_BLL hospital_bll, Hospital_DAL hospital_dal, Person_GUI person_gui, Hospital_GUI hospital_gui, DocTor_GUI docTor_gui, Person_BLL person_bll, ArrayList<Person> people, ArrayList<Hospital> hospitals, ArrayList<DocTor> docTors, Person_DAL person_dal, DocTor_BLL docTor_bll, DocTor_DAL docTor_dal, ArrayList<Bot>bots) throws IOException {
        String choose;
        while (true) {
            Input.clear();
            Menu();
            choose = Input.inputString();
            if(choose.equals("4")) break;
            switch (choose){
                case "1":
                    person_gui.user(person_bll, people, hospitals, docTors,person_dal,bots,hospital_gui,docTor_gui,hospital_bll,hospital_dal,docTor_bll,docTor_dal);
                    Input.readLine();
                    break;
                case "2":
                    hospital_gui.runMenu(  hospital_bll,  hospital_dal, hospitals,  docTor_bll, docTors);
                    Input.readLine();
                    break;
                case "3":
                    docTor_gui.runMenu(docTors,docTor_bll,docTor_dal);
                    Input.readLine();
                    break;
                default:break;
            }
        }
    }
}
