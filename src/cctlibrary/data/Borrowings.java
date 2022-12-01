/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.data;

import cctlibrary.entities.Borrowing;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo & anastasiia
 */
//an extension of the principal class file so it inherit the methods and atributes.
public class Borrowings extends File {

    HashSet<Borrowing> fileData = new HashSet<>();//we use HashSet to avoid borrowings duplication

    public Borrowings() {
        this.fileName = "data/BORROWINGS_DATA.csv";
    }

    public HashSet<Borrowing> getFileData() {
        return fileData;
    }

    public void setFileData(HashSet<Borrowing> fileData) {
        this.fileData = fileData;
    }
      
//to read the data from borrowing entitie and storage in fileData
    @Override
    public void loadData() {
        String[] data;
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            
            String contentLine = readFile.readLine();
            while (contentLine != null) {
                Borrowing x = new Borrowing();
                data = contentLine.split(",");
                x.setBookId(data[0]);
                x.setStudentId(Integer.valueOf(data[1]));
                this.fileData.add(x);
                contentLine = readFile.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    // to register the borrowing
    public void saveData() {
        try {
            saveFile = new DataOutputStream(new FileOutputStream(fileName));
            for (Borrowing xx :this.getFileData()){
                saveFile.writeBytes(xx.getBookId()+","+xx.getStudentId()+"\n");//read and save the data in memory
            } 
           // to write and register the borrowing inside the file borrowings
            saveFile.flush();
            saveFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
