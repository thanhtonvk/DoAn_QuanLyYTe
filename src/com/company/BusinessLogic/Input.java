package com.company.BusinessLogic;


public class Input {
    public static String inputString() {
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
        return str;
    }
    public static String quiz(){
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
        if(str.equals("1")) return "không";
        else if(str.equals("2")) return "có";
        else if(str.equals("3")) return "thường xuyên";
        else return "đã bỏ";
    }
    public static String ncovid(){
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
        if(str.equals("1")) return "Có ";
        else  return "Không ";
    }
    public static void clear(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
    public static void readLine(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        scanner.nextLine();
    }

}
