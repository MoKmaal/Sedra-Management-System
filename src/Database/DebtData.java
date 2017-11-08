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
public class DebtData {

    static String query;
    static float haveToPay = 0;
    static ResultSet res = null;

    public static void execute(String name, float cost) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, HOST_NAME, PASSWORD);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        query = "Select customerDebtPayable from Customer where customerName= '" + name + "'";
        res = stmt.executeQuery(query);
        res.next();
        if (res == null) {
            JOptionPane.showMessageDialog(null, "No Customer Named " + name);

        } else {
            haveToPay = res.getFloat(1);
            float val = haveToPay - cost;
            if (val < 0) {
                JOptionPane.showMessageDialog(null, "Value Greater Than have to pay");

            } else {
                CustomersReports cr = new CustomersReports();
                Timestamp t = new Timestamp(System.currentTimeMillis());
                cr.writeDataIntoFile(name, t.toString(), String.valueOf(cost));

                res.next();

                query = "update Customer set  customerDebtPayable=" + (val) + "where customerName='" + name + "'";
                stmt.executeUpdate(query);

            }

        }
        stmt.close();
        conn.close();
    }
}
