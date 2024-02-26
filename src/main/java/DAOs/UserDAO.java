/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
