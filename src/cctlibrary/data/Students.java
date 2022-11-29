/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.data;

import cctlibrary.entities.Student;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class Students extends File {

    ArrayList<Student> fileData = new ArrayList<>();

    public Students() {
        this.fileName = "data/STUDENTS_DATA.csv";
    }

    public ArrayList<Student> getFileData() {
        return fileData;
    }

    public void setFileData(ArrayList<Student> fileData) {
        this.fileData = fileData;
    }
    

    @Override
    public void loadData() {
        String[] data;
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            
            String contentLine = readFile.readLine();
            while (contentLine != null) {
                Student x = new Student();
                data = contentLine.split(",");
                x.setId(Integer.valueOf(data[0]));
                x.setFirstname(data[1]);
                x.setSurname(data[2]);
                x.setDocumentNumber(data[3]);
                x.setGenre(data[4]);
                x.setBirthday(data[5]);
                this.fileData.add(x);
                contentLine = readFile.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saveData() {
        try {
            saveFile = new DataOutputStream(new FileOutputStream(fileName));   
            saveFile.flush();
            saveFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
