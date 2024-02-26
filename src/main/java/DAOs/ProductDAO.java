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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                key = new Keycap(rs.getInt("kc_id"), rs.getString("kc_material"), rs.getString("kc_layout"), rs.getString("kc_thickness"), rs.getString("kc_reliability"), pro);
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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                key = new Keyboard(rs.getInt("kb_id"), rs.getString("kb_led"), rs.getString("kb_mode"), rs.getString("kb_switch"), rs.getString("kb_keycap"), rs.getString("kb_case"), rs.getString("kb_plate"), pro);
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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                kit = new Kit(rs.getInt("kit_id"), rs.getString("kit_layout"), rs.getString("kit_circuit"), rs.getString("kit_plate"), rs.getString("kit_mode"), rs.getString("kit_case"), pro);
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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                swi = new Switch(rs.getInt("switch_id"), rs.getString("switch_pin"), rs.getString("switch_type"), rs.getString("switch_spring"), rs.getString("switch_reliability"), rs.getString("switch_depth"), pro);
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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                mouse = new Mouse(rs.getInt("mouse_id"), rs.getString("mouse_dpi"), rs.getString("mouse_wire_length"), rs.getString("mouse_led"), rs.getString("mouse_type_battery"), rs.getString("mouse_weight"), rs.getString("mouse_compatibility"), pro);
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
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
                ear = new Earphone(rs.getInt("ear_id"), rs.getString("ear_type"), rs.getString("ear_plug"), rs.getString("ear_compatibility"), rs.getString("ear_wire_length"), rs.getString("ear_utility"), rs.getString("ear_connect"), rs.getString("ear_control"), rs.getString("ear_charging_port"), rs.getString("ear_connect_tech"), pro);
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

    public ResultSet getProductByID(int product_id) {
        ResultSet rs = null;
        ResultSet main = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where pro_id=?");
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                main = rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return main;
    }

    public Product getProduct(int pro_id) {
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where pro_id= ?");
            ps.setInt(1, pro_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getString("pro_category"));
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

    public Keyboard addNewKeyBoard(Keyboard newKeyboard) {
        int count = 0;
        ResultSet rs = null;
        int pro_id = getPro_id();
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Keyboard values(?,?,?,?,?)");
            ps.setString(1, newKeyboard.getLed());
            ps.setString(2, newKeyboard.getMode());
            ps.setString(3, newKeyboard.getSwitch());
            ps.setString(4, newKeyboard.getKeycap());
            ps.setInt(5, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKeyboard;
    }

    public Kit addNewKit(Kit newKit) {
        int count = 0;
        ResultSet rs = null;
        int pro_id = getPro_id();
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Kit values(?,?,?,?,?,?)");
            ps.setString(1, newKit.getLayout());
            ps.setString(2, newKit.getCurcuit());
            ps.setString(3, newKit.getPlate());
            ps.setString(4, newKit.getMode());
            ps.setString(5, newKit.getCase());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKit;
    }

    public Keycap addNewKeycap(Keycap newKeycap) {
        int count = 0;
        ResultSet rs = null;
        int pro_id = getPro_id();
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Keycap values(?,?,?,?,?)");
            ps.setString(1, newKeycap.getKc_material());
            ps.setString(2, newKeycap.getKc_layout());
            ps.setString(3, newKeycap.getKc_thickness());
            ps.setString(4, newKeycap.getKc_reliability());
            ps.setInt(5, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKeycap;
    }

    public Switch addNewSwitch(Switch newSwitch) {
        int count = 0;
        ResultSet rs = null;
        int pro_id = getPro_id();
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Switch values(?,?,?,?,?,?)");
            ps.setString(1, newSwitch.getSwitch_pin());
            ps.setString(2, newSwitch.getSwitch_type());
            ps.setString(3, newSwitch.getSwitch_spring());
            ps.setString(4, newSwitch.getSwitch_reliability());
            ps.setString(5, newSwitch.getSwitch_depth());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newSwitch;
    }

    public int getPro_id() {
        ResultSet rs = null;
        int pro_id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT top 1 pro_id FROM Product ORDER BY pro_id DESC");
            rs = ps.executeQuery();
            if (rs.next()) {
                pro_id = rs.getInt("pro_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro_id;
    }

    public void deletePro(int pro_id) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from product where pro_id =?");
            ps.setInt(1, pro_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getProductToStatics(String str) {
        ResultSet rs = null;
        try {
            Date date = Date.valueOf(str);
            PreparedStatement ps = conn.prepareStatement("select  o.username, o.order_name, p.pro_name, od.quantity, od.totalMoney, o.order_date  from Orders_details od  join Product p\n"
                    + "on od.pro_id = p.pro_id join Orders o\n"
                    + "on o.id = od.order_id\n"
                    + "where (o.order_date) = ? and o.order_status = 'Accept'");
            ps.setDate(1, date);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet getProductToStaticsForMonth(String str) {
        ResultSet rs = null;
        try {
            int month = Integer.parseInt(str);

            PreparedStatement ps = conn.prepareStatement("select  o.username, o.order_name, p.pro_name, od.quantity, od.totalMoney, o.order_date  from Orders_details od  join Product p\n"
                    + "on od.pro_id = p.pro_id join Orders o\n"
                    + "on o.id = od.order_id\n"
                    + "where month(o.order_date) = ? and o.order_status = 'Accept'");
            ps.setInt(1, month);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet getProductToStaticsForYear(String str) {
        ResultSet rs = null;
        try {
            int month = Integer.parseInt(str);

            PreparedStatement ps = conn.prepareStatement("select  o.username, o.order_name, p.pro_name, od.quantity, od.totalMoney, o.order_date  from Orders_details od  join Product p\n"
                    + "on od.pro_id = p.pro_id join Orders o\n"
                    + "on o.id = od.order_id\n"
                    + "where year(o.order_date) = ? and o.order_status = 'Accept'");
            ps.setInt(1, month);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet getProductBestSeller() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select  distinct top 8 (od.pro_id), p.pro_name,p.pro_image, p.pro_price,p.pro_quantity,p.pro_discount,p.pro_category,sum(od.quantity) as \"So luong ban ra\" from \n"
                    + "Orders_details od join Product p\n"
                    + "on od.pro_id = p.pro_id\n"
                    + "group by (od.pro_id), p.pro_name,p.pro_image, p.pro_price,p.pro_quantity,p.pro_discount,p.pro_category\n"
                    + "order by sum(od.quantity) desc");
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

    public Product update(int pro_id, int cate_id, Product newinfo) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update product set pro_name=?, pro_quantity=?, pro_price=?, pro_image=?, pro_description=?, pro_discount=?, category_id=? where pro_id=?");
            ps.setString(1, newinfo.getPro_name());
            ps.setInt(2, newinfo.getPro_quantity());
            ps.setString(3, newinfo.getPro_price());
            ps.setString(4, newinfo.getPro_image());
            ps.setString(5, newinfo.getPro_description());
            ps.setString(6, newinfo.getPro_discount());
            ps.setInt(7, cate_id);
            ps.setInt(8, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfo;
    }

    public Keyboard updateKeyboard(int pro_id, Keyboard newinfoKeyboard) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update keyboard set led=?, mode=?, switch=?, keycap=? where pro_id=?");
            ps.setString(1, newinfoKeyboard.getLed());
            ps.setString(2, newinfoKeyboard.getMode());
            ps.setString(3, newinfoKeyboard.getSwitch());
            ps.setString(4, newinfoKeyboard.getKeycap());
            ps.setInt(5, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKeyboard;
    }

    public Kit updateKit(int pro_id, Kit newinfoKit) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update kit set layout=?, mach=?, plate=?, mode=?, [case]=? where pro_id=?");
            ps.setString(1, newinfoKit.getLayout());
            ps.setString(2, newinfoKit.getCurcuit());
            ps.setString(3, newinfoKit.getPlate());
            ps.setString(4, newinfoKit.getMode());
            ps.setString(5, newinfoKit.getCase());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKit;
    }

    public Switch updateSwitch(int pro_id, Switch newinfoSwitch) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update switch set pin=?, type=?, lo_xo=?, do_ben=?, hanh_trinh=? where pro_id=?");
            ps.setString(1, newinfoSwitch.getSwitch_pin());
            ps.setString(2, newinfoSwitch.getSwitch_type());
            ps.setString(3, newinfoSwitch.getSwitch_spring());
            ps.setString(4, newinfoSwitch.getSwitch_reliability());
            ps.setString(5, newinfoSwitch.getSwitch_depth());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoSwitch;
    }

    public Keycap updateKeycap(int pro_id, Keycap newinfoKeycap) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update keycap set chatlieu=?, layout=?, doday=?, doben=? where pro_id=?");
            ps.setString(1, newinfoKeycap.getKc_material());
            ps.setString(2, newinfoKeycap.getKc_layout());
            ps.setString(3, newinfoKeycap.getKc_thickness());
            ps.setString(4, newinfoKeycap.getKc_reliability());
            ps.setInt(5, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKeycap;
    }

}
