/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.entities;

import java.io.Serializable;

/**
 *
 * @author rodrigo & anastasiia
 */
public class Student implements Serializable {

    int id;
    String firstname;
    String surname;
    String documentNumber;
    String gender;
    String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return id + "," + firstname + "," + surname + "," + documentNumber + "," + gender + "," + birthday;
    }

    public int compareToByName(Student student) {
        return (this.getFirstname() + " " + this.getSurname()).compareTo(student.getFirstname() + " " + student.getSurname());
    }

}
