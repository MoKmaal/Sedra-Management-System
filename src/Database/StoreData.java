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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author mohammed
 */
public class StoreData {

    public static List<String> listID = new ArrayList<>();
    public static List<String> listQuantity = new ArrayList<>();
    public static List<String> listDocPrice = new ArrayList<>();
    public static List<String> listCustomerPrice = new ArrayList<>();
    public static List<String> listSize = new ArrayList<>();
    static String Query = "SELECT * FROM Store";
    static ResultSet res;
    static Connection conn;
    static Statement stmt;
    static String sizesStatic[] = {"xs", "s", "m", "l", "xl", "xxl", "xxxl", "xxxxl", "xxxxxl",
        "xxxxxxl"};

    public static void getStoreData() throws SQLException {
        listID.clear();
        try {
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't connect", JOptionPane.ERROR_MESSAGE);
        }
        res = stmt.executeQuery(Query);
        res.beforeFirst();
        while (res.next()) {

            listID.add(res.getString("itemID"));

        }
        Collections.sort(listID, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        Set noDups = new HashSet();
        noDups.addAll(listID);
        List newList = new ArrayList(noDups);

        Collections.sort(newList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        listSize.clear();
        listQuantity.clear();
        listDocPrice.clear();
        listCustomerPrice.clear();
        for (int i = 0; i < newList.size(); i++) {
            for (String sizesStatic1 : sizesStatic) {
                res = stmt.executeQuery(Query + " WHERE itemID='" + newList.get(i) + "' AND itemSize='" + sizesStatic1 + "'");
                if (res.next()) {
                    listQuantity.add(res.getString("itemQuantity"));
                    listDocPrice.add(res.getString("itemDocPrice"));
                    listCustomerPrice.add(res.getString("itemCustomerPrice"));
                    listSize.add(sizesStatic1);
                }
            }
        }

        stmt.close();
        conn.close();

    }

}
