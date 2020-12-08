package com.company.DataAccess;

import com.company.Entities.Person;
import com.company.Interface.IOPerson_DAL;

import java.io.*;
import java.util.ArrayList;

public class Person_DAL implements IOPerson_DAL {


    static File file = new File("DataBase/Person/info.txt");

    @Override
    public void writeInfo(ArrayList<Person> people) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Person person : people
            ) {
                fileWriter.write(person.writePerson() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Can not open file");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void readInfo(ArrayList<Person> people) {
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
//                    return username+"#"+password+"#"+name+"#"+dateofbirth+"#"+address+"#"+numberofinsurance+"#"+writeStory()+"#"+writeSokham();
                    String username = line.split("#")[0];
                    String password = line.split("#")[1];
                    String name = line.split("#")[2];
                    String dateofbirth = line.split("#")[3];
                    String address = line.split("#")[4];
                    String numberofinsunrance = line.split("#")[5];
                    ArrayList<String> story = new ArrayList<>();
                    try {
                        for (int i = 0; i < line.split("#")[6].split(";").length; i++) {
                            story.add(line.split("#")[6].split(";")[i]);

                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    ArrayList<String> sokham = new ArrayList<>();
                    try {
                        for (int i = 0; i < line.split("#")[7].split(";").length; i++) {
                            sokham.add(line.split("#")[7].split(";")[i]);

                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    people.add(new Person(username, password, name, dateofbirth, address, numberofinsunrance, story, sokham));

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
