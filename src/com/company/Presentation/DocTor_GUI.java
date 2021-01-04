package com.company.Presentation;

import com.company.BusinessLogic.DocTor_BLL;
import com.company.BusinessLogic.Input;
import com.company.DataAccess.DocTor_DAL;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;

import java.util.ArrayList;

public class DocTor_GUI {
    private void Menu(){
        System.out.println("                            ╔══════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                  QUẢN LÝ DANH SÁCH BÁC SĨ                ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║ ➀NHẬP THÔNG TIN   ║ ➁HIỆN DS BÁC SĨ  ║ ➂TÌM KIẾM        ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        ➃THOÁT                            ║");
        System.out.println("                            ╚══════════════════════════════════════════════════════════╝");
    }
    public void runMenu(ArrayList<DocTor>docTors, DocTor_BLL docTor_bll, DocTor_DAL docTor_dal, ArrayList<Hospital>hospitals){
        String choose;
        while (true) {
            Input.clear();
            Menu();
            choose = Input.inputString();
            if(choose.equals("4")) break;
            switch (choose){
                case "1":
                    docTor_bll.addDoctor(docTors,hospitals);
                    docTor_dal.writeFile(docTors);
                    System.out.println("Nhập enter để tiếp tục");
                    Input.readLine();
                    break;
                case "2":
                   docTor_bll.showDoctor(docTors);
                    System.out.println("Nhập enter để tiếp tục");
                    Input.readLine();
                    break;
                case "3":
                    docTor_bll.searchDoctor(docTors);
                    docTor_dal.writeFile(docTors);
                    System.out.println("Nhập enter để tiếp tục");
                    Input.readLine();
                    break;
                default:break;
            }
        }
    }
}
