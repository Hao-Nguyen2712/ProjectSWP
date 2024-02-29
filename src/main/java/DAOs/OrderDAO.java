/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class OrderDAO {

    Connection conn;

    public OrderDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalMoney(int user_id) {
        int totalMoney = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Cart c join Product p on c.pro_id = p.pro_id where user_id = ?");
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalMoney += rs.getInt("pro_price") * rs.getInt("cart_quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalMoney;
    }

    public int getOrderID(int user_id) {
        int order_id = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT TOP 1 * FROM Orders where user_id = ? ORDER BY order_id DESC");
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                order_id = rs.getInt("order_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order_id;
    }

    public Order addOrder(Order order, int user_id) {
        int count = 0;
        java.util.Date dateToInsert = new java.util.Date();
        Date sqlDate = new Date(dateToInsert.getTime());
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Orders values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, user_id);
            ps.setDate(2, sqlDate);
            ps.setString(3, order.getOrder_status());
            ps.setString(4, order.getOrder_name());
            ps.setInt(5, order.getOrder_totalMoney());
            ps.setString(6, order.getOrder_phone());
            ps.setString(7, order.getOrder_email());
            ps.setString(8, order.getOrder_address());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (count == 0) ? null : order;
    }
}
