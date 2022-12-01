/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.data;

import java.io.BufferedReader;
import java.io.DataOutputStream;

/**
 *
 * @author rodrigo & anastasiia
 */
//this is like a main class so tha we can extend after
public abstract class File {
//denine the variables that will be extended
    public String fileName;
    public BufferedReader readFile;
    public DataOutputStream saveFile;

    public File() {
    }
//to define the abastract methods that it is implemented on the song class
    public abstract void loadData();
    public abstract void saveData();

}
