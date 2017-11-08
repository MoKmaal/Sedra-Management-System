/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import Database.Connect;
import Database.HomeData;
import Database.Login;
import Database.StoreData;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import sedra.Colors;
import sedra.SedraUI;
import static sedra.SedraUI.height;
import static sedra.SedraUI.width;
import static panels.ReceiptPanel.invoicetable;
import static panels.ReceiptPanel.resultsTable;

/**
 *
 * @author mohammed
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    JComboBox<String> jcb;
    JCheckBox checkBox;
    DefaultTableModel model;
    public static DefaultTableModel dtm;
    public static ArrayList number;
    float pay = 0;
    Object[] vec;
    float getremain, getpaid;
    private String selectedType;

    public void updatePanel() {

    }

    public HomePanel() throws SQLException {
        initComponents();
        setBounds(0, 0, 3 * width / 4, height);
        setSize(new Dimension(3 * width / 4, height));
        homePanel.setBounds(0, 0, 3 * width / 4, height);
        homePanel.setSize(new Dimension(3 * width / 4, height));
        jPanel2.setBounds(0, 0, 3 * width / 4, height / 4);
        jPanel2.setSize(new Dimension(3 * width / 4, height / 4));
        dataPane.setBounds(0, height / 4, 3 * width / 4, height / 4);
        jScrollPane1.setBounds(0, height / 2, 3 * width / 4, (height / 2) - 30);

        StoreData.getStoreData();
        addSelectionBoxesToTable();
        addToTable();
        jTable1.setRowHeight(30);
        DocumentHandler nc = new DocumentHandler();
        customerPaidField.getDocument().addDocumentListener(nc);
        submit.setEnabled(false);
        customerNameIDCombo.setEnabled(false);
        customerPaidField.setEnabled(false);
        customerRemain.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        homePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchItemfield = new javax.swing.JTextField();
        warning = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dataPane = new javax.swing.JPanel();
        customerTypeCombo = new javax.swing.JComboBox<>();
        customerNameIDCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customerPaidField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        customerRemain = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        customerDiscount = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        homePanel.setBackground(Colors.PANELS_COLOR);
        homePanel.setPreferredSize(new Dimension(SedraUI.width*2/3,SedraUI.height));
        homePanel.setLayout(null);

        jPanel2.setBackground(Colors.HEAD_COLOR);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(Colors.TITLES_COLOR);
        jLabel4.setText("Home");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel17.setForeground(Colors.TITLES_COLOR);
        jLabel17.setText("Search for ");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });

        warning.setBackground(Color.RED);
        warning.setForeground(new java.awt.Color(64, 43, 100));
        warning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        warning.setBorder(null);
        warning.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        warning.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("warning");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(288, 288, 288)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(warning, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchItemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(searchItemfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        homePanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 768, 150);

        jScrollPane1.setBorder(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Choose", "Quantity", "Code", "Size", "Quantity", "Doc price", "Customer Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(85, 65, 118));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        homePanel.add(jScrollPane1);
        jScrollPane1.setBounds(4, 368, 760, 200);

        dataPane.setBackground(Colors.PANELS_COLOR);

        customerTypeCombo.setBackground(Colors.FIELDS_COLOR);
        customerTypeCombo.setForeground(new java.awt.Color(64, 43, 100));
        customerTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Doctor", "Customer" }));
        customerTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerTypeComboActionPerformed(evt);
            }
        });

        customerNameIDCombo.setBackground(Colors.FIELDS_COLOR);
        customerNameIDCombo.setForeground(new java.awt.Color(64, 43, 100));
        customerNameIDCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerNameIDCombo.setBorder(null);
        customerNameIDCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        customerNameIDCombo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(Colors.LABELS_COLOR);
        jLabel1.setText("Customer Type");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(Colors.LABELS_COLOR);
        jLabel2.setText("Customer Name/ID");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(Colors.LABELS_COLOR);
        jLabel5.setText("Paid");

        customerPaidField.setForeground(new java.awt.Color(64, 43, 100));
        customerPaidField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerPaidFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(Colors.LABELS_COLOR);
        jLabel6.setText("Remain");

        customerRemain.setForeground(new java.awt.Color(64, 43, 100));

        submit.setBackground(Colors.SIDE_COLOR);
        submit.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        submit.setForeground(Colors.PANELS_COLOR);
        submit.setText("Create Order");
        submit.setBorder(null);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        customerDiscount.setBackground(Colors.FIELDS_COLOR);
        customerDiscount.setForeground(new java.awt.Color(64, 43, 100));
        customerDiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "1%", "2%", "3%", "4%", "5%", "6%", "7%", "8%", "9%", "10%", "11%", "12%", "13%", "14%", "15%", "16%", "17%", "18%", "19%", "20%", "21%", "22%", "23%", "24%", "25%", "26%", "27%", "28%", "29%", "30%" }));
        customerDiscount.setBorder(null);
        customerDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        customerDiscount.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(Colors.LABELS_COLOR);
        jLabel7.setText("Discount");

        javax.swing.GroupLayout dataPaneLayout = new javax.swing.GroupLayout(dataPane);
        dataPane.setLayout(dataPaneLayout);
        dataPaneLayout.setHorizontalGroup(
            dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPaneLayout.createSequentialGroup()
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(customerTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(dataPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(dataPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(customerPaidField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(customerRemain, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(customerNameIDCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPaneLayout.setVerticalGroup(
            dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerTypeCombo)
                    .addComponent(customerDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(customerNameIDCombo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerRemain, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerPaidField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        homePanel.add(dataPane);
        dataPane.setBounds(0, 170, 756, 190);

        add(homePanel);
        homePanel.setBounds(0, 6, 832, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void customerTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerTypeComboActionPerformed
        // TODO add your handling code here:
        String x = customerTypeCombo.getSelectedItem().toString();
        customerNameIDCombo.removeAll();

        if (x.equalsIgnoreCase("Customer")) {
            try {
                customerNameIDCombo.setModel(new DefaultComboBoxModel(HomeData.getCustorsList().toArray()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Unable to retrieve data " + ex.getMessage());
            }

        } else {
            try {
                customerNameIDCombo.setModel(new DefaultComboBoxModel(HomeData.getDoctorsList().toArray()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Unable to retrieve data " + ex.getMessage());
            }

        }
        submit.setEnabled(true);
        customerNameIDCombo.setEnabled(true);
        customerPaidField.setEnabled(true);


    }//GEN-LAST:event_customerTypeComboActionPerformed

    public void updateStore() {

    }


    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        int sure = JOptionPane.showConfirmDialog(this, "من فضلك تاكد من ادخال رقم 0 فى خانة ال payment بعد التاكد من اختيار جميع الاكواد ، ان كنت متاكد اضغط Yes");

        if (HomePanel.dtm != null) {

            HomePanel.dtm.setRowCount(0);
            resultsTable.setValueAt("", 0, 0);
            resultsTable.setValueAt("", 0, 1);
            resultsTable.setValueAt("", 1, 0);
            resultsTable.setValueAt("", 1, 1);
            resultsTable.setValueAt("", 2, 0);
            resultsTable.setValueAt("", 2, 1);
        }
        if (sure == JOptionPane.YES_OPTION) {
            if (!customerTypeCombo.getSelectedItem().equals("") && customerPaidField.getText().length() != 0) {
                try {

                    Random r = new Random();
                    int x = r.nextInt(999999999);
                    // TODO add your handling code here:
                    selectedType = customerTypeCombo.getSelectedItem().toString();
                    getpaid = Float.parseFloat(customerPaidField.getText());
                    getremain = Float.parseFloat(customerRemain.getText());
                    getSelectedItemsFromTable(x);
                    reset();

                    printInvoiceData(x, (String) customerNameIDCombo.getSelectedItem());

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Unable to create order " + ex.getMessage());
                }
                submit.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please Re enter data ");

            }
            if (getremain == 0) {
                AccountPanel.daf3Agel(customerNameIDCombo.getSelectedItem().toString(), getpaid);

            } else if (getpaid == 0) {

            } else if (getpaid != 0 && getremain != 0) {
                AccountPanel.daf3Agel(customerNameIDCombo.getSelectedItem().toString(), getpaid);
            }
        }

    }//GEN-LAST:event_submitActionPerformed
    private void printInvoiceData(int recID, String name) {
        try {
            Connection conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res;
            String query = "SELECT costomerType FROM Customer WHERE customerName='" + name + "'";
            res = stmt.executeQuery(query);
            res.next();

            String type = res.getString(1);
            String printInvoiceQuery = null;
            if (type.equalsIgnoreCase("Doctor")) {
                printInvoiceQuery = "SELECT Sales.itemID,Sales.salesQuantity"
                        + ",(Store.itemDocPrice*Sales.salesQuantity)AS price"
                        + ",Sales.employeeID,Sales.orderTime,Sales.Size,Store.itemDocPrice FROM `Sales`,Store"
                        + " WHERE Store.itemID=Sales.itemID AND Store.itemSize=Sales.Size AND recID=" + recID
                        + " AND Sales.customerID IN (Select customerID from"
                        + " Customer where costomerType = 'Doctor')";

            } else if (type.equalsIgnoreCase("Customer")) {
                printInvoiceQuery = "SELECT Sales.itemID,Sales.salesQuantity"
                        + ",(Store.itemCustomerPrice*Sales.salesQuantity)AS price"
                        + ",Sales.employeeID,Sales.orderTime,Sales.Size,Store.itemCustomerPrice FROM `Sales`,Store "
                        + "WHERE Store.itemID=Sales.itemID AND Store.itemSize=Sales.Size AND recID=" + recID
                        + " AND Sales.customerID IN (Select customerID from "
                        + "Customer where costomerType = 'Customer')";

            }

            int totalPrice = 0;
            int invoiceIndex = 0;
            conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery(printInvoiceQuery);

            rs.beforeFirst();
            while (rs.next()) {
                invoiceIndex++;
                totalPrice += Float.parseFloat(rs.getString(3));
                String s0 = rs.getString(1);
                String s1 = rs.getString(2);
                String s3 = rs.getString(3);
                String s6 = rs.getString(6);
                String s22 = rs.getString(7);
                Object data[] = {"", "", "", s0, s6, s1, s22, s3};

                dtm = (DefaultTableModel) invoicetable.getModel();

                dtm.addRow(data);

            }
            rs.first();

            invoicetable.setValueAt(rs.getString(5), 0, 0);
            invoicetable.setValueAt(rs.getString(4), 0, 1);
            invoicetable.setValueAt(recID, 0, 2);
            ReceiptPanel.resultsTable.setValueAt("Total", 0, 0);

            ReceiptPanel.resultsTable.setValueAt(totalPrice, 0, 1);
            if (customerDiscount.getSelectedIndex() != 0) {

                ReceiptPanel.resultsTable.setValueAt("Discount", 1, 0);
                String s = customerDiscount.getSelectedItem().toString();
                ReceiptPanel.resultsTable.setValueAt(s, 1, 1);
                int afterdisc = Integer.parseInt(s.replace("%", ""));
                float lastTotal = totalPrice - (totalPrice * afterdisc * 1.0f / 100f);
                ReceiptPanel.resultsTable.setValueAt("Price ", 2, 0);
                ReceiptPanel.resultsTable.setValueAt(lastTotal, 2, 1);

            }
            SedraUI.visibility(false, true, false, false, false, false, false, false, false);
            ReceiptPanel.setCustomerName(name);
            JOptionPane.showMessageDialog(this, "DONE");
            customerDiscount.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Unable to print invoice " + ex.getMessage());
        }

    }
    private void customerPaidFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerPaidFieldActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_customerPaidFieldActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel17MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox<String> customerDiscount;
    public static javax.swing.JComboBox<String> customerNameIDCombo;
    private javax.swing.JTextField customerPaidField;
    private javax.swing.JTextField customerRemain;
    private javax.swing.JComboBox<String> customerTypeCombo;
    private javax.swing.JPanel dataPane;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchItemfield;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox<String> warning;
    // End of variables declaration//GEN-END:variables

    private void addToTable() {
        warning.removeAllItems();
        boolean x = false;
        String rwmp = "";
        if (StoreData.listID.size() != 0) {
            rwmp = StoreData.listID.get(0);
        }
        for (int i = 0; i < StoreData.listCustomerPrice.size(); i++) {
            if (x == true) {
                if (rwmp.equalsIgnoreCase(StoreData.listID.get(i))) {
                    Object[] row = {"", "",
                        StoreData.listID.get(i),
                        StoreData.listSize.get(i),
                        StoreData.listQuantity.get(i),
                        StoreData.listDocPrice.get(i),
                        StoreData.listCustomerPrice.get(i)
                    };
                    vec = row.clone();
                } else {
                    rwmp = StoreData.listID.get(i);
                    Object[] row = {"", "",
                        "",
                        "",
                        "",
                        "",
                        ""
                    };
                    vec = row.clone();
                    i--;
                }
            }
            if (x == false) {
                Object[] row = {"", "",
                    StoreData.listID.get(i),
                    StoreData.listSize.get(i),
                    StoreData.listQuantity.get(i),
                    StoreData.listDocPrice.get(i),
                    StoreData.listCustomerPrice.get(i)
                };
                vec = row.clone();
                x = true;

            }
            model = (DefaultTableModel) jTable1.getModel();
            model.addRow(vec);
            if (Integer.parseInt(StoreData.listQuantity.get(i)) < 10) {
                warning.addItem(StoreData.listID.get(i));
            }
        }
        /*
        if (x == false) {

            for (int i = 0; i < StoreData.listCustomerPrice.size(); i++) {
                Object[] row = {"", "",
                    StoreData.listID.get(i),
                    StoreData.listSize.get(i),
                    StoreData.listQuantity.get(i),
                    StoreData.listDocPrice.get(i),
                    StoreData.listCustomerPrice.get(i)
                };
                model = (DefaultTableModel) jTable1.getModel();
                model.addRow(row);
                if (Integer.parseInt(StoreData.listQuantity.get(i)) < 10) {
                    warning.addItem(StoreData.listID.get(i));
                }
            }
        }
         */

    }

    private void addSelectionBoxesToTable() {
        number = new ArrayList();
        for (int i = 1; i < 1000; i++) {
            number.add(i);
        }
        jcb = new JComboBox(number.toArray());
        checkBox = new JCheckBox();
        jTable1.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jcb));
        jTable1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(checkBox));

    }

    private void getSelectedItemsFromTable(int recID) throws SQLException {
        Connection conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("Select customerID FROM Customer WHERE customerName='"
                + customerNameIDCombo.getSelectedItem().toString() + "'");
        rs.next();
        int id = rs.getInt("customerID");
        boolean x = false;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((jTable1.getValueAt(i, 0)) != null
                    && jTable1.getValueAt(i, 0).toString().equals("true")
                    && jTable1.getValueAt(i, 1) != null) {
                if (Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))
                        > Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 4)))) {
                    JOptionPane.showMessageDialog(this, "Enter Valid Quantity");
                    x = true;
                    break;
                }
            }
        }
        if (x == false) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                if ((jTable1.getValueAt(i, 0)) != null
                        && jTable1.getValueAt(i, 0).toString().equals("true")
                        && jTable1.getValueAt(i, 1) != null) {
                    try {

                        String insertIntoSalesTableQuery;
                        try {
                            if (getremain == 0) {
                                if (selectedType.equalsIgnoreCase("Customer")) {
                                    insertIntoSalesTableQuery = "Insert into Sales (recID,customerID,employeeID,itemID,Size,salesQuantity,salesPaid,paymentType) Values ("
                                            + recID + "," + id + "," + Login.empID
                                            + ",'" + jTable1.getValueAt(i, 2).toString() + "','" + jTable1.getValueAt(i, 3).toString() + "',"
                                            + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))
                                            + "," + (Integer.parseInt((String) jTable1.getValueAt(i, 6))
                                            * Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))) + ",'" + customerDiscount.getSelectedItem().toString() + "')";
                                } else {
                                    insertIntoSalesTableQuery = "Insert into Sales (recID,customerID,employeeID,itemID,Size,salesQuantity,salesPaid,paymentType) Values ("
                                            + recID + "," + id + "," + Login.empID
                                            + ",'" + jTable1.getValueAt(i, 2).toString() + "','" + jTable1.getValueAt(i, 3).toString() + "',"
                                            + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))
                                            + "," + (Integer.parseInt((String) jTable1.getValueAt(i, 5))
                                            * Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))) + ",'" + customerDiscount.getSelectedItem().toString() + "')";

                                }
                            } else if (getpaid == 0) {
                                insertIntoSalesTableQuery = "Insert into Sales (recID,customerID,employeeID,itemID,Size,salesQuantity,salesPaid,paymentType) Values ("
                                        + recID + "," + id + "," + Login.empID
                                        + ",'" + jTable1.getValueAt(i, 2).toString() + "','" + jTable1.getValueAt(i, 3).toString() + "',"
                                        + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))
                                        + "," + Integer.parseInt("0") + ",'" + customerDiscount.getSelectedItem().toString() + "')";

                            } else {
                                insertIntoSalesTableQuery = "Insert into Sales (recID,customerID,employeeID,itemID,Size,salesQuantity,salesPaid,paymentType) Values ("
                                        + recID + "," + id + "," + Login.empID
                                        + ",'" + jTable1.getValueAt(i, 2).toString() + "','" + jTable1.getValueAt(i, 3).toString() + "',"
                                        + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)))
                                        + "," + Integer.parseInt("0") + ",'" + customerDiscount.getSelectedItem().toString() + "')";
                            }
                        } catch (NumberFormatException ex) {
                            continue;
                        }

                        conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        stmt.executeUpdate(insertIntoSalesTableQuery);

                        ResultSet res = stmt.executeQuery("Select customerDebtPayable from Customer where customerID= " + id);
                        pay = 0;
                        res.next();
                        pay = res.getFloat("customerDebtPayable");
                        int current = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 4)));
                        int buy = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1)));
                        int afterdisc = Integer.parseInt(customerDiscount.getSelectedItem().toString().replace("%", ""));
                        float lastTotal = Float.parseFloat(customerRemain.getText()) - (Float.parseFloat(customerRemain.getText()) * afterdisc / 100);

                        pay += lastTotal;

                        stmt.executeUpdate("Update Store set itemQuantity=" + (current - buy) + " where itemSize='" + jTable1.getValueAt(i, 3) + "'"
                                + "AND itemID='" + jTable1.getValueAt(i, 2) + "'");

                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                    }

                }

            }
            stmt.executeUpdate(" UPDATE Customer\n"
                    + "SET customerDebtPayable =" + pay
                    + "WHERE customerID =" + id);

        }
        stmt.close();
        conn.close();

    }

    public void reset() {
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            StoreData.getStoreData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Unable to update data " + ex.getMessage());
        }
        addToTable();
        addSelectionBoxesToTable();
    }

    class DocumentHandler implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent de) {
            update();

        }

        @Override
        public void removeUpdate(DocumentEvent de) {

            update();
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            update();
        }

    }

    public void update() {
        if (customerPaidField.getText().length() == 0) {

            customerRemain.setText(String.valueOf(value()));

        } else {
            value();

            customerRemain.setText(String.valueOf(value() - Float.parseFloat(customerPaidField.getText())));

        }
    }

    public float value() {
        float amount = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            if ((jTable1.getValueAt(i, 0)) != null
                    && jTable1.getValueAt(i, 0).toString().equals("true")
                    && jTable1.getValueAt(i, 1) != null) {
                if (customerTypeCombo.getSelectedItem().equals("Doctor")) {
                    amount += (Float.parseFloat(jTable1.getValueAt(i, 1).toString())
                            * Float.parseFloat(jTable1.getValueAt(i, 5).toString()));

                } else {
                    amount += (Float.parseFloat(jTable1.getValueAt(i, 1).toString())
                            * Float.parseFloat(jTable1.getValueAt(i, 6).toString()));

                }
            }
        }
        return amount;
    }
}
