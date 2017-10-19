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
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class Connect {

    static String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
    //public static final String URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11192233" + unicode;
    public static final String URL = "jdbc:mysql://localhost/sedra" + unicode;
    //public static final String HOST_NAME = "sql11192233";
    public static final String HOST_NAME = "root";
    //public static final String PASSWORD = "61NUHhELp6";
    public static final String PASSWORD = "ahmedragab";
    static Connection conn;
    static Statement stmt;

    public static Statement startConnection() {
        try {
            conn = DriverManager.getConnection(URL, HOST_NAME, PASSWORD);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't connect", JOptionPane.ERROR_MESSAGE);
        }
        return stmt;

    }

    public static void endConnection(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't close", JOptionPane.ERROR_MESSAGE);
        }

    }

}
