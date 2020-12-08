package com.company.DataAccess;

import com.company.Entities.Hospital;
import com.company.Interface.IOHospital_DAL;

import java.io.*;
import java.util.ArrayList;

public class Hospital_DAL implements IOHospital_DAL {

    static File file = new File("DataBase/Hospital/hospital.txt");

    @Override
    public void writeFile(ArrayList<Hospital> hospitals) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Hospital hospital : hospitals
            ) {
                fileWriter.write(hospital.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Can not open file");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readFile(ArrayList<Hospital> hospitals) {
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while((line = bufferedReader.readLine())!=null){
                    hospitals.add(new Hospital(line.split("#")[0],line.split("#")[1],line.split("#")[2]));
                }
                fileReader.close();
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                e.getMessage();
                System.out.println("Can not open file");
            } catch (IOException e) {
                e.getMessage();
                System.out.println("file is empty");
            }
        }
    }
}
