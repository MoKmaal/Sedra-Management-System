/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class CustomersReports {

    String fileName;
    File file;
    FileWriter fileWriter;
    PrintWriter printWriter;
    String StorePath = "Store/";
    String payment = "payment/";
    String retrieve = "retrieve/";

    public void checkFileExists() {

    }

    public void writeDataIntoFile(String customerName, String invoiceID, String itemName, String itemSize, String Time, String quantity) {
        file = new File(retrieve + customerName + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't create file Check customerName");
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.printf(" %s,%s,%s,"
                    + "%s,%s", Time, itemName, itemSize, quantity, invoiceID);
            printWriter.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't write into file Check data");
        } finally {
            printWriter.close();
            try {
                fileWriter.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't close  file restart app and check your data stored");
            }

        }

    }

    public void writeDataIntoFile(String customerName, String Time, String paymentValue) {
        file = new File(payment + customerName + ".txt");
        File file2 = new File(payment + "total payment.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't create file Check customerName");
            }
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't create file Check customerName");
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.printf("%s,%s", Time, paymentValue);
            printWriter.println();
            fileWriter.close();
                        printWriter.close();

            fileWriter = new FileWriter(file2, true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.printf("%s,%s", Time, paymentValue);
            printWriter.println();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't write into file Check data");
        } finally {
            printWriter.close();
            try {
                fileWriter.close();
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't close  file restart app and check your data stored");
            }

        }

    }

    public void writeDataAboutStore(String time, String itemName, String itemSize, String itemQuantity) {
        file = new File(StorePath + "Store.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't create file Check customerName");
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.printf("%s,%s,%s"
                    + ",%s", time, itemName, itemSize, itemQuantity);
            printWriter.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't write into file Check data");
        } finally {
            printWriter.close();
            try {
                fileWriter.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Couldn't close  file restart app and check your data stored");
            }

        }
    }

}
