package com.company.Presentation;

import com.company.BusinessLogic.*;
import com.company.DataAccess.DocTor_DAL;
import com.company.DataAccess.Hospital_DAL;
import com.company.Entities.Bot;
import com.company.DataAccess.Person_DAL;
import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Person_GUI {
    public void user(Person_BLL person_bll, ArrayList<Person> people, ArrayList<Hospital> hospitals, ArrayList<DocTor> docTors, Person_DAL person_dal,ArrayList<Bot>bots,Hospital_GUI hospital_gui, DocTor_GUI docTor_gui, Hospital_BLL hospital_bll, Hospital_DAL hospital_dal, DocTor_BLL docTor_bll, DocTor_DAL docTor_dal) throws IOException {
        String choose;
        while (true) {
            System.out.println("                            ╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("                            ║    1.Đăng nhập    ║     2.Tạo tài khoản       ║  0.Thoát      ║");
            System.out.println("                            ╚═══════════════════════════════════════════════════════════════╝");
            choose = Input.inputString();
            if (choose.equals("0")) break;
            switch (choose) {
                case "1":
                    signIn(people, hospitals, docTors, person_bll, person_dal,bots,hospital_gui,docTor_gui,hospital_bll,hospital_dal,docTor_bll,docTor_dal);
                    System.out.println("Nhập enter để tiếp tục");
                    Input.readLine();
                    break;
                case "2":
                    signUp(person_bll, people,person_dal);
                    System.out.println("Nhập enter để tiếp tục");
                    Input.readLine();
                    break;
                default:
                    break;
            }
        }
    }

    private void signUp(Person_BLL person_bll, ArrayList<Person> people,Person_DAL person_dal) throws IOException {
        person_bll.signUp(people);
        person_dal.writeInfo(people);
    }

    private void signIn(ArrayList<Person> people, ArrayList<Hospital> hospitals, ArrayList<DocTor> docTors, Person_BLL person_bll, Person_DAL person_dal, ArrayList<Bot>bots, Hospital_GUI hospital_gui, DocTor_GUI docTor_gui, Hospital_BLL hospital_bll, Hospital_DAL hospital_dal, DocTor_BLL docTor_bll, DocTor_DAL docTor_dal) throws IOException {
        Person person = person_bll.signIn(people);
        while (true) {
            if (person != null) break;
            else {
                System.out.println("                            ╦═════════════════════════════════════════════╦");
                System.out.println("                            ║  Tài khoản hoặc mật khẩu không chính xác!   ║");
                System.out.println("                            ╚═════════════════════════════════════════════╝");
                person = person_bll.signIn(people);
            }
        }
        String choose;
        while (true) {
            Input.clear();
            Menu(person);
            choose = Input.inputString();
            if (choose.equals("6")) break;
            switch (choose) {
                case "1":
                    person_bll.proFile(person);
                    Input.readLine();
                    break;
                case "2":
                    person_bll.quizStory(person);
                    person_dal.writeInfo(people);
                    Input.readLine();
                    break;
                case "3":
                    person_bll.soKham(person);
                    person_dal.writeInfo(people);
                    Input.readLine();
                    break;
                case "4":
                    person_bll.khaiBaoYTe(person);
                    person_dal.writeInfo(people);
                    Input.readLine();
                    break;
                case "5":
                    person_bll.datLichKham(hospitals, docTors, person);
                    person_dal.writeInfo(people);
                    Input.readLine();
                    break;
                case "7":
                    ChatBot.chat(bots,person_bll,person,hospitals,docTors,hospital_gui,docTor_gui,hospital_bll,hospital_dal,docTor_bll,docTor_dal);
                default:
                    break;
            }
        }
    }

    private void Menu(Person person) {
        System.out.println("                            ╔══════════════════════════════════════════════════════════╗");
        System.out.printf("                            ║%-10s%45s║                             \n", "CHÀO NGÀY MỚI", "║" + person.getName());
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║                        CHỨC NĂNG                         ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║ ➀HỒ SƠ THÔNG TIN  ║ ➁KHẢO SÁT TIỂU SỬ   ║   ➂Lịch hẹn   ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║ ➃KHAI BÁO Y TẾ    ║ ➄ĐẶT LỊCH KHÁM      ║   ➅ĐĂNG XUẤT  ║");
        System.out.println("                            ║══════════════════════════════════════════════════════════║");
        System.out.println("                            ║                       7. Chat với bot                    ║");
        System.out.println("                            ╚══════════════════════════════════════════════════════════╝");
    }
}
