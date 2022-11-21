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

    ArrayList<Book> listBooks = new ArrayList<>();

    public Books() {
        this.fileName = "data/BOOKS_DATA.csv ";
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }
    
    
    
    @Override
    public void openFile() {
        try {
            readFile = new BufferedReader(new FileReader(fileName));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadData() {
        String[] data;
        try {
            String contentLine = readFile.readLine();
            while (contentLine != null) {
                Book b = new Book();
                data = contentLine.split(",");
                b.setId(data[0]);
                b.setAuthorFirstName(data[1]);
                b.setAuthorLastName(data[2]);
                b.setBookTitle(data[3]);
                b.setGenre(data[4]);
                listBooks.add(b);
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void closeFile() {

    }

}
