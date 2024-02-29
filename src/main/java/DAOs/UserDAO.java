/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class UserDAO {

    Connection conn;

    public UserDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User addUser(User user) {
        int count = 0;
        AccountDAO aDAO = new AccountDAO();
        int accID = aDAO.getProductIDLastest();
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into [User] values (?,?,?,?)");
            ps.setString(1, user.getUser_fullName());
            ps.setString(2, user.getUser_phoneNumber());
            ps.setString(3, user.getUser_address());
            ps.setInt(4, accID);

            count = ps.executeUpdate();

            if (count > 0) {
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUser(String email) {
        ResultSet rs = null;
        User users = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from Account acc join [User] u on acc.acc_id = u.acc_id where acc.acc_gmail = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                users = new User(0, rs.getString("user_fullname"), rs.getString("user_sdt"), rs.getString("user_address"), 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

}
