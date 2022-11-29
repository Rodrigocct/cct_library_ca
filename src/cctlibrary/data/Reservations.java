/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctlibrary.data;

import cctlibrary.entities.Reservation;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class Reservations extends File {

    ArrayList<Reservation> fileData = new ArrayList<>();

    public Reservations() {
        this.fileName = "data/RESERVATIONS_DATA.csv";
    }

    public ArrayList<Reservation> getFileData() {
        return fileData;
    }

    public void setFileData(ArrayList<Reservation> fileData) {
        this.fileData = fileData;
    }

    @Override
    public void loadData() {
        String[] data;
        try {
            readFile = new BufferedReader(new FileReader(fileName));

            String contentLine = readFile.readLine();
            while (contentLine != null) {
                Reservation x = new Reservation();
                data = contentLine.split(",");
                boolean existBook = false;
                if (!this.getFileData().isEmpty()) {
                    for (Reservation r : this.getFileData()) {
                        if (r.getBookId().equals(data[0])) {
                            r.getStudents().Enqueue(data[1]);
                            existBook = true;
                        }
                    }
                }
                if (!existBook) {
                    x.setBookId(data[0]);
                    x.getStudents().Enqueue(data[1]);
                    this.fileData.add(x);
                }
                contentLine = readFile.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saveData() {
        try {
            saveFile = new DataOutputStream(new FileOutputStream(fileName));
            for (Reservation r : this.getFileData()) {
                for (int i = 0; i < r.getStudents().size(); i++) {
                    saveFile.writeBytes(r.getBookId() + "," + r.getStudents().getData()[i] + "\n");
                }
            }
            saveFile.flush();
            saveFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Borrowings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
