package com.company.DataAccess;

import com.company.Entities.DocTor;
import com.company.Interface.IODocTor_DAL;

import java.io.*;
import java.util.ArrayList;

public class DocTor_DAL implements IODocTor_DAL {

    static File file = new File("DataBase/DocTor/doctor.txt");

    @Override
    public void writeFile(ArrayList<DocTor> docTors) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (DocTor docTor : docTors
            ) {
                fileWriter.write(docTor.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Can not open file");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readFile(ArrayList<DocTor> docTors) {
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while((line = bufferedReader.readLine())!=null){
                    docTors.add(new DocTor(line.split("#")[0],line.split("#")[1],line.split("#")[2],line.split("#")[3],line.split("#")[4]));
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
