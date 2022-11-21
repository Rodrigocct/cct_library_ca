/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rodrigo
 */
public class Borrowing implements Serializable{
    int id;
    Date borrowingDate;
    Date borrowingReturnDate;
    Book book;
    Student student;
    
}
