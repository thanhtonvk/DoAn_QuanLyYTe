package com.company.BusinessLogic;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;
import com.company.Interface.IPerson_BLL;

import java.io.*;
import java.util.ArrayList;

public class Person_BLL implements IPerson_BLL {
    @Override
    public void signUp(ArrayList<Person>people){
//        private String username;
//        private String password;
//        private String name;
//        private String dateofbirth;
//        private String address;
//        private String numberofinsurance;
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║           ĐĂNG KÝ TÀI KHOẢN                 ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Nhập tài khoản     ║   ");
        String username = Input.inputUserName(people);
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập mật khẩu      ║   ");
        String password = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập họ tên        ║   ");
        String name = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập ngày sinh     ║   ");
        String dateofbirh = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập địa chỉ       ║   ");
        String address = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập số BHYT       ║   ");
        String numberofinsurance = Input.inputString();
        System.out.println("                            ╚═══════════════════╝═════════════════════════╝");
        ArrayList<String>story = new ArrayList<>();
        story.add("");
        ArrayList<String>sokham = new ArrayList<>();
        sokham.add("");
        people.add(new Person(username,password,name,dateofbirh,address,numberofinsurance,story,sokham));
    }
    @Override
    public Person signIn(ArrayList<Person>people){
        System.out.println("                            ╦═════════════════════════════════════════════╦");
        System.out.println("                            ║                  ĐĂNG NHẬP                  ║");
        System.out.println("                            ╚═════════════════════════════════════════════╝");
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Nhập tài khoản     ║   ");
        String username = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        System.out.print("                            ║Nhập mật khẩu      ║   ");
        String password = Input.inputString();
        System.out.println("                            ║═══════════════════║═════════════════════════╬");
        Person result = null;
        for (Person person: people
             ) {
            if(username.equalsIgnoreCase(person.getUsername())&&password.equalsIgnoreCase(person.getPassword())){
                result = person;
            }
        }
        return result;
    }

