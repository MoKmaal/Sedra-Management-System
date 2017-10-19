/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class HomeData {

    static List<String> docList;
    static List<String> cusList;
    static String Query = "SELECT customerName FROM Customer WHERE costomerType='";
    static ResultSet res;
    static Connection conn;
    static Statement stmt;

    public static List<String> getDoctorsList() throws SQLException {
        docList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't connect", JOptionPane.ERROR_MESSAGE);
        }
        res = stmt.executeQuery(Query + "Doctor'");
        res.beforeFirst();
        while (res.next()) {

            docList.add(res.getString("customerName"));

        }
        stmt.close();
        conn.close();

        return docList;
    }

    public static List<String> getCustorsList() throws SQLException {
        cusList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't connect", JOptionPane.ERROR_MESSAGE);
        }
        res = stmt.executeQuery(Query + "Customer'");
        res.beforeFirst();
        while (res.next()) {
            cusList.add(res.getString("customerName"));

        }
        stmt.close();
        conn.close();

        return cusList;
    }
}
