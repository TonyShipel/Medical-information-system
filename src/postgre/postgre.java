/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony Valenciya
 */
public class postgre {
    private static Connection con;
    private static Connection con1;
    private static Connection con2;

    public static Connection connectToLegacyDatabase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Legacy", "postgres", "227877");
           
            return con;
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Нет подключения к базе данных, программа будет закрыта",
                        "Ошибка", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            return null;
        }
    }

    public static Connection connectToMedicalZapisDatabase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
           con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medical_zapis", "postgres", "227877");
           
        } catch (ClassNotFoundException ignored) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static Connection connectToTalonDatabase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Legacy", "postgres", "227877");
          
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