    @Override
    public void datLichKham(ArrayList<Hospital>hospitals,ArrayList<DocTor>docTors,Person person){

        System.out.println("                            ╔═════╦══════════╦════════════════════════════════════════╦════════════════════════════════════════╗");
        System.out.printf("                            ║%-5s║%-10s║%-40s║%40s║\n", "STT", "Mã BV", "Tên bệnh viện", "Địa chỉ");
        System.out.println("                            ║═════╬══════════╬════════════════════════════════════════║════════════════════════════════════════╗");
        for (int i = 0; i < hospitals.size(); i++) {
            {
                Hospital_BLL.displayHospital(hospitals,i);
            }
        }
        System.out.println("                            ╚═════╚══════════╚════════════════════════════════════════║════════════════════════════════════════╝");
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Chọn bệnh viện:    ╠   ");
        String i = Input.inputString();
        System.out.println("                            ╠═══════════════════╠═════════════════════════╬");
        Hospital hospital = Hospital_BLL.getHospital(hospitals, Integer.parseInt(i)-1);
        System.out.println("                            ╔═════╦══════════╦════════════════════╦═════╦══════════════════════════════╦══════════════════════════════╗");
        System.out.printf("                            ║%-5s║%-10s║%-20s║%-5s║%-30s║%-30s║\n","STT", "Mã bác sĩ", "Tên bác sĩ", "Tuổi", "Khoa", "Tên BV");
        System.out.println("                            ║═════║══════════║════════════════════║═════║══════════════════════════════║══════════════════════════════║");
        for(int j = 0;j<docTors.size();j++){
            if(hospital.getMabv().equalsIgnoreCase(docTors.get(j).getMabv()))
            System.out.printf("                            ║%-5s║%-10s║%-20s║%-5s║%-30s║%-30s║\n", docTors.indexOf(docTors.get(j)),docTors.get(j).getMabs(), docTors.get(j).getTenbs(), docTors.get(j).getTuoi(), docTors.get(j).getKhoa(), docTors.get(j).getMabv());
        }
        System.out.println("                            ╚═════╚══════════╚════════════════════╚═════╚══════════════════════════════╚══════════════════════════════╝");
        System.out.println("                            ╔═══════════════════╦═════════════════════════╗");
        System.out.print("                            ║Chọn bác sĩ:       ╠   ");
        String index = Input.inputString();
        System.out.println("                            ╚═══════════════════╝═════════════════════════╝");
        DocTor docTor = docTors.get(Integer.parseInt(index));
        ArrayList<String>sokham = new ArrayList<>();
        sokham.add(java.time.LocalDate.now()+"/"+" "+"/"+" "+"/"+docTor.getTenbs()+"/"+hospital.getTenbv());
        person.setSokham(sokham);
    }
    @Override
    public void khaiBaoYTe(Person person){
        try {
            FileWriter fileWriter = new FileWriter("DataBase/NCoViD/khaibao.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.print(person.getNumberofinsurance()+" ");
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║                       Bạn có bị sốt?                          ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");

            printWriter.print("Sốt: "+Input.ncovid());
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║                       Bạn có bị ho?                           ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");

            printWriter.print("Ho: "+Input.ncovid());
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║                       Bạn có bị khó thở?                      ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");

            printWriter.print("Khó thở: "+Input.ncovid());
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║                    Bạn có bị đau người, mệt mỏi?              ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");

            printWriter.print("Đau người,mệt mỏi: "+Input.ncovid());
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║Trong vòng 14 ngày có tiếp xúc với trường hợp bệnh hoặc nghi   ║");
            System.out.println("                            ║                   ngờ mắc covid không?                        ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("Tiếp xúc: "+Input.ncovid());
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║                    Có đi về từ vùng dịch không?               ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            System.out.println("                            ║             1.Có             ║            2.Không             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");

            printWriter.print("Vùng dịch: "+Input.ncovid());
            printWriter.println("");
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void soKham(Person person){
        ArrayList<String>sokham = person.getSokham();
        System.out.println("                            ╔════════════════════╦════════════════════╦════════════════════╦════════════════════╦══════════════════════════════╗");
        System.out.printf("                            ║%-20s║%-20s║%-20s║%-20s║%-30s║\n", "Lần khám", "Xét nghiệm", "Chẩn đoán", "Bác sĩ", "Bệnh viện");
        System.out.println("                            ║══════════════════════════════════════════════════════════════════════════════════════════════════════════════════║");
        try {
            for (String str : sokham
            ) {
                String lankham = str.split("/")[0];
                String xetnghiem = str.split("/")[1];
                String chandoan = str.split("/")[2];
                String bacsi = str.split("/")[3];
                String benhvien = str.split("/")[4];
                System.out.printf("                            ║%-20s║%-20s║%-20s║%-20s║%-30s║\n", lankham, xetnghiem, chandoan, bacsi, benhvien);
            }
            System.out.println("                            ╚════════════════════╝════════════════════╝════════════════════╝════════════════════╝══════════════════════════════╝");
        }catch (Exception e){

        }
    }
    @Override
    public void quizStory(Person person){
        ArrayList<String>story = new ArrayList<>();
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║          Yếu tố nguy cơ đối với sức khỏe cá nhân              ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("");
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                       Hút thuốc lá, lào                       ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("                            ║   1.Không   ║    2.Có     ║   3.Thường xuyên ║   4.Đã bỏ      ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        story.add("Hút thuôc lá, lào: "+Input.quiz());
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                         Uống rượu bia                         ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("                            ║   1.Không   ║    2.Có     ║   3.Thường xuyên ║   4.Đã bỏ      ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        story.add("Uống rượu bia: "+Input.quiz());
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                       Sử dụng ma túy                          ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("                            ║   1.Không   ║    2.Có     ║   3.Thường xuyên ║   4.Đã bỏ      ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        story.add("Sử dụng ma túy: "+Input.quiz());
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                       Hoạt động thể lực                       ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("                            ║   1.Không   ║    2.Có     ║   3.Thường xuyên ║   4.Đã bỏ      ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        story.add("Hoạt động thể lực: "+Input.quiz());
        System.out.println("");
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                         Tiền sử di ứng                        ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("");
        System.out.println("                            ╔═══════════════════╦═══════════════════════════════════════════╗");
        System.out.print("                            ║    Thuốc          ║   ");
        String thuoc = Input.inputString();
        story.add("Thuốc: "+thuoc);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║  Hóa chất/Mỹ phẩm ║   ");
        String mypham = Input.inputString();
        story.add("Hóa chất/Mỹ phẩm: "+mypham);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║   Thực phẩm       ║   ");
        String thucpham = Input.inputString();
        story.add("Thực phẩm: "+thucpham);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║       Khác        ║   ");
        String khac = Input.inputString();
        story.add("Khác: "+khac);
        System.out.println("                            ╚═══════════════════╝═══════════════════════════════════════════╝");
        System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                         Bệnh tật                              ║");
        System.out.println("                            ║    Ghi rõ quan hệ huyết thống(ông,bà, bố, mẹ ,anh ,chị)       ║");
        System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("");
        System.out.println("                            ╔═══════════════════╦═══════════════════════════════════════════╗");
        System.out.print("                            ║   Tim mạch        ║   ");
        String benhtimmach = Input.inputString();
        story.add("Tim mạch: "+benhtimmach);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║  Huyết áp         ║   ");
        String huyetap = Input.inputString();
        story.add("Huyết áp: "+huyetap);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║   Tâm thần        ║   ");
        String tamthan = Input.inputString();
        story.add("Tâm thần: "+tamthan);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║      Hen suyễn    ║   ");
        String hensuyen = Input.inputString();
        story.add("Hen suyễn: "+hensuyen);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║     Tiểu đường    ║   ");
        String tieuduong = Input.inputString();
        story.add("Tiểu đường: "+tieuduong);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║      Động kinh    ║   ");
        String dongkinh = Input.inputString();
        story.add("Động kinh: "+dongkinh);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║      Ung thư      ║   ");
        String ungthu = Input.inputString();
        story.add("Ung thư: "+ungthu);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║      Lao          ║   ");
        String lao = Input.inputString();
        story.add("Lao: "+lao);
        System.out.println("                            ║═══════════════════║═══════════════════════════════════════════╬");
        System.out.print("                            ║     Khác          ║   ");
        String other = Input.inputString();
        story.add("Khác: "+other);
        System.out.println("                            ╚═══════════════════╝═══════════════════════════════════════════╝");
        person.setStory(story);
    }
    @Override
    public void editProfile(Person person){
        while (true) {
            String chon;
            System.out.println("                            ╔═══════════════╦═══════════════╦═══════════════╦═══════════════╗");
            System.out.println("                            ║  1.Họ tên     ║  2.Ngày sinh  ║  3.Địa chỉ    ║  4. Số BHYT   ║");
            System.out.println("                            ╚═══════════════╚═══════════════╚═══════════════╚═══════════════╝");
            System.out.println("                            ║          5.Đổi mật khẩu       ║           0.Thoát             ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            chon = Input.inputString();
            if (chon.equals("0")) break;
            switch (chon) {
                case "1":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập họ tên        ║   ");
                    person.setName(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");

                    break;
                case "2":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập ngày sinh     ║   ");
                    person.setDateofbirth(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");


                    break;
                case "3":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập địa chỉ       ║   ");
                    person.setAddress(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");
                    Input.clear();
                    Input.inputString();
                    break;
                case "4":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập số BHYT       ║   ");
                    person.setNumberofinsurance(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");

                    break;
                case "5":
                    System.out.println("                            ╔═══════════════════╔═════════════════════════╗");
                    System.out.print("                            ║Nhập mật khẩu mới  ║   ");
                    person.setPassword(Input.inputString());
                    System.out.println("                            ╚═══════════════════╚═════════════════════════╝");

                    break;
                default:
                    break;
            }
        }
    }
    @Override
    public void proFile(Person person){
        System.out.println("                            ╔══════════════════════════════════════════════════════════╗");
        System.out.println("                            ║                     THÔNG TIN CÁ NHÂN                    ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.printf("                            ║%-10s   ║%44s║                             \n", "Họ và tên", person.getName());
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.printf("                            ║%-10s   ║%44s║                             \n", "Ngày sinh", person.getDateofbirth());
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.printf("                            ║%-10s   ║%44s║                             \n", "Địa chỉ", person.getAddress());
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.printf("                            ║%-10s  ║%44s║                             \n", "Số thẻ BHYT", person.getNumberofinsurance());
        System.out.println("                            ╚══════════════════════════════════════════════════════════╝");
        String choose;
        while (true) {
            System.out.println("                            ╔══════════════════════════════════════════════════════════╗");
            System.out.println("                            ║  ❶Sửa thông tin cá nhân║➁ Tiểu sử      ║ ⓿Trở về        ║");
            System.out.println("                            ╚══════════════════════════════════════════════════════════╝");
            choose = Input.inputString();
            if (choose.equals("0")) break;
            switch (choose) {
                case "1":
                    editProfile(person);
                    Input.readLine();
                    break;

                case "2":
                    for (String str:person.getStory()
                         ) {
                        System.out.println(str);
                    }
                    Input.readLine();
                    break;
                default:
                    break;
            }

        }

    }

}
