/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class CartDAO {

    Connection conn;

    public CartDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addCard(int pro_id, int quantity, int user_id) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Cart values(?,?,?)");
            ps.setInt(1, user_id);
            ps.setInt(2, pro_id);
            ps.setInt(3, quantity);
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count != 0);
    }

    public boolean checkContainCart(int pro_id, int user_id) {
        ArrayList<Integer> listProId = new ArrayList<>();
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select pro_id from Cart where user_id=?");
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProId.add(rs.getInt("pro_id"));
            }
            if (!listProId.isEmpty()) {
                for (Integer integer : listProId) {
                    if (integer == pro_id) {
                        return false;
                    }
                }
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int updateQuantityProductInCart(int quantity, int pro_id, int user_id) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update Cart set cart_quantity = cart_quantity + ? WHERE pro_id = ? and user_id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, pro_id);
            ps.setInt(3, user_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public int updateQuantityProductInCartPage(int quantity, int pro_id, int user_id) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update Cart set cart_quantity = ? WHERE pro_id = ? and user_id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, pro_id);
            ps.setInt(3, user_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ResultSet getProductInCart(int user_id) {
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from Cart c join Product p on c.pro_id = p.pro_id where c.user_id = ?");
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int DeleteProductInCart(int user_id, int pro_id) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("delete from Cart where user_id = ? and pro_id= ? ");
            ps.setInt(1, user_id);
            ps.setInt(2, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public void deleteCart(int user_id) {
        int count = 0;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("delete from Cart where user_id = ?");
            ps.setInt(1, user_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}
