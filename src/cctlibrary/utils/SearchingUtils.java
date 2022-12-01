/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.utils;

import cctlibrary.entities.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo & anastasiia
 */

//both seaching utils: LinearSearch and binarySearch we got from the example we have done in class

public class SearchingUtils {

    public int linearSearchBookByAuthor(ArrayList<Book> array, String target) {
        for (int i = 0; i < array.size(); i++) {

            String authorName = array.get(i).getAuthorFirstName() + " " + array.get(i).getAuthorLastName();
            // Exactly Equals for Firstname + LastName
            if (authorName.equalsIgnoreCase(target)) {
//            if (authorName.toLowerCase().contains(target.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<Book> linearSearchBookByTitle(ArrayList<Book> array, String target) {
        ArrayList<Book> result = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            String title = array.get(i).getBookTitle();
            if (title.equalsIgnoreCase(target)) {
//            if (title.toLowerCase().contains(target.toLowerCase())) {
                result.add(array.get(i));
            }
        }
        return result;
    }

    public List<Book> binarySearch(ArrayList<Book> array, String target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
