/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Earphone;
import Models.Keyboard;
import Models.Keycap;
import Models.Kit;
import Models.Mouse;
import Models.Product;
import Models.Switch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HIEU
 */
public class ProductDAO {

    Connection conn;

    public ProductDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getAllProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from Product join Keyboard on Product.pro_id = Keyboard.pro_id");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getAll() {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery("select * from product join category on product.category_id = category.product_id");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductByCategory(String pro_category) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product where pro_category=?");
            ps.setString(1, pro_category);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Keycap getKeycapDetails(int pro_id) {
        ResultSet rs = null;
        Keycap key = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Keycap k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                key = new Keycap(rs.getInt("kc_id"), rs.getString("kc_material"), rs.getString("kc_layout"), rs.getString("kc_thickness"), rs.getString("kc_reliability"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public ResultSet getSimilarProduct(String category, int pro_id) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p where pro_id != ? and p.pro_category=?");
            ps.setInt(1, pro_id);
            ps.setString(2, category);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Keyboard getKeyboardDetails(int pro_id) {
        ResultSet rs = null;
        Keyboard key = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Keyboard k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                key = new Keyboard(rs.getInt("kb_id"), rs.getString("kb_led"), rs.getString("kb_mode"), rs.getString("kb_switch"), rs.getString("kb_keycap"), rs.getString("kb_case"), rs.getString("kb_plate"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public Kit getKitDetails(int pro_id) {
        ResultSet rs = null;
        Kit kit = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Kit k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                kit = new Kit(rs.getInt("kit_id"), rs.getString("kit_layout"), rs.getString("kit_circuit"), rs.getString("kit_plate"), rs.getString("kit_mode"), rs.getString("kit_case"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kit;
    }

    public Switch getSwitchDetails(int pro_id) {
        ResultSet rs = null;
        Switch swi = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Switch k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                swi = new Switch(rs.getInt("switch_id"), rs.getString("switch_pin"), rs.getString("switch_type"), rs.getString("switch_spring"), rs.getString("switch_reliability"), rs.getString("switch_depth"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return swi;
    }

    public Mouse getMouseDetails(int pro_id) {
        ResultSet rs = null;
        Mouse mouse = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Mouse k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                mouse = new Mouse(rs.getInt("mouse_id"), rs.getString("mouse_dpi"), rs.getString("mouse_wire_length"), rs.getString("mouse_led"), rs.getString("mouse_type_battery"), rs.getString("mouse_weight"), rs.getString("mouse_compatibility"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mouse;
    }

    public Earphone getEarphoneDetails(int pro_id) {
        ResultSet rs = null;
        Earphone ear = null;
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p join Earphone k on p.pro_id = k.pro_id where p.pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                ear = new Earphone(rs.getInt("ear_id"), rs.getString("ear_type"), rs.getString("ear_plug"), rs.getString("ear_compatibility"), rs.getString("ear_wire_length"), rs.getString("ear_utility"), rs.getString("ear_connect"), rs.getString("ear_control"), rs.getString("ear_charging_port"), rs.getString("ear_connect_tech"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ear;
    }

    public boolean addCard(int id, int quantity, String username) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Cart values(?,?,?)");
            ps.setString(1, username);
            ps.setInt(2, id);
            ps.setInt(3, quantity);
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count != 0);
    }

    public int updateQuantityProduct(int quantity, int pro_id) {
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET pro_quantity = pro_quantity - ? WHERE pro_id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int getProductQuantity(int pro_id) {
        int quantity = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from Product where pro_id = ?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("pro_quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantity;
    }


    public Product getProduct(int pro_id) {
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where pro_id= ?");
            ps.setInt(1, pro_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public List<Product> getProductSearch(String pro_name) {
        List<Product> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product where pro_name like ?");
            ps.setString(1, "%" + pro_name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_name(rs.getString("pro_name"));
                pro.setPro_quantity(rs.getInt("pro_quantity"));
                pro.setPro_price(rs.getString("pro_price"));
                pro.setPro_image(rs.getString("pro_image"));
                pro.setPro_description(rs.getString("pro_description"));
                pro.setPro_discount(rs.getString("pro_discount"));
                pro.setPro_category(rs.getString("pro_category"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void deleteProduct(int pro_id) {
        try {
            PreparedStatement ps = conn.prepareStatement("update product set pro_quantity = 0 where pro_id =?");
            ps.setInt(1, pro_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Product addNew(Product newPro) {
        int count = 0;
        ResultSet rs = null;
        java.util.Date dateToInsert = new java.util.Date();
        Date sqlDate = new Date(dateToInsert.getTime());
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into product values(?,?,?,?,?,?,?,?)");
            ps.setString(1, newPro.getPro_name());
            ps.setInt(2, newPro.getPro_quantity());
            ps.setString(3, newPro.getPro_price());
            ps.setString(4, newPro.getPro_image());
            ps.setString(5, newPro.getPro_description());
            ps.setString(6, newPro.getPro_discount());
            ps.setDate(7, sqlDate);
            ps.setString(8, newPro.getPro_category());
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newPro;
    }

    public Product getProductByID(int pro_id) {
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product where pro_id= ?");
            ps.setInt(1, pro_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }
    public ResultSet get2NewProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select top 2 * from Product order by pro_id desc");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getNewProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select top 8 * from Product order by pro_id desc");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
}
