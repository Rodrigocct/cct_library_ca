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
 * @author rodrigo
 */
public abstract class File {

    public String fileName;
    public BufferedReader readFile;
    public DataOutputStream saveFile;

    public File() {
    }

    public abstract void loadData();
    public abstract void saveData();

}
