package com.company.BusinessLogic;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Interface.IDocTor_BLL;

import java.awt.*;
import java.util.ArrayList;

public class DocTor_BLL implements IDocTor_BLL {

    //    String mabs, String tenbs, String tuoi, String khoa, String mabv
    @Override
    public void addDoctor(ArrayList<DocTor> docTors, ArrayList<Hospital>hospitals) {
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Nhập mã bác sĩ:    ║   ");
        String mabacsi = Input.inputMaBS(docTors);
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập tên bác sĩ:   ║   ");
        String tenbacsi = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập tuổi        : ║   ");
        String tuoi = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập khoa:         ║   ");
        String khoa = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập mã bệnh viện: ║   ");
        String mabv = Input.checkMaBV(hospitals);
        System.out.println("                            ╚═══════════════════╝═════════════════════════╝");
        docTors.add(new DocTor(mabacsi, tenbacsi, tuoi, khoa, mabv));
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║           Nhập thành công!                  ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");
    }

    public static void display(DocTor docTor) {
        System.out.printf("                            ║%-10s╬%-20s║%-5s║%-30s║%-5s║\n", docTor.getMabs(), docTor.getTenbs(), docTor.getTuoi(), docTor.getKhoa(), docTor.getMabv());
    }

    @Override
    public void showDoctor(ArrayList<DocTor> docTors) {
        System.out.println("                            ╔══════════╦════════════════════╦═════╦══════════════════════════════╦═════╗");
        System.out.printf("                            ║%-10s╬%-20s║%-5s║%-30s║%-5s║\n", "Mã bác sĩ", "Tên bác sĩ", "Tuổi", "Khoa", "Mã BV");
        System.out.println("                            ║══════════║════════════════════║═════║══════════════════════════════║═════║");
        for (DocTor docTor : docTors
        ) {
            display(docTor);
        }
        System.out.println("                            ╚══════════╚════════════════════╚═════╚══════════════════════════════╚═════╝");
    }

    public static DocTor findOB(ArrayList<DocTor> docTors, String keyword) {
        DocTor result = null;
        for (DocTor docTor : docTors
        ) {
            if (keyword.equalsIgnoreCase(docTor.getMabs()) || keyword.equalsIgnoreCase(docTor.getTenbs()) || docTor.getTenbs().toLowerCase().endsWith(keyword.toLowerCase())) {
                result = docTor;
            }
        }
        return result;
    }

    @Override
    public void editDoctor(ArrayList<DocTor> docTors, DocTor search) {
        while (true) {
            Input.clear();

            String chon;
            System.out.println("                            ╔═══════════════╦═══════════════╦═══════════════╦═══════════════╗");
            System.out.println("                            ║  1.Tên bác sĩ ║     2.Tuổi    ║     3.Khoa    ║  4. Bệnh viện ║");
            System.out.println("                            ╚═══════════════╚═══════════════╚═══════════════╚═══════════════╝");
            System.out.println("                            ║                            0.Thoát                            ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            chon = Input.inputString();
            if (chon.equals("0")) break;
            switch (chon) {
                case "1":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập tên bác sĩ:   ║   ");
                    search.setTenbs(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                case "2":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập tuổi        : ║   ");
                    search.setTuoi(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                case "3":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập khoa:         ║   ");
                    search.setKhoa(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                case "4":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập mã bệnh viện: ║   ");
                    search.setMabv(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void searchDoctor(ArrayList<DocTor> docTors) {

        System.out.println("                            ╦═══════════════════╦═════════════════════════╦");
        System.out.print("                            ║Nhập mã hoặc tên:  ║   ");
        String keyword = Input.inputString();
        System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
        DocTor search = findOB(docTors, keyword);
        if (search == null) {
            System.out.println("                            ╦═════════════════════════════════════════════╦");
            System.out.println("                            ║          Không tìm thấy bác sĩ!             ║");
            System.out.println("                            ╚═════════════════════════════════════════════╝");
        } else {
            System.out.println("                            ╔══════════╦════════════════════╦═════╦══════════════════════════════╦═════╗");
            System.out.printf("                            ║%-10s║%-20s║%-5s║%-30s║%-5s║\n", "Mã bác sĩ", "Tên bác sĩ", "Tuổi", "Khoa", "Mã BV");
            System.out.println("                            ║══════════║════════════════════║═════║══════════════════════════════║═════║");
            display(search);
            System.out.println("                            ╚══════════╚════════════════════╚═════╚══════════════════════════════╚═════╝");
            String choose;
            while (true) {
                System.out.println("                            ╔══════════════════════╦═══════════════════════╦═══════════════╗");
                System.out.println("                            ║1.Sửa thông tin bác sĩ║ 2. Xóa thông tin      ║   0. Trở về   ║");
                System.out.println("                            ╚══════════════════════╚═══════════════════════╚═══════════════╝");
                choose = Input.inputString();
                if(choose.equals("0"))break;
                switch (choose) {
                    case "1":
                        editDoctor(docTors, search);
                    case "2":
                        deleteDoctor(docTors,search);
                    default:break;
                }

            }
        }
    }

    @Override
    public void deleteDoctor(ArrayList<DocTor> docTors, DocTor search) {
        docTors.remove(search);
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║               Xóa thành công                ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");

    }

}
