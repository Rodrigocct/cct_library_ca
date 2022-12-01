/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.utils;

import cctlibrary.entities.Book;
import cctlibrary.entities.Student;
import java.util.ArrayList;
/**
 *
 * @author rodrigo & anastasiia
 */
public class MySearchingUtils {

    /*
        BOOKS SECTION
    to search by author
    */
    
    public int linearSearchBookByAuthor(ArrayList<Book> array, String target) {
        for (int i = 0; i < array.size(); i++) {
            String authorName = array.get(i).getAuthorFirstName() + " " + array.get(i).getAuthorLastName();
            if (authorName.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
    //to search by title
    
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
    
    /*
        STUDENTS SECTION
    to search student by name
    */    
    
    public int linearSearchStudentByName(ArrayList<Student> array, String target) {
        for (int i = 0; i < array.size(); i++) {
            String name = array.get(i).getFirstname() + " " + array.get(i).getSurname();
            if (name.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
    
    public int binarySearch(ArrayList<Student> array, int target) {        
        int start = 0;
        int end = array.size() - 1;
        int mid; 
        
        while(start<=end){
            mid = (start + end)/2;            
            if(array.get(mid).getId()== target){                
                return mid;                
            }else if(array.get(mid).getId()<target){
                start = mid + 1;
                
            }else{
                end = mid - 1;
            }
        }
        return -1;

    }
}
