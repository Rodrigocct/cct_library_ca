/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.entities;

import cctlibrary.utils.MyOwnQueue;
import java.io.Serializable;

/**
 *
 * @author rodrigo & anastasiia
 */
public class Reservation implements Serializable{
    String bookId;// to know the book that is the student wants to reservate
    MyOwnQueue students;/*to know who is the student in the queue, one book can have 
many student in waiting list, so with MyOwnQueue we make sure that the first on the 
queue has the priority.*/

//MyOwnQueue is our own implementation we got it from in class examples

    public Reservation() {
        this.students = new MyOwnQueue(20);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public MyOwnQueue getStudents() {
        return students;
    }

    public void setStudents(MyOwnQueue students) {
        this.students = students;
    }
}
