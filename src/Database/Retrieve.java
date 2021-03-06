/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Files.CustomersReports;
import Files.ReportData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class Retrieve {

    int recID;
    String itemName;
    String itemSize;
    int itemQuantity;
    String query;
    Connection conn;
    Statement stmt;
    String customerName;
    private int currentQStore;

    public void increaseStore(String customerName) {
        try {

            recID = Integer.parseInt(JOptionPane.showInputDialog("Enter Invoice ID"));
            itemName = JOptionPane.showInputDialog("Enter item Code");
            itemSize = JOptionPane.showInputDialog("Enter item Size");
            itemQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
            this.customerName = customerName;
            if (customerName.length() < 0) {
                customerName = JOptionPane.showInputDialog("Enter CustomerName");

            }

            query = "SELECT itemQuantity FROM Store WHERE itemID='" + itemName + "' AND itemSize='" + itemSize + "'";
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = stmt.executeQuery(query);
            res.next();
            currentQStore = res.getInt(1);

            System.out.println(currentQStore + itemQuantity);
            updateInvoice(res, recID, itemName, itemQuantity);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void updateInvoice(ResultSet res, int recID, String itemID, int itemQuantity) {
        try {
            query = "SELECT salesQuantity,paymentType FROM Sales WHERE itemID='" + itemName + "' AND recID=" + recID
                    + " AND Size='" + itemSize + "'";
            res = stmt.executeQuery(query);
            res.next();
            int currentQ = res.getInt(1);
            double paymentType = Double.parseDouble(res.getString(2));
            
            int temp = currentQ - itemQuantity;
            if (temp < 0) {
                JOptionPane.showMessageDialog(null, "Error: this invoice has only " + currentQ + " items");
            } else {
                int tmp = currentQ - itemQuantity;
              double lastReturnedDiscount=  paymentType*1.0*itemQuantity/currentQ;
                query = "UPDATE Sales SET salesQuantity=" + tmp + ", paymentType='"+(paymentType-lastReturnedDiscount)+"' WHERE itemID='" + itemName + "' AND Size='" + itemSize + "' AND recID=" + recID;
                Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt1.executeUpdate(query);
                query = "UPDATE Store SET itemQuantity=" + (currentQStore + itemQuantity) + " Where itemID='" + itemName + "' "
                        + " AND itemSize='" + itemSize + "'";
                Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                stmt2.executeUpdate(query);
                updateDebt(res, itemName, itemQuantity, customerName,lastReturnedDiscount);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "من فضلك تأكد من رقم الفاتورة وباقى البيانات المدخلة");
        }

    }

    public void updateDebt(ResultSet res, String itemID, int itemQuantity, String customerName,double lastReturnedDiscount) {
        try {

            query = "SELECT customerID FROM Sales where recID=" + recID;
            res = stmt.executeQuery(query);
            res.next();
            int custID = res.getInt(1);
            query = "SELECT customerDebtPayable FROM Customer WHERE customerID=" + custID;
            res = stmt.executeQuery(query);
            res.next();
            int debt = res.getInt(1);
            String type;
            query = "SELECT costomerType,discount FROM Customer WHERE customerID=" + custID;
            res = stmt.executeQuery(query);
            res.next();
            double customercurrentdiscount=Double.parseDouble(res.getString(2));
            type = res.getString(1);
            if (type.equalsIgnoreCase("Doctor")) {
                query = "SELECT itemDocPrice from Store Where itemID='" + itemID + "' AND itemSize='" + itemSize + "'";

            } else if (type.equalsIgnoreCase("Customer")) {
                query = "SELECT itemCustomerPrice from Store Where itemID='" + itemID + "' AND itemSize='" + itemSize + "'";

            }
            res = stmt.executeQuery(query);
            res.next();
            float price = res.getFloat(1);
            float returnedValue = itemQuantity * price;
            float remain = debt - returnedValue;
            remain+=lastReturnedDiscount;
            customercurrentdiscount-=lastReturnedDiscount;
            query = "UPDATE Customer SET customerDebtPayable= " + remain + ",Discount='"+customercurrentdiscount+"' WHERE customerName='" + customerName + "'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Done");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to update data " + ex.getMessage());
        }
        generateReport();

    }

    public void generateReport() {
        ReportData data = new ReportData();
        data.setCustomerName(customerName);
        data.setInvoiceID(String.valueOf(recID));
        data.setItem(itemName);
        data.setSize(itemSize);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        data.setTime(timestamp.toString());
        data.setQuantity(String.valueOf(itemQuantity));
        data.setFilePath(customerName + ".txt");
        CustomersReports cr = new CustomersReports();
        cr.writeDataIntoFile(customerName, data.getInvoiceID(), data.getItem(), data.getSize(), data.getTime(), data.getQuantity());
    }

}
