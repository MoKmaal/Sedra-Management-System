/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import Database.Connect;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import sedra.Colors;

/**
 *
 * @author mohammed
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1(String date) throws SQLException {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultTableModel defaultTableModel = (DefaultTableModel) report.getModel();
        defaultTableModel.setRowCount(0);
        Connection conn = DriverManager.getConnection(Connect.URL, Connect.HOST_NAME, Connect.PASSWORD);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Report WHERE time LIKE '" + date + "'");
        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        while (rs.next()) {
            
            System.out.println("print");
            String s0 = rs.getString(2);
            String s1 = rs.getString(3);
            String s2 = rs.getString(4);

            ResultSet res = stmt1.executeQuery("SELECT SUM(salesQuantity),SUM(salesPaid) FROM Sales WHERE itemID= '" + s0 + "' AND Size='" + s1 + "'");
            res.next();
            String s3 = res.getString(1);
            String s6 = res.getString(2);
            File f = new File("Store/Store" + ".txt");
            if (f.exists()) {
                Scanner s = null;
                try {
                    s = new Scanner(f);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
                }
                int temp = 0;
                while (s.hasNext()) {
                    StringTokenizer st = new StringTokenizer(s.nextLine(), ",");
                    String[] arr = new String[st.countTokens()];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = st.nextToken();
                    }
                    if (arr[1].equalsIgnoreCase(s0) && arr[2].equalsIgnoreCase(s1)) {
                        temp += Integer.valueOf(arr[3]);
                    }
                }
                String s4 = String.valueOf(temp);
                ResultSet result = stmt2.executeQuery("SELECT itemDocPrice,itemQuantity FROM Store WHERE itemID= '" + s0 + "' AND itemSize='" + s1 + "'");
                result.next();
                
                    System.out.println("result next");
                int pricePaid = Integer.parseInt(result.getString(1));
                int totalStoreQuantity = Integer.parseInt(result.getString(2));
                String s5 = String.valueOf(pricePaid * Integer.parseInt(s4));
                String s7 = String.valueOf(pricePaid * totalStoreQuantity);
                String s8 = String.valueOf(Integer.parseInt(s4)-Integer.parseInt(s3)+Integer.parseInt(s2));
                Object data[] = {s7, s6, s5, s4, s3, s2, s1, s0,s8};

                defaultTableModel.addRow(data);
                
            }

        }
        stmt.close();
        conn.close();
        float temp = 0;
        File f = new File("payment/total payment" + ".txt");
        if (f.exists()) {
            Scanner s = null;
            try {
                s = new Scanner(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
            }
            temp = 0;
            while (s.hasNext()) {
                StringTokenizer st = new StringTokenizer(s.nextLine(), ",");
                String[] arr = new String[st.countTokens()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = st.nextToken();
                }
                System.err.println(arr[0]);
                System.err.println(date);
                if (arr[0].contains(date)) {
                    System.out.println("truesssssss");
                    temp += Float.parseFloat(arr[1]);
                }
            }

        }
        jLabel1.setText(temp + "اجمالى ايرادات الشهر ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        report = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(Colors.HEAD_COLOR);

        report.setBackground(new java.awt.Color(255, 255, 255));
        report.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        report.setForeground(Colors.LABELS_COLOR);
        report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "سعر المخزن", "ايرادات", "مصروفات", "عدد الشراء", "عدد البيع", "عدد بداية الشهر", "الحجم", "الكود", "عدد مخزن"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(report);
        if (report.getColumnModel().getColumnCount() > 0) {
            report.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            // TODO add your handling code here:
            report.print();
        } catch (PrinterException ex) {
            Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable report;
    // End of variables declaration//GEN-END:variables
}
