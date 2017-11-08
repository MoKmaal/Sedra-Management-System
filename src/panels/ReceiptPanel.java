/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import Database.Connect;
import Print.Printer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import sedra.Colors;
import static sedra.SedraUI.height;
import static sedra.SedraUI.width;

/**
 *
 * @author mohammed
 */
public class ReceiptPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountPanel
     *
     * @param customerNamef
     */
    public static void setCustomerName(String customerName) throws SQLException {
        nameRec.setHorizontalAlignment(SwingConstants.RIGHT);
        nameRec.setText(customerName);
        PhoneRec.setHorizontalAlignment(SwingConstants.RIGHT);
        AddrRec.setHorizontalAlignment(SwingConstants.RIGHT);
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        Connection c = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
        Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet res = stmt.executeQuery("SELECT customerMail,customerAddress,customerPhone"
                + " FROM Customer WHERE customerName='" + customerName + "'");
        resultsTable.setRowHeight(35);
        if (res.next()) {
            PhoneRec.setText(res.getString(3));
            AddrRec.setText(res.getString(2));
            email.setText(res.getString(1));

        } else {
            PhoneRec.setText("");
            dots.setText("");
            email.setText("");

        }
    }

    public ReceiptPanel() {
        initComponents();
        setBounds(0, 0, 3 * width / 4, height);
        setSize(new Dimension(3 * width / 4, height));
        homePanel.setBounds(0, 0, 3 * width / 4, height);
        jPanel2.setBounds(0, 0, 3 * width / 4, height / 4);
        recPanel.setBounds(0, height / 4, 3 * width / 4, 3 * height / 4);
        jScrollPane3.setBounds(0, height / 4, (3 * width / 4) - 5, (3 * height / 4) - 470);
        invoicetable.setBounds((15 * width / 32) - 5, 500, (3 * width / 4) - 5, 700);
        jScrollPane4.setBounds((3 * width / 4) * 6 / 8, (height / 4) + ((3 * height / 4) - 470)-5, (3 * width / 4) * 2 / 8, 115);
        resultsTable.setBounds((3 * width / 4) * 6 / 8, (height / 4) + ((3 * height / 4) - 470)-5, (3 * width / 4) * 2 / 8, 115);

        slogan.setBounds(0, 700, (3 * width / 4) - 5, 20);
        dots.setBounds(50, 730, (3 * width / 4) - 5, 20);
        slogan.setHorizontalAlignment(SwingConstants.RIGHT);
        resultsTable.setRowHeight(35);
        invoicetable.getTableHeader().setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        invoicetable.setFillsViewportHeight(true);

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
        textRecID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        recPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoicetable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        site = new javax.swing.JLabel();
        customerInvoiceName1 = new javax.swing.JLabel();
        customerInvoiceName2 = new javax.swing.JLabel();
        customerInvoiceName3 = new javax.swing.JLabel();
        customerInvoiceName4 = new javax.swing.JLabel();
        nameRec = new javax.swing.JLabel();
        dots = new javax.swing.JLabel();
        PhoneRec = new javax.swing.JLabel();
        slogan = new javax.swing.JLabel();
        AddrRec = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();

        setLayout(null);

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(null);

        jPanel2.setBackground(Colors.HEAD_COLOR);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(Colors.TITLES_COLOR);
        jLabel4.setText("Receipt");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel17.setForeground(Colors.TITLES_COLOR);
        jLabel17.setText("Search for ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-Search_28.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                        .addComponent(textRecID, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textRecID)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        homePanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 760, 150);

        recPanel.setBackground(Colors.PANELS_COLOR);
        recPanel.setLayout(null);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(453, 350));

        invoicetable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        invoicetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "ID", "Invoice ID", "Name", "Size", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(invoicetable);
        if (invoicetable.getColumnModel().getColumnCount() > 0) {
            invoicetable.getColumnModel().getColumn(0).setHeaderValue("Date");
            invoicetable.getColumnModel().getColumn(1).setHeaderValue("ID");
            invoicetable.getColumnModel().getColumn(2).setResizable(false);
            invoicetable.getColumnModel().getColumn(2).setHeaderValue("Invoice ID");
            invoicetable.getColumnModel().getColumn(3).setResizable(false);
            invoicetable.getColumnModel().getColumn(3).setHeaderValue("Name");
            invoicetable.getColumnModel().getColumn(4).setResizable(false);
            invoicetable.getColumnModel().getColumn(4).setHeaderValue("Size");
        }

        recPanel.add(jScrollPane3);
        jScrollPane3.setBounds(0, 420, 1038, 180);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1logo.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        recPanel.add(jLabel2);
        jLabel2.setBounds(0, 0, 320, 120);

        address.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        address.setText("6A Aswan Square");
        recPanel.add(address);
        address.setBounds(0, 150, 380, 22);

        email.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        email.setText("Password");
        recPanel.add(email);
        email.setBounds(1090, 140, 220, 22);

        site.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        site.setText("www.sedrashapely.com");
        recPanel.add(site);
        site.setBounds(0, 120, 320, 22);

        customerInvoiceName1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        customerInvoiceName1.setText("0101-665-5777");
        recPanel.add(customerInvoiceName1);
        customerInvoiceName1.setBounds(170, 210, 160, 22);

        customerInvoiceName2.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        customerInvoiceName2.setText("0233478061");
        recPanel.add(customerInvoiceName2);
        customerInvoiceName2.setBounds(0, 180, 170, 22);

        customerInvoiceName3.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        customerInvoiceName3.setText("0127-857-0604");
        recPanel.add(customerInvoiceName3);
        customerInvoiceName3.setBounds(170, 180, 290, 22);

        customerInvoiceName4.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        customerInvoiceName4.setText("0111-410-5152");
        recPanel.add(customerInvoiceName4);
        customerInvoiceName4.setBounds(0, 210, 160, 22);

        nameRec.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nameRec.setText("Username");
        recPanel.add(nameRec);
        nameRec.setBounds(1090, 110, 220, 22);

        dots.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        dots.setText(".....................");
        recPanel.add(dots);
        dots.setBounds(10, 650, 450, 22);

        PhoneRec.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        PhoneRec.setText("jLabel3");
        recPanel.add(PhoneRec);
        PhoneRec.setBounds(1090, 170, 220, 22);

        slogan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        slogan.setText("تم استلام البضاعة على سبيل الامانة ، واتعهد بالحفاظ عليها لحين سداد قيمتها                                                                                                                         توقيع");
        slogan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        recPanel.add(slogan);
        slogan.setBounds(0, 580, 1310, 30);

        AddrRec.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AddrRec.setText("jLabel3");
        recPanel.add(AddrRec);
        AddrRec.setBounds(860, 200, 450, 22);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(453, 350));

        resultsTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Price", "Total"
            }
        ));
        resultsTable.setTableHeader(null);
        jScrollPane4.setViewportView(resultsTable);

        recPanel.add(jScrollPane4);
        jScrollPane4.setBounds(0, 356, 1038, 180);

        homePanel.add(recPanel);
        recPanel.setBounds(0, 150, 760, 0);

        add(homePanel);
        homePanel.setBounds(0, 0, 760, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        getInvoiceMaker();

    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            PrinterJob pjob = PrinterJob.getPrinterJob();
            PageFormat preformat = pjob.defaultPage();
            preformat.setOrientation(PageFormat.PORTRAIT);
            PageFormat postformat = pjob.pageDialog(preformat);
            //If user does not hit cancel then print.
            if (preformat != postformat) {
                //Set print component
                pjob.setPrintable(new Printer(recPanel), postformat);
                if (pjob.printDialog()) {
                    pjob.print();
                }
            }
            HomePanel.dtm.setRowCount(0);
            resultsTable.setValueAt("", 0, 0);
            resultsTable.setValueAt("", 0, 1);
            resultsTable.setValueAt("", 1, 0);
            resultsTable.setValueAt("", 1, 1);
            resultsTable.setValueAt("", 2, 0);
            resultsTable.setValueAt("", 2, 1);
            
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Unable to print " + ex.getMessage());
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void getInvoiceMaker() {
        try {
            String invoiceMakerQuery = "SELECT Employee.employeeName FROM `Employee`,Sales WHERE Employee.employeeID= Sales.employeeID AND Sales.recID=" + textRecID.getText();
            Connection conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery(invoiceMakerQuery);
            rs.first();
            JOptionPane.showMessageDialog(null, rs.getString("employeeName"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel AddrRec;
    private static javax.swing.JLabel PhoneRec;
    private static javax.swing.JLabel address;
    private static javax.swing.JLabel customerInvoiceName1;
    private static javax.swing.JLabel customerInvoiceName2;
    private static javax.swing.JLabel customerInvoiceName3;
    private static javax.swing.JLabel customerInvoiceName4;
    private static javax.swing.JLabel dots;
    private static javax.swing.JLabel email;
    private javax.swing.JPanel homePanel;
    public static javax.swing.JTable invoicetable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JLabel nameRec;
    private javax.swing.JPanel recPanel;
    public static javax.swing.JTable resultsTable;
    private static javax.swing.JLabel site;
    private javax.swing.JLabel slogan;
    private javax.swing.JTextField textRecID;
    // End of variables declaration//GEN-END:variables
}
