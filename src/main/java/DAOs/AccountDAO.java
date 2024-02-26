/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class AccountDAO {

    Connection conn;

    public AccountDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account checkLogin(String gmail, String password) {
        Account acc = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account where acc_gmail=? and acc_password=?");
            ps.setString(1, gmail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                acc = new Account();
                acc.setGmail(rs.getString("acc_gmail"));
                acc.setPassword(rs.getString("acc_password"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return acc;
    }

    public boolean checkSignIn(String gmail) {
        Account acc = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account where acc_gmail=?");
            ps.setString(1, gmail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int getProductIDLastest() {
        int proID = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT top 1 acc_id FROM Account ORDER BY acc_id DESC");
            while (rs.next()) {
                proID = rs.getInt("acc_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proID;
    }
    
    public Account addAccount(Account acc) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Account values (?,?)");
            ps.setString(1, acc.getGmail());
            ps.setString(2, acc.getPassword());
            count  = ps.executeUpdate();
            
            if(count > 0) {
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
