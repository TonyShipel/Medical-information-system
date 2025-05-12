/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package birthday;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import postgre.postgre;

/**
 *
 * @author Tony Valenciya
 */
public class bday extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public bday() {
         FlatLaf.registerCustomDefaultsSource("Theme");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        initComponents();
        cal_load();
    }

     
    HighlightEvaluator evaluator = new HighlightEvaluator();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bday = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        fiotbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        vozrast = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Дни рождения");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Дни рождения сотрудников"));

        fiotbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ФИО", "Должность", "Телефон"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fiotbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiotblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fiotbl);
        if (fiotbl.getColumnModel().getColumnCount() > 0) {
            fiotbl.getColumnModel().getColumn(0).setResizable(false);
            fiotbl.getColumnModel().getColumn(0).setPreferredWidth(150);
            fiotbl.getColumnModel().getColumn(1).setResizable(false);
            fiotbl.getColumnModel().getColumn(1).setPreferredWidth(150);
            fiotbl.getColumnModel().getColumn(2).setResizable(false);
            fiotbl.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Возраст:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bday, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vozrast, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vozrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bday.addPropertyChangeListener("calendar", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
                cal_load();
                tbl_load();
                vozrast.setText("");
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fiotblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiotblMouseClicked
        age_load();
    }//GEN-LAST:event_fiotblMouseClicked

    
    
    public static class HighlightEvaluator implements IDateEvaluator {

        private final List<Date> list = new ArrayList<>();
        public Color color1 = Color.GREEN.darker();

        public void add(Date date) {
            list.add(date);
        }

        public void clearAll() {
            list.clear();
        }

        public void setColor(Color color) {
            this.color1 = color;
        }

        public void remove(Date date) {
            list.remove(date);
        }

        public void setDates(List<Date> dates) {
            list.addAll(dates);
        }

        @Override
        public Color getInvalidBackroundColor() {
            return Color.BLACK;
        }

        @Override
        public Color getInvalidForegroundColor() {
            return null;
        }

        @Override
        public String getInvalidTooltip() {
            return null;
        }

        @Override
        public Color getSpecialBackroundColor() {
            return color1;
        }

        @Override
        public Color getSpecialForegroundColor() {
            return Color.RED;
        }

        @Override
        public String getSpecialTooltip() {
            return "День рождения";
        }

        @Override
        public boolean isInvalid(Date date) {
            return false;
        }

        @Override
        public boolean isSpecial(Date date) {
            return list.contains(date);
        }
    }
    
    public void cal_load() {

            
            try {
                
                Connection con1 = postgre.connectToMedicalZapisDatabase();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String sql0 = "SELECT \n" +
                        "  CONCAT(\n" +
                        "    date_part('year', current_date), '-',  \n" +
                        "    to_char(date_part('month', doc_db), 'FM00'), '-',  \n" +
                        "    to_char(date_part('day', doc_db), 'FM00')\n" +
                        "  ) as bday \n" +
                        "FROM doctor_table;   ";
                
//String sql0 = "select doc_db from doctor_table";

try (PreparedStatement pst = con1.prepareStatement(sql0);
        ResultSet rs = pst.executeQuery()){
    while (rs.next()) {
        Date date6 = sdf.parse(rs.getString("bday"));
        evaluator.add(date6);
    }
    bday.getDayChooser().addDateEvaluator(evaluator);
    bday.setCalendar(bday.getCalendar());
    con1.close();
} catch (Exception e) {
    System.err.println(e.getMessage());
}

            } catch (SQLException ex) {
                Logger.getLogger(bday.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public void tbl_load(){
         try {
            Connection con1 = postgre.connectToMedicalZapisDatabase();
            SimpleDateFormat Date_Format = new SimpleDateFormat("MM-dd");
            String date = Date_Format.format(bday.getDate());
            PreparedStatement pst = con1.prepareStatement("SELECT doc_name,doc_cat,doc_phone FROM doctor_table WHERE doc_db::text LIKE '%"+date+"';");
            ResultSet rst = pst.executeQuery();
            ResultSetMetaData rsd = rst.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel) fiotbl.getModel();
            d.setRowCount(0);
            while (rst.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rst.getString("doc_name"));
                    v2.add(rst.getString("doc_cat"));
                    v2.add(rst.getString("doc_phone"));
                }
                d.addRow(v2);
            }
            pst.close();
            rst.close();
            con1.close();
        } catch (SQLException ex) {
        System.err.println(ex.getMessage());}
    }
    
    public void age_load(){
         try {
             DefaultTableModel d1 = (DefaultTableModel) fiotbl.getModel();
             int selectIndex = fiotbl.getSelectedRow();
             String fio = d1.getValueAt(selectIndex, 0).toString();
            Connection con1 = postgre.connectToMedicalZapisDatabase();
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String date = Date_Format.format(bday.getDate());
            PreparedStatement pst = con1.prepareStatement("SELECT date_part('year', age('"+date+"', doc_db)) AS age\n" +
"FROM doctor_table\n" +
"WHERE doc_name = '"+fio+"' ");
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
               vozrast.setText(rst.getString("age"));
            }
            pst.close();
            rst.close();
            con1.close();
        } catch (SQLException ex) {
        System.err.println(ex.getMessage());}
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bday.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bday().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar bday;
    private javax.swing.JTable fiotbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel vozrast;
    // End of variables declaration//GEN-END:variables
}
