/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static panels.AccountPanel.allCustomerInvoices;
import static panels.ReceiptPanel.invoicetable;

/**
 *
 * @author mohammed
 */
public class AccountData {

    static String customerName;
    public static HashMap accountMap = new HashMap();
    static String Query = "SELECT * FROM Customer WHERE customerName ='";
    static ResultSet res;
    static Connection conn;
    static Statement stmt;
    static DefaultTableModel dtm;
    private static int totalItems=0;

    public static HashMap getCustomerData(String name) throws SQLException {
        try {
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Couldn't connect", JOptionPane.ERROR_MESSAGE);
        }
        res = stmt.executeQuery(Query + name + "'");
        if (!res.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Data", "No customers with name"
                    + name, JOptionPane.ERROR_MESSAGE);

        } else {
            res.next();
            System.out.println(name);
            accountMap.put("customerName", res.getString("customerName"));
            accountMap.put("customerMail", res.getString("customerMail"));
            accountMap.put("customerAddress", res.getString("customerAddress"));
            accountMap.put("customerDebtPayable", res.getString("customerDebtPayable"));
            accountMap.put("customerPhone", res.getString("customerPhone"));
            accountMap.put("discount", res.getDouble("discount"));
        }
        return accountMap;
    }

    public static void setCustomerName(String customerName) {
        AccountData.customerName = customerName;
    }

    public static int getCustomerID(String customerName) throws SQLException {
        setCustomerName(customerName);
        String query = "SELECT customerID FROM Customer WHERE customerName='" + customerName + "'";
        res = stmt.executeQuery(query);
        res.next();
        int id = res.getInt(1);
        return id;

    }

    public static String getCustomerType(String customerName) throws SQLException {
        String query = "SELECT costomerType FROM Customer WHERE customerName='" + customerName + "'";
        res = stmt.executeQuery(query);
        res.next();
        String str = res.getString(1);

        return str;
    }

    public static void showHistory() throws SQLException {
        conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = null;
        float totalPrice = 0;
        int invoiceIndex = 0;

        String printInvoiceQuery;
        if (getCustomerType(customerName).equalsIgnoreCase("Doctor")) {
            printInvoiceQuery = "SELECT Sales.itemID,Sales.salesQuantity,"
                    + "(Store.itemDocPrice*Sales.salesQuantity)AS price,Sales.employeeID,"
                    + "Sales.orderTime,Sales.recID,Sales.Size,Sales.salesPaid FROM `Sales`,Store WHERE Store.itemID=Sales.itemID AND"
                    + " Store.itemSize = Sales.Size "
                    + " AND customerID=" + getCustomerID(customerName);

            rs = stmt.executeQuery(printInvoiceQuery);

        } else {
            printInvoiceQuery = "SELECT Sales.itemID,Sales.salesQuantity,"
                    + "(Store.itemCustomerPrice*Sales.salesQuantity)AS price,Sales.employeeID,"
                    + "Sales.orderTime,Sales.recID,Sales.Size,Sales.salesPaid FROM `Sales`,Store WHERE Store.itemID=Sales.itemID AND"
                    + " Store.itemSize = Sales.Size "
                    + " AND customerID=" + getCustomerID(customerName);
            rs = stmt.executeQuery(printInvoiceQuery);

        }

        rs.beforeFirst();
        String tempTime = "";
        boolean var = false;
        int tempID = 0;
        String s5 = "";
                    dtm = (DefaultTableModel) allCustomerInvoices.getModel();
                        dtm.setRowCount(0);

        while (rs.next()) {
            System.out.println(rs.getString(5).substring(0, 16));
            if (var == false) {
                tempTime = rs.getString(5).substring(0, 16);
                tempID = rs.getInt(6);
            }

            invoiceIndex++;
            totalPrice += Float.parseFloat(rs.getString(3));
            String s0 = rs.getString(1);
            String s1 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s7 = rs.getString(7);
            String s8 = rs.getString(8);

            if (!tempTime.equalsIgnoreCase(rs.getString(5).substring(0, 16))) {
                s4 = rs.getString(5).substring(0, 16);
                s5 = String.valueOf(rs.getInt(6));

            } else {
                s4 = "";
                s5 = "";
            }
            if (var == false) {
                System.out.println("var false");
                s4 = tempTime;
                s5 = String.valueOf(tempID);
                var = true;
            }
            totalItems+=Integer.parseInt(s1);
            Object data[] = {s4, s5, s0, s7, s1, s3,s8,""};
            if (!tempTime.equalsIgnoreCase(rs.getString(5).substring(0, 16))) {
                Object data1[] = {"", "", "", "", "", "",""};
                invoiceIndex++;
                dtm.addRow(data1);

                tempTime = s4;

            }

            dtm.addRow(data);

        }
        
        

        rs.first();
                Object data1[] = {"", "", "", "", "", "",""};

                    dtm.addRow(data1);
                    invoiceIndex++;
        allCustomerInvoices.setValueAt(totalPrice, --invoiceIndex, 7);
        allCustomerInvoices.setValueAt(totalItems, invoiceIndex, 4);
        totalItems=0;
    }

}
