package com.company.BusinessLogic;


import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static String inputMaBS(ArrayList<DocTor> docTors) {
        java.util.Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        boolean kt = true;
        while (kt) {
            for (DocTor docTor : docTors
            ) {
                if (docTor.getMabs().equalsIgnoreCase(user)) {
                    System.out.println("                            ║═══════════════════║═════════════════════════╬");
                    System.out.print("                            ║Mã bác sĩ tồn tại  ║   ");
                    user = scanner.nextLine();
                    break;
                } else kt = false;
            }
        }
        return user;
    }

    public static String inputMaBV(ArrayList<Hospital> hospitals) {
        java.util.Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        boolean kt = true;
        while (kt) {
            for (Hospital hospital : hospitals
            ) {
                if (hospital.getMabv().equalsIgnoreCase(user)) {
                    System.out.println("                            ║═══════════════════║═════════════════════════╬");
                    System.out.print("                            ║Mã BV đã tồn tại   ║   ");
                    user = scanner.nextLine();
                    break;
                } else kt = false;
            }
        }
        return user;
    }

    public static String inputUserName(ArrayList<Person> people) {
        java.util.Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        boolean kt = true;
        while (kt) {
            for (Person person : people
            ) {
                if (!person.getUsername().equalsIgnoreCase(user)) {
                    kt = false;
                }
            }
            if (kt == true) {
                System.out.println("                            ║═══════════════════║═════════════════════════╬");
                System.out.print("                            ║Tài khoản tồn tại  ║   ");
                user = scanner.nextLine();
            }
        }
        return user;
    }

    public static String inputString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String str = scanner.nextLine();
        boolean kt = true;
        while (kt) {
            if (str.equals("")) {
                System.out.println("                            ║═══════════════════║═════════════════════════╬");
                System.out.print("                            ║Phải khác rỗng     ║   ");
                str = scanner.nextLine();
            } else kt = false;
        }
        return str;
    }

    public static String quiz() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String str = "";
        boolean check = true;
        while (check) {
            try {
                str = scanner.nextLine();
                if (str != "") check = false;
            } catch (Exception e) {
                if (str == "") {
                    System.out.println("Chuỗi khác rỗng");
                }
            }
        }
        if (str.equals("1")) return "không";
        else if (str.equals("2")) return "có";
        else if (str.equals("3")) return "thường xuyên";
        else return "đã bỏ";
    }

    public static String ncovid() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String str = "";
        boolean check = true;
        while (check) {
            try {
                str = scanner.nextLine();
                if (str != "") check = false;
            } catch (Exception e) {
                if (str == "") {
                    System.out.println("Chuỗi khác rỗng");
                }
            }
        }
        if (str.equals("1")) return "Có ";
        else return "Không ";
    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static void readLine() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        scanner.nextLine();
    }

}
