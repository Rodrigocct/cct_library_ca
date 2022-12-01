/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.utils;

import cctlibrary.entities.Book;
import cctlibrary.entities.Student;

/**
 *
 * @author rodrigo & anastasiia
 * 
 * 
 */

//both sorting methods: bubbleSort and mergeSort we got from the example done in class
public class MySortingUtils {

    public void bubbleSortByBookAuthor(Book[] array) {
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
    
    public void bubbleSortByBookTitle(Book[] array) {
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
    
    public void bubbleSortByStudentName(Student[] array) {
        int n = array.length;
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].compareToByName(array[j]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    
    public void mergeSortStudentById(Student[] arr, int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
 
            mergeSortStudentById(arr, l, m);
            mergeSortStudentById(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
    
    void merge(Student[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getId() <= R[j].getId()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
