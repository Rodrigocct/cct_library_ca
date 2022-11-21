/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.utils;

import cctlibrary.entities.Book;
import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class MySearchingUtils {

    public int linearSearchBookByAuthor(ArrayList<Book> array, String target) {
        for (int i = 0; i < array.size(); i++) {
            String authorName = array.get(i).getAuthorFirstName() + " " + array.get(i).getAuthorLastName();
            if (authorName.equalsIgnoreCase(target)) {
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
                result.add(array.get(i));
            }
        }
        return result;
    }
}
