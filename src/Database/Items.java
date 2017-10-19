/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Connect.HOST_NAME;
import static Database.Connect.PASSWORD;
import static Database.Connect.URL;
import Files.CustomersReports;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class Items {

    private String name;
    private int quantity;
    private String size;
    private float docPrice;
    private float cusPrice;
    private String query;
    private int zz;

    public void setSize(String size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCusPrice(float cusPrice) {
        this.cusPrice = cusPrice;
    }

    public void setDocPrice(float docPrice) {
        this.docPrice = docPrice;
    }

    public void addNew() {
        try (Connection conn = DriverManager.getConnection(URL, HOST_NAME, PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            query = "Insert into Store (itemID,itemQuantity,itemCustomerPrice,itemDocPrice,itemSize) Values ('"
                    + name + "',"
                    + quantity
                    + "," + cusPrice + ","
                    + docPrice + ",'" + size + "')";

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to updateItem " + ex.getMessage());
        }

    }

    public void updateExisting(int zz) {
        try (Connection conn = DriverManager.getConnection(URL, HOST_NAME, PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            int z = 0;
            this.zz = zz;
            z = 1;
            if (z != 0) {
                query = "Update  Store SET itemID='" + name + "',itemQuantity="
                        + (quantity) + ",itemCustomerPrice="
                        + cusPrice + ",itemDocPrice=" + docPrice + ",itemSize='" + size + "' WHERE itemID='" + name + "' AND itemSize='" + size + "'";
                stmt.executeUpdate(query);
                if (zz != quantity) {
                    report();
                }
            } else {
                JOptionPane.showMessageDialog(null, "cancelled");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to Add Item " + ex.getMessage());
        }

    }

    private void report() {
        CustomersReports cr = new CustomersReports();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        cr.writeDataAboutStore(timestamp.toString(), name, size, String.valueOf(quantity - zz));
    }
}
