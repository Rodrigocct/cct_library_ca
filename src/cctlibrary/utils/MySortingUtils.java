/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.utils;

import cctlibrary.entities.Book;

/**
 *
 * @author rodrigo
 */
public class MySortingUtils {

    public void bubbleSortByAuthor(Book[] array) {
        int n = array.length;
        Book temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareToByAuthor(array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    public void bubbleSortByTitle(Book[] array) {
        int n = array.length;
        Book temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareToByTitle(array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
