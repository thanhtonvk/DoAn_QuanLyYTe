package com.company.Presentation;

import com.company.BusinessLogic.DocTor_BLL;
import com.company.BusinessLogic.Hospital_BLL;
import com.company.BusinessLogic.Input;
import com.company.DataAccess.Hospital_DAL;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;

import java.util.ArrayList;

public class Hospital_GUI {
    private void Menu(){
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║ 1.Nhập bệnh viện  ║      2.Hiện bệnh viện     ║  0.Thoát      ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
    }
    public void runMenu(Hospital_BLL hospital_bll, Hospital_DAL hospital_dal, ArrayList<Hospital>hospitals, DocTor_BLL docTor_bll, ArrayList<DocTor>docTors){
        String choose;
        while (true) {
            Input.clear();
            Menu();
            choose = Input.inputString();
            if(choose.equals("0")) break;
            switch (choose){
                case "1":
                   hospital_bll.addHospital(hospitals);
                   hospital_dal.writeFile(hospitals);
                    Input.readLine();
                    break;
                case "2":
                    hospital_bll.showHospital(hospitals,docTor_bll,docTors);
                    hospital_dal.writeFile(hospitals);
                    Input.readLine();
                    break;
                default:break;
            }
        }
    }

}
