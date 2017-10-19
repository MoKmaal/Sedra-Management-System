/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Connect.HOST_NAME;
import static Database.Connect.PASSWORD;
import static Database.Connect.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class AddCustomerData {

    private String username;
    private String email;
    private String phone;
    private String address;
    private String type;

    private String query;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void execute() {
        try (Connection conn = DriverManager.getConnection(URL, HOST_NAME, PASSWORD);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            query = "Insert into Customer (customerName,customerMail,customerPhone,customerAddress,costomerType) Values ('"
                    + username + "','"
                    + email
                    + "','" + phone + "','"
                    + address
                    + "','" + type + "')";

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to create Customer " + ex.getMessage());
        }

    }
}
