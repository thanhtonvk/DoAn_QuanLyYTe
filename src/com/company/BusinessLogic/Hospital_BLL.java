package com.company.BusinessLogic;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Interface.IHospital_BLL;

import java.util.ArrayList;

public class Hospital_BLL implements IHospital_BLL {

    @Override
    public void addHospital(ArrayList<Hospital> hospitals) {
//        String mabv, String tenbv, String diachi
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Nhập mã bệnh viện: ╠   ");
        String mabenhvien = Input.inputMaBV(hospitals);
        System.out.println("                            ╠═══════════════════╠═════════════════════════╬");
        System.out.print("                            ║Nhập tên bệnh viện:╠   ");
        String tenbenhvien = Input.inputString();
        System.out.println("                            ╠═══════════════════╠═════════════════════════╬");
        System.out.print("                            ║Nhập địa chỉ:      ╠   ");
        String diachi = Input.inputString();
        System.out.println("                            ╚═══════════════════╝═════════════════════════╝");
        hospitals.add(new Hospital(mabenhvien, tenbenhvien, diachi));
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║           Nhập thành công!                  ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");
    }

    public static void displayHospital(ArrayList<Hospital> hospitals, int i) {
        System.out.printf("                            ║%-5s║%-10s║%-40s║%40s║\n", i + 1, hospitals.get(i).getMabv(), hospitals.get(i).getTenbv(), hospitals.get(i).getDiachi());
    }

    public static Hospital getHospital(ArrayList<Hospital> hospitals, int i) {
        Hospital result = null;
        try {
            result = hospitals.get(i);
        } catch (Exception e) {
            System.out.println("Không tìm thấy");
        }
        return result;
    }

    @Override
    public void showHospital(ArrayList<Hospital> hospitals, DocTor_BLL docTor_bll, ArrayList<DocTor> docTors) {
        System.out.println("                            ╔═════╦══════════╦════════════════════════════════════════╦════════════════════════════════════════╗");
        System.out.printf("                            ║%-5s║%-10s║%-40s║%40s║\n", "STT", "Mã BV", "Tên bệnh viện", "Địa chỉ");
        System.out.println("                            ║═════╬══════════╬════════════════════════════════════════║════════════════════════════════════════╗");
        for (int i = 0; i < hospitals.size(); i++) {
             {
                displayHospital(hospitals,i);
            }
        }
        System.out.println("                            ╚═════╚══════════╚════════════════════════════════════════║════════════════════════════════════════╝");
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Chọn bệnh viện:    ╠   ");
        String i = Input.inputString();
        System.out.println("                            ╠═══════════════════╠═════════════════════════╬");
        Hospital hospital = getHospital(hospitals, Integer.parseInt(i)-1);
        String choose;
        while (true) {
            Input.clear();
            System.out.println("                            ╔══════════════════════╦═══════════════════════╦═══════════════════╦══════════════════╗");
            System.out.println("                            ║1.Sửa thông tin BV    ║ 2. Xóa thông tin      ║   3. Hiện bác sĩ  ║     0. Trở về    ║");
            System.out.println("                            ╚══════════════════════╚═══════════════════════╚═══════════════════╚══════════════════╝");
            choose = Input.inputString();
            if (choose.equals("0")) break;
            switch (choose) {
                case "1":
                    editHospital(hospitals, hospital);
                    Input.readLine();
                    break;
                case "2":
                    deleteHospital(hospitals, hospital);
                    Input.readLine();
                    break;
                case "3":
                    showDoctor(docTors, docTor_bll, hospital);
                    Input.readLine();
                default:
                    break;
            }

        }

    }

    @Override
    public void editHospital(ArrayList<Hospital> hospitals, Hospital hospital) {
        while (true) {
            String chon;
            System.out.println("                            ╔═══════════════╦═══════════════╦═══════════════╦═══════════════╗");
            System.out.println("                            ║   1.Mã BV     ║   2.Tên BV    ║  3. Địa chỉ   ║  0. Thoát     ║");
            System.out.println("                            ╚═══════════════╚═══════════════╚═══════════════╚═══════════════╝");
            chon = Input.inputString();
            if (chon.equals("0")) break;
            switch (chon) {
                case "1":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập mã BV     :   ║   ");
                    hospital.setMabv(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                case "2":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập tên BV      : ║   ");
                    hospital.setTenbv(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                case "3":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập địa chỉ:       ║   ");
                    hospital.setDiachi(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    public void deleteHospital(ArrayList<Hospital> hospitals, Hospital hospital) {
        hospitals.remove(hospital);
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║               Xóa thành công                ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");
    }

    @Override
    public void showDoctor(ArrayList<DocTor> docTors, DocTor_BLL docTor_bll, Hospital hospital) {
        System.out.println("                            ╔══════════╦════════════════════╦═════╦══════════════════════════════╦═════╗");
        System.out.printf("                            ║%-10s║%-20s║%-5s║%-30s║%-5s║\n", "Mã bác sĩ", "Tên bác sĩ", "Tuổi", "Khoa", "Mã BV");
        System.out.println("                            ║══════════║════════════════════║═════║══════════════════════════════║═════║");
        for (DocTor docTor : docTors
        ) {
            if (docTor.getMabv().equalsIgnoreCase(hospital.getMabv())) {
                docTor_bll.display(docTor);
            }
        }
        System.out.println("                            ╚══════════╚════════════════════╚═════╚══════════════════════════════╚═════╝");
    }

}
