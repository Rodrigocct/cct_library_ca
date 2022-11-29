/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.data;

import cctlibrary.entities.Book;
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
public class Books extends File {

    ArrayList<Book> fileData = new ArrayList<>();

    public Books() {
        this.fileName = "data/BOOKS_DATA.csv";
    }

    public ArrayList<Book> getFileData() {
        return fileData;
    }

    public void setFileData(ArrayList<Book> fileData) {
        this.fileData = fileData;
    }
    
    @Override
    public void loadData() {
        String[] data;
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            
            String contentLine = readFile.readLine();
            while (contentLine != null) {
                Book x = new Book();
                data = contentLine.split(",");
                x.setId(data[0]);
                x.setAuthorFirstName(data[1]);
                x.setAuthorLastName(data[2]);
                x.setBookTitle(data[3]);
                x.setGenre(data[4]);
                this.fileData.add(x);
                contentLine = readFile.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
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
