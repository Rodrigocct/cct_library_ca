/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary;

import cctlibrary.data.Books;
import cctlibrary.entities.Book;
import cctlibrary.enums.BookSearchEnum;
import cctlibrary.utils.InputUtilities;
import cctlibrary.utils.SearchingUtils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rodrigo
 */
public class Main {

    private Books books;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        loadDatabase();
        init();
    }

    public void init() {
    }

    public void loadDatabase() {
        books = new Books();
        books.openFile();
        books.loadData();
    }

}
