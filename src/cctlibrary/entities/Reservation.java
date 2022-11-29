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
 * @author rodrigo
 */
public class Reservation implements Serializable{
    String bookId;
    MyOwnQueue students;

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
