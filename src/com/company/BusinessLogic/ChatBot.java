package com.company.BusinessLogic;

import com.company.Entities.DocTor;
import com.company.Entities.Hospital;
import com.company.Entities.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Bot {
    private String cauhoi, dapan;

    public Bot(String cauhoi, String dapan) {
        this.cauhoi = cauhoi;
        this.dapan = dapan;
    }

    public Bot() {

    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }
}

public class ChatBot {

    public static void add(ArrayList<Bot> bots) {
        File file = new File("DataBase/Chatbot/bot.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bots.add(new Bot(line.split("#")[0], line.split("#")[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void chat(ArrayList<Bot> bots, Person_BLL person_bll, Person person, ArrayList<Hospital> hospitals, ArrayList<DocTor> docTors) {
        Scanner scanner = new Scanner(System.in);
        String nguoi;
        String chon;
        while (true) {
            boolean kt = false;
            System.out.print("Bạn: ");
            nguoi = scanner.nextLine();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (nguoi.toLowerCase().contains("xem lịch khám")) {
                System.out.println("Có phải bạn muốn xem lịch khám?Y/N");
                chon = scanner.nextLine();
                if (chon.equalsIgnoreCase("y")) {
                    person_bll.soKham(person);
                }

            } else if (nguoi.toLowerCase().contains("đặt lịch khám")) {
                System.out.println("Có phải bạn muốn đặt lịch khám?Y/N");
                chon = scanner.nextLine();
                if (chon.equalsIgnoreCase("y")) {
                    person_bll.datLichKham(hospitals, docTors, person);
                }

            } else if (nguoi.toLowerCase().contains("xem tiểu sử")) {
                person_bll.proFile(person);
            } else if (nguoi.equalsIgnoreCase("end")) break;
            else {
                for (Bot bot : bots
                ) {
                    if (nguoi.toLowerCase().contains(bot.getCauhoi())) {
                        System.out.printf("Bot: %s\n", bot.getDapan());
                        kt = true;
                        break;
                    }
                }
                if (kt == false) {
                    System.out.println("Bot: Xin lỗi tôi chưa được dạy");
                }
            }
        }
        System.out.println("Cảm ơn bạn đã nói chuyện với tôi, Love you 3000");
    }

    public static void main(String[] args) {

    }
}
