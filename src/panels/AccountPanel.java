/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import Database.AccountData;
import Database.Connect;
import Database.DebtData;
import Database.Retrieve;
import Files.CustomersReports;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sedra.Colors;
import static sedra.SedraUI.height;
import static sedra.SedraUI.width;

/**
 *
 * @author mohammed
 */
public class AccountPanel extends javax.swing.JPanel {

    private float val;
    private String customerType;
    private Statement stmt2;

    /**
     * Creates new form AccountPanel
     */
    public AccountPanel() {

        initComponents();
        setBounds(0, 0, 3 * width / 4, height);
        homePanel.setBounds(0, 0, 3 * width / 4, 3 * height);
        jPanel2.setBounds(0, 0, 3 * width / 4, height / 4);
        customerAccountPane.setBounds(0, height / 4, 3 * width / 4, 3 * height / 4);
        allCustomerInvoices.setBounds(0, height / 4, (3 * width / 4) - 5, (3 * height / 4) - 250);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchItemfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        customerAccountPane = new javax.swing.JPanel();
        customerName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        customerPhone = new javax.swing.JLabel();
        haveToPay = new javax.swing.JLabel();
        customerAddress = new javax.swing.JLabel();
        customerMail = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        lastTransaction = new javax.swing.JLabel();
        customerPhone1 = new javax.swing.JLabel();
        customerPhone2 = new javax.swing.JLabel();
        customerPhone3 = new javax.swing.JLabel();
        customerPhone4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allCustomerInvoices = new javax.swing.JTable();
        everyItem = new javax.swing.JLabel();

        setLayout(null);

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(null);

        jPanel2.setBackground(Colors.HEAD_COLOR);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(Colors.TITLES_COLOR);
        jLabel4.setText("Customer Account");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel17.setForeground(Colors.TITLES_COLOR);
        jLabel17.setText("Search for ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-Search_28.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchItemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchItemfield)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homePanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        customerAccountPane.setBackground(Colors.PANELS_COLOR);

        customerName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        customerName.setForeground(Colors.LABELS_COLOR);
        customerName.setText(" ");

        customerPhone.setForeground(Colors.LABELS_COLOR);
        customerPhone.setText(" ");

        haveToPay.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        haveToPay.setForeground(Colors.LABELS_COLOR);
        haveToPay.setText(" ");

        customerAddress.setForeground(Colors.LABELS_COLOR);
        customerAddress.setText(" ");

        customerMail.setForeground(Colors.LABELS_COLOR);
        customerMail.setText(" ");

        label.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label.setForeground(Colors.LABELS_COLOR);
        label.setText("مرتجع");
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMousePressed(evt);
            }
        });

        lastTransaction.setBackground(new java.awt.Color(0, 51, 102));
        lastTransaction.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lastTransaction.setForeground(Colors.LABELS_COLOR);
        lastTransaction.setText("دفع");
        lastTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lastTransactionMousePressed(evt);
            }
        });

        customerPhone1.setForeground(Colors.LABELS_COLOR);
        customerPhone1.setText("Phone:");

        customerPhone2.setForeground(Colors.LABELS_COLOR);
        customerPhone2.setText("Address:");

        customerPhone3.setForeground(Colors.LABELS_COLOR);
        customerPhone3.setText("E-Mail:");

        customerPhone4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        customerPhone4.setForeground(Colors.LABELS_COLOR);
        customerPhone4.setText("Have to pay:");

        allCustomerInvoices.setBackground(new java.awt.Color(255, 255, 255));
        allCustomerInvoices.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        allCustomerInvoices.setForeground(Colors.LABELS_COLOR);
        allCustomerInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Invoice ID", "Name", "Size", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(allCustomerInvoices);

        everyItem.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        everyItem.setForeground(Colors.LABELS_COLOR);
        everyItem.setText("دفع تفصيلى");
        everyItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                everyItemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout customerAccountPaneLayout = new javax.swing.GroupLayout(customerAccountPane);
        customerAccountPane.setLayout(customerAccountPaneLayout);
        customerAccountPaneLayout.setHorizontalGroup(
            customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerAccountPaneLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                        .addComponent(everyItem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastTransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                        .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerAccountPaneLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                                        .addComponent(customerPhone1)
                                        .addGap(18, 18, 18)
                                        .addComponent(customerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                                        .addComponent(customerPhone3)
                                        .addGap(18, 18, 18)
                                        .addComponent(customerMail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                                        .addComponent(customerPhone2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(customerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(customerAccountPaneLayout.createSequentialGroup()
                                        .addComponent(customerPhone4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(haveToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customerAccountPaneLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        customerAccountPaneLayout.setVerticalGroup(
            customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerAccountPaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerName)
                        .addComponent(everyItem))
                    .addComponent(lastTransaction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerPhone)
                    .addComponent(customerPhone1)
                    .addComponent(customerPhone2)
                    .addComponent(customerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerPhone4)
                    .addComponent(haveToPay)
                    .addComponent(customerPhone3)
                    .addComponent(customerMail))
                .addContainerGap(327, Short.MAX_VALUE))
            .addGroup(customerAccountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerAccountPaneLayout.createSequentialGroup()
                    .addContainerGap(267, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );

        homePanel.add(customerAccountPane);
        customerAccountPane.setBounds(0, 0, 857, 581);

        add(homePanel);
        homePanel.setBounds(0, 0, 0, 0);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        try {
            // TODO add your handling code here:
            String name = searchItemfield.getText();
            HashMap hashMap = AccountData.getCustomerData(name);
            customerName.setText((String) hashMap.get("customerName"));
            customerMail.setText((String) hashMap.get("customerMail"));
            customerAddress.setText((String) hashMap.get("customerAddress"));
            customerPhone.setText((String) hashMap.get("customerPhone"));
            haveToPay.setText((String) hashMap.get("customerDebtPayable"));

            AccountData.getCustomerID(name);
            AccountData.showHistory();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Unable to get data " + ex.getMessage());
        }
        try {
            JFrame f = new NewJFrame(searchItemfield.getText());
            f.setSize(800, 800);
            f.setVisible(true);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabel1MousePressed

    private void lastTransactionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastTransactionMousePressed
        try {
            // TODO add your handling code here:
            String name = JOptionPane.showInputDialog("Insert Name");

            float val = Float.parseFloat(JOptionPane.showInputDialog("Insert Value "));
            DebtData.execute(name, val);
            CustomersReports cr = new CustomersReports();
            Timestamp t = new Timestamp(System.currentTimeMillis());
            cr.writeDataIntoFile(name, t.toString(), String.valueOf(val));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Check name or value");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_lastTransactionMousePressed


    private void labelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMousePressed
        // TODO add your handling code here:
        Retrieve r = new Retrieve();
        r.increaseStore(searchItemfield.getText());

    }//GEN-LAST:event_labelMousePressed

    private void everyItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_everyItemMousePressed
        // TODO add your handling code here:
        String recID;
        int customerID;
        String customerNameString = null;
        String line = null;
        recID = JOptionPane.showInputDialog(this, "Enter recID");
        if (recID.trim().length() > 0) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet resultSet;

            try {
                conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                resultSet = stmt.executeQuery("SELECT customerID FROM Sales WHERE recID='" + recID + "'");
                resultSet.next();
                customerID = resultSet.getInt(1);
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                resultSet = stmt.executeQuery("SELECT customerName FROM Customer WHERE customerID=" + customerID + "");
                resultSet.next();
                customerNameString = resultSet.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            File f = new File("payment/" + customerNameString + ".txt");
            if (f.exists()) {
                Scanner s = null;
                try {
                    s = new Scanner(f);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (s.hasNext()) {
                    line = s.nextLine();
                    if (line.contains(recID)) {
                        break;
                    }

                }
                System.err.println(customerNameString);
                try {
                    String query = "SELECT costomerType FROM Customer WHERE customerName='" + customerNameString + "'";
                    resultSet = stmt2.executeQuery(query);
                    resultSet.next();
                    customerType = resultSet.getString(1);
                } catch (SQLException sQLException) {
                    sQLException.printStackTrace();
                } finally {
                    try {
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken();

                val = Float.parseFloat(st.nextToken());
                NewJFrame2 frame2 = null;
                System.out.println(customerType);

                try {
                    frame2 = new NewJFrame2(customerNameString, val, recID, customerType);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.setVisible(true);

            }

        }

    }//GEN-LAST:event_everyItemMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable allCustomerInvoices;
    private javax.swing.JPanel customerAccountPane;
    private javax.swing.JLabel customerAddress;
    private javax.swing.JLabel customerMail;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerPhone;
    private javax.swing.JLabel customerPhone1;
    private javax.swing.JLabel customerPhone2;
    private javax.swing.JLabel customerPhone3;
    private javax.swing.JLabel customerPhone4;
    private javax.swing.JLabel everyItem;
    private javax.swing.JLabel haveToPay;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lastTransaction;
    private javax.swing.JTextField searchItemfield;
    // End of variables declaration//GEN-END:variables
}
